<%-- 
    Document   : loginPage
    Created on : 6 Oct 2024, 2:36:59 pm
    Author     : sanka
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="./loginPage/login.css"/>
        <link rel="stylesheet" href="./index.css"/>
    </head>
    <body class="login-div">
       <div class="form-container">
	<p class="title">Login</p>
	<form class="form" action="LoginServlet" method="POST">
		<div class="input-group">
			<label for="username">Username</label>
			<input type="text" name="username" id="username" placeholder="">
		</div>
		<div class="input-group">
			<label for="password">Password</label>
			<input type="password" name="password" id="password" placeholder="">
			<div class="forgot">
				<!--<a rel="noopener noreferrer" href="#">Forgot Password ?</a>-->
			</div>
		</div>
		<button class="sign" >Sign in</button>
        </form>
	
	<p class="signup">Don't have an account?
		<a rel="noopener noreferrer" href="./homePage/homePage.jsp" class="">Sign up</a>
	</p>
</div>
    </body>
</html>
