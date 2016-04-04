package GYMWeb;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import helper.db.MySQLdb;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * Servlet implementation class RoutineToPDFServlet
 */
@WebServlet("/RoutineToPDFServlet")
public class RoutineToPDFServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			response.setContentType("application/pdf");
			ServletOutputStream archivo = response.getOutputStream();
			Document documento = new Document();
			PdfWriter.getInstance(documento, archivo);
			documento.open();

			HttpSession session = request.getSession();
			String user = (String) session.getAttribute("username");
			System.out.println("this is your user: " + user);

			documento.add(new Paragraph("This is " + user + "'s routine"));
			documento.add(new Paragraph(" "));
			
			PdfPTable table = new PdfPTable(2);
			table.addCell("Exercise");
			table.addCell("Reps");

			String query2 = "SELECT Exercise,Reps FROM WebsistemakGYM.Routine WHERE UserName = '" + user + "'";
			System.out.println(query2);
			ResultSet rs = MySQLdb.getMysqlDb().queryExekutatu(query2);
			while (rs.next()) {
				for (int i = 0; i < rs.getMetaData().getColumnCount(); i++) {
					table.addCell(rs.getString(i + 1));
				}
			}
			documento.add(table);
			documento.close();

			RequestDispatcher rdis2 = request.getRequestDispatcher("/html/UserOptions.html");
			rdis2.forward(request, response);

		} catch (DocumentException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

}
