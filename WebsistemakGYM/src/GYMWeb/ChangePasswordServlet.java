package GYMWeb;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.websocket.Session;

import helper.db.*;

public class ChangePasswordServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("---> Entering doPost() SignupServlet");

		String oldPassword = request.getParameter("Oldpassword");
		String newPassword = request.getParameter("Newpassword");

		System.out.println("     Extracting request parameters: " + oldPassword + " " + newPassword);
//cambiapass
		
		HttpSession session = request.getSession();
		String user = (String) session.getAttribute("username");
		System.out.println(user);
		String query = "UPDATE WebsistemakGYM.User SET Password='" + newPassword + "' WHERE UserName ='" + user
				+ "' AND Password='" + oldPassword + "'";
		System.out.println("     DB query: " + query);
		MySQLdb.getMysqlDb().aginduaExekutatu(query);
		
		
		System.out.println("     Updating users table in the database");

		System.out.println("     Redirecting the user to OptionServlet");
		RequestDispatcher rdis = request.getRequestDispatcher("/servlet/OptionServlet");
		rdis.forward(request, response);
		// response.sendRedirect("/html/loginForm.html");

		System.out.println("---> Exiting doPost() SignupServlet");
	}
}
