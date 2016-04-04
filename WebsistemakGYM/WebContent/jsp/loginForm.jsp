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
			<h3>Login</h3>
		</header>
		<% if((boolean) request.getAttribute("login_error")){ %>
		<section>
			<h3>LOGIN ERROR!!</h3>
		</section>
		<% } %>
		<section>
			<form method="POST" action="/WebsistemakGYM/servlet/LoginServlet">
				<table>
	   				<tr>
	   					<td>User:</td>
	   					<td><input name="user" required></td>
	   				</tr>
	   				<tr>
	   					<td>Password:</td>
	   					<td><input type="password" name="password" required></td>
	   				</tr>
	 			</table>
				<button>Send</button>
			</form>
		</section>
		<section>
			<a href="/WebsistemakGYM/servlet/SignupServlet" style="text-decoration: none">
				<font color="white">Sign Up</font>
			</a>
		</section>
		<footer>Web Systems - EUITI Bilbao</footer> 
	</body>
</html>