package GYMWeb;

import java.io.FileOutputStream;
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

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import helper.db.MySQLdb;

/**
 * Servlet implementation class InfoToPDFServlet
 */
@WebServlet("/InfoToPDFServlet")
public class InfoToPDFServlet extends HttpServlet {

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

			documento.add(new Paragraph("This is " + user + "'s information"));
			documento.add(new Paragraph(" "));
			
			PdfPTable table = new PdfPTable(7);
			table.addCell("Id");
			table.addCell("User Name");
			table.addCell("User Surname");
			table.addCell("Address");
			table.addCell("Email");
			table.addCell("Post Code");
			table.addCell("Phone");

			String query = "SELECT UserId, UserName, UserSurname, Address, Email, PostCode, Phone FROM WebsistemakGYM.User WHERE Username = '"
					+ user + "'";
			ResultSet rs = MySQLdb.getMysqlDb().queryExekutatu(query);
			ArrayList<String> arraydatos = new ArrayList<String>();
			System.out.println("soy error");

			rs.next();
			System.out.println("soy itonto");
			int kop = rs.getMetaData().getColumnCount();
			for (int i = 0; i < kop; i++) {
				table.addCell(rs.getString(i + 1));
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