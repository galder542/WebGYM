<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<link href="/WebsistemakGYM/css/styleSheet.css" rel="stylesheet" />
<body>
		<header>
			<center>
			<IMG SRC="/WebsistemakGYM/img/zyzz_by_loupu-d5ituzq.png""/>
			<h1>WEB`S GYM</h1>
			<h2>You want, you can</h2>
			</center>
			<h3>Change User`s information</h3>
		</header>
		<section>
		<a href="/WebsistemakGYM/html/UserOptions.html" style="text-decoration: none">
				<font color="black"> Back</font>
			</a>
		</section>
		<section>
			<form method="POST" action="/WebsistemakGYM/servlet/EditInfoServlet">
				<table>			
	   				<tr>
	   					<td>Username:</td>
	   					<td><input type="username" name="username"></td>
	   				</tr>
	   				<tr>
	   					<td>Surname:</td>
	   					<td><input type="surname" name="surname"></td>
	   				</tr>
	   				<tr>
	   					<td>Address:</td>
	   					<td><input type="address" name="address"></td>
	   				</tr>
	   				<tr>
	   					<td>Post Code:</td>
	   					<td><input type="postcode" name="postcode"></td>
	   				</tr>
	   				<tr>
	   					<td>Email:</td>
	   					<td><input type="email" name="email"/></td>
	   				</tr>	
	   				<tr>
	   					<td>Phone Nº:</td>
	   					<td><input type="phone" name="phone"></td>
	   				</tr>
	 			</table>
	 			<button>Send</button>
			</form>
		<footer>Web Systems - EUITI Bilbao</footer> 
	</body>
</html>