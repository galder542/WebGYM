package GYMWeb;

import java.io.*;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.*;
import javax.servlet.http.*;

import org.apache.el.stream.Stream;

import helper.db.*;

public class EditInfoServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("---> Entering doPost() SignupServlet");

		String[] cajita = new String[6];
		System.out.println(request.getParameter("username"));
		cajita[0] = request.getParameter("username");
		cajita[1] = request.getParameter("surname");
		cajita[2] = request.getParameter("address");
		cajita[3] = request.getParameter("email");
		cajita[4] = request.getParameter("postcode");
		cajita[5] = request.getParameter("phone");
		
		
		System.out.println("     Extracting request parameters: " + cajita[0] + " " + cajita[1] + " " + cajita[2] + " "
				+ cajita[3] + " " + cajita[4] + " " + cajita[5]);
		String query = "SELECT * from WebsistemakGYM.User";
		HttpSession session = request.getSession();
		String user = (String) session.getAttribute("username");
		System.out.println(user);
		ResultSet rs = MySQLdb.getMysqlDb().queryExekutatu(query);

		try {
			rs.next();
			for (int i = 0; i < cajita.length; i++) {
				if (cajita[i].trim().equals(""))
					cajita[i] = rs.getString(i+1);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		query = "UPDATE WebsistemakGYM.User SET UserName='" + cajita[0] + "', UserSurname= '" + cajita[1] + "', Address= '"
				+ cajita[2] + "', Email= '" + cajita[3] + "', PostCode= '" + cajita[4] + "', Phone='" + cajita[5] + "' WHERE UserName='"+user+"'";
		System.out.println("     DB query: " + query);
		MySQLdb.getMysqlDb().aginduaExekutatu(query);
		System.out.println("     Updating users table in the database");
		
		String query2 = "UPDATE WebsistemakGYM.Routine SET UserName='"+cajita[0]+"'WHERE UserName='"+user+"'";
		System.out.println("     DB query: " + query2);
		MySQLdb.getMysqlDb().aginduaExekutatu(query2);
		System.out.println("     Updating routine table in the database");
		session.setAttribute("username", cajita[0]);

		
		
		System.out.println("     Redirecting the user to OptionServlet");
		RequestDispatcher rdis = request.getRequestDispatcher("/servlet/OptionServlet");
		rdis.forward(request, response);
		// response.sendRedirect("/html/loginForm.html");

		System.out.println("---> Exiting doPost() SignupServlet");
	}
}
