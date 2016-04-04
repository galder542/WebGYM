package GYMWeb;

import java.io.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;

import helper.db.*;

public class LoginServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String user = request.getParameter("user");
		String password = request.getParameter("password");
		System.out.println("     Extracting request parameters: " + user + " " + password);
	
		String query = "SELECT UserName FROM WebsistemakGYM.User WHERE UserName='" + user + "' AND Password='" + password + "';";
		System.out.println("     DB query: " + query);
		ResultSet rs = MySQLdb.getMysqlDb().queryExekutatu(query);
		try {
			if (!rs.next()) {
				System.out.println(" --------> Login error: redirecting the user to loginForm.jsp");
				boolean loginerror = true;
				request.setAttribute("login_error", loginerror);
				response.setHeader("Cache-Control", "no-cache");
				RequestDispatcher rdis2 = request.getRequestDispatcher("/jsp/loginForm.jsp");
				rdis2.forward(request, response);
			} else {
				HttpSession session = request.getSession(true); // SESIOA SORTU
				session.setAttribute("username", user); // ERABILTZAILEA ATERA
				String sessionID = session.getId(); // SESIOAREN ID ATERA
				System.out.println("     User session for " + user + ": " + sessionID);
				System.out.print("     Getting loggedin userlist from servlet context: ");
				ServletContext context = request.getServletContext(); // TESTUINGURUA
																		// ATERA
				HashMap<String, String> loggedinUsers = (HashMap) context.getAttribute("loggedin_users");
				if (loggedinUsers == null) {
					System.out.println("list is empty");
					loggedinUsers = new HashMap();
					loggedinUsers.put(user, sessionID);
				} else {
					if (!loggedinUsers.containsKey(user)) {
						System.out.println(user + " is not in the list");
						loggedinUsers.put(user, sessionID);
					} else {
						System.out.println(user + " is already in the list");
					}
				}
				context.setAttribute("loggedin_users", loggedinUsers);
				System.out.println("     Loggedin users: " + loggedinUsers.toString());

				System.out.println("     Redirecting the user to OptionServlet");
				RequestDispatcher rdis = context.getNamedDispatcher("OptionServlet");
				rdis.forward(request, response);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("---> Exiting doGet() LoginServlet");
	}
}
