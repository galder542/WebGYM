package GYMWeb;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import helper.db.MySQLdb;
import helper.info.MessageInfo;

public class ShowInfoServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		String user = (String) session.getAttribute("username");
		System.out.println("this is your user: " + user);

		String query = "SELECT UserId, UserName, UserSurname, Address, Email, PostCode, Phone FROM WebsistemakGYM.User WHERE Username = '"
				+ user + "'";
		ResultSet rs = MySQLdb.getMysqlDb().queryExekutatu(query);
		ArrayList<String> arraydatos = new ArrayList<String>();
		System.out.println("soy error");
		try {
			rs.next();
			System.out.println("soy itonto");
			int kop = rs.getMetaData().getColumnCount();
			for (int i = 0; i < kop; i++) {
				arraydatos.add(rs.getString(i+1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("messageList", arraydatos);
		
		String query2 = "SELECT Exercise,Reps FROM WebsistemakGYM.Routine WHERE UserName = '" + user + "'";
		System.out.println(query2);
		rs = MySQLdb.getMysqlDb().queryExekutatu(query2);
		ArrayList<ArrayList<String>> arrayroutine = new ArrayList<ArrayList<String>>();
		try {
			while (rs.next()) {
				ArrayList<String> a = new ArrayList<>();
				for (int i = 0; i < rs.getMetaData().getColumnCount(); i++) {
					a.add(rs.getString(i+1));
				}
				arrayroutine.add(a);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		request.setAttribute("routine", arrayroutine);
		System.out.println("     Redirecting the user to ShowInfo.jsp");
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/ShowInfo.jsp");
		rd.forward(request, response);
	}

}
