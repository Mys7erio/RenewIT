<%-- 
    Document   : signup
    Created on : 06-Oct-2024, 3:32:09 pm
    Author     : gursi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="signup.css"/>
    </head>
    <body>
       
<form class="form" action="RegisterServlet" method="POST">
    <p class="title">Register </p>
        <div class="flex">
        <label>
            <input class="input" type="text" name="firstname" placeholder="" required="">
            <span>Username</span>
        </label>

    </div>  
            
    <label>
        <input class="input" type="email" name="email" placeholder="" required="">
        <span>Email</span>
    </label> 
        
    <label>
        <input class="input" type="password" name="password" placeholder="" required="">
        <span>Password</span>
    </label>
    <label>
        <input class="input" type="password" placeholder="" required="">
        <span>Confirm password</span>
    </label>
    <button class="submit" type="submit">Submit</button>
    <p class="signin">Already have an account ? <a href="../index.jsp">Sign In</a> </p>
</form>
    </body>
</html>
