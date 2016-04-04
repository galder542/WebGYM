<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.util.*,helper.info.*"%>
<%

	ArrayList<String> arraydatos = (ArrayList<String>)request.getAttribute("messageList");
	String username = (String) session.getAttribute("username");
	ServletContext context = request.getServletContext();
	ArrayList<ArrayList<String>> arrayroutine = (ArrayList<ArrayList<String>>)request.getAttribute("routine");
%>
<html>
<head>
<title>Show User`s info</title>
<link href="/WebsistemakGYM/css/styleSheet.css" rel="stylesheet" />
</head>
<body>
	<header>
	<center>
		<IMG SRC="/WebsistemakGYM/img/zyzz_by_loupu-d5ituzq.png" "/>
		<h1>WEB`S GYM</h1>
		<h2>You want, you can</h2>
	</center>
	<h3>Customer`s info and Routine</h3>
	</header>
	<section> <a href="/WebsistemakGYM/servlet/OptionServlet"
		style="text-decoration: none"> <font color="white">Back</font>
	</a> <a href="/WebsistemakGYM/servlet/MainServlet?action=logout"
		style="text-decoration: none"> <font color="white">Logout</font>
	</a> </section>
	<section> <font color="white">You are logged in as: </font> <%=username%>
	</section>
	<section><font color="white">This is your User Information: </font> </section>
	<section> 
	<table>
		<tr>
			<td>User Code</td>
			<td><%=arraydatos.get(0) %>
		</tr>
		<tr>
			<td>User Name</td>
			<td><%=arraydatos.get(1) %>
		</tr>
		<tr>
			<td>User Surname</td>
			<td><%=arraydatos.get(2) %>
		</tr>
		<tr>
			<td>Address</td>
			<td><%=arraydatos.get(3) %>
		</tr>
		<tr>
			<td>E-mail</td>
			<td><%=arraydatos.get(4) %>
		</tr>
		<tr>
			<td>Post-Code</td>
			<td><%=arraydatos.get(5) %>
		</tr>
		<tr>
			<td>Phone Number</td>
			<td><%=arraydatos.get(6) %>
		</tr>
	</table>
	</section>
<%if (!arrayroutine.isEmpty()){ %>
	<section><font color="white">This is your GYM routine: </font> </section>
	<section>
	
	<table>
		<tr>
			<td>Exercise</td>
			<td>Reps</td>
		</tr>
		<tr>
			<td><%=arrayroutine.get(0).get(0) %></td>
			<td><%=arrayroutine.get(0).get(1) %></td>
		</tr>
		<tr>
			<td><%=arrayroutine.get(1).get(0) %></td>
			<td><%=arrayroutine.get(1).get(1) %></td>
		</tr>
		<tr>
			<td><%=arrayroutine.get(2).get(0) %></td>
			<td><%=arrayroutine.get(2).get(1) %></td>
		</tr>
		<tr>
			<td><%=arrayroutine.get(3).get(0) %></td>
			<td><%=arrayroutine.get(3).get(1) %></td>
		</tr>
		<tr>
			<td><%=arrayroutine.get(4).get(0) %></td>
			<td><%=arrayroutine.get(4).get(1) %></td>
		</tr>
		<tr>
			<td><%=arrayroutine.get(5).get(0) %></td>
			<td><%=arrayroutine.get(5).get(1) %></td>
		</tr>
	</table>
	<%} %> 
	</section>
	<footer>Web Systems - EUITI Bilbao</footer> 
</body>
</html>