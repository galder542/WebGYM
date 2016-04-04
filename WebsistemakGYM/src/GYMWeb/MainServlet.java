package GYMWeb;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

import helper.db.*;
import helper.info.*;

public class MainServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("---> Entering doGet() MainServlet");

		RequestDispatcher rdis = request.getRequestDispatcher("/html/Welcome.html");
		rdis.forward(request, response);
		System.out.println("---> Exiting doGet() MainServlet");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
