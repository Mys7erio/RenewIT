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
        <title>RenewIT</title>
        <link rel="stylesheet" href="styles/login.css"/>
        <link rel="stylesheet" href="./index.css"/>
    </head>
    <body class="login-div">
        <h3 class="company-name">RenewIT</h3>
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
				
			</div>
		</div>
		<button class="sign" >Sign in</button>
        </form>
	
	<p class="signup">Don't have an account?
		<a rel="noopener noreferrer" href="./signup.jsp" class="">Sign up</a>
	</p>
</div>
    </body>
</html>
