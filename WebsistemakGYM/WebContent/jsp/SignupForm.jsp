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
			<h3>Sign up</h3>
		</header>
		<section>
			<form method="POST" action="/WebsistemakGYM/servlet/SignupServlet">
				<table>			
	   				<tr>
	   					<td>Username:</td>
	   					<td><input type="username" name="username" required/></td>
	   				</tr>
	   				<tr>
	   					<td>Password:</td>
	   					<td><input type="password" name="password" required/></td>
	   				</tr>
	   				<tr>
	   					<td>Surname:</td>
	   					<td><input type="surname" name="surname" required/></td>
	   				</tr>
	   				<tr>
	   					<td>Address:</td>
	   					<td><input type="address" name="address" required/></td>
	   				</tr>
	   				<tr>
	   					<td>Post Code:</td>
	   					<td><input type="postcode" name="postcode" required/></td>
	   				</tr>
	   				<tr>
	   					<td>Email:</td>
	   					<td><input type="email" name="email" required/></td>
	   				</tr>	
	   				<tr>
	   					<td>Phone Number:</td>
	   					<td><input type="phone" name="phone" required/></td>
	   				</tr>
	 			</table>
				<button>Send</button>
			</form>
		</section>
		<footer>Web Systems - EUITI Bilbao</footer> 
	</body>
</html>