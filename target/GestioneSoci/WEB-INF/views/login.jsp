<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Gestione Soci v2.0</title>

	<link href="css/style.css" rel="stylesheet"/>
	<link href="css/reset.css" rel="stylesheet"/>
	
</head>
<body>
		<jsp:include page="messages.jsp"/>
		<div class="wrap">
			<div class="avatar">
	      		<img src="images/ImgLogoSimbolo.jpg" height="150px" width="150px" align="center">
			</div>
			<form action="j_spring_security_check" method="POST" class="form-signin">       			
				<input id= "j_username" name= "j_username" value="" type="text" placeholder="username" required>
				<div class="bar">
					<i></i>
				</div>
				<input id="j_password" name="j_password" value="" type="password" placeholder="password" required>
				<button>Login</button>
			</form>
		</div> 
</body>
</html>