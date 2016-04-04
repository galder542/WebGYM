package GYMWeb;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import helper.db.*;

public class SignupServlet extends HttpServlet {

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("---> Entering doPost() SignupServlet");

		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String username = request.getParameter("username");
		String surname = request.getParameter("surname");
		String address = request.getParameter("address");
		String pcode = request.getParameter("postcode");
		String phone = request.getParameter("phone");

		System.out.println("     Extracting request parameters: " + email + " " + password + " " + username + " "
				+ surname + " " + address + " " + pcode + " " + phone);
		String query = "INSERT INTO WebsistemakGYM.User(UserName, UserSurname, Password, Address, Email, PostCode, Phone) VALUES ('"
				+ username + "','" + surname + "','" + password + "','" + address + "','" + email + "','" + pcode
				+ "','" + phone + "');";
		MySQLdb.getMysqlDb().aginduaExekutatu(query);
		System.out.println("     DB query: " + query);
		System.out.println("     Updating users table in the database");

		System.out.println("     Redirecting the user to loginForm.html");
		RequestDispatcher rdis = request.getRequestDispatcher("/html/loginForm.html");
		rdis.forward(request, response);

		System.out.println("---> Exiting doPost() SignupServlet");
	}
}
