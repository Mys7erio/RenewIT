<%-- 
    Document   : Dashboard
    Created on : 6 Oct 2024, 10:49:40 pm
    Author     : sanka
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="./styles/dashboard.css" />
        <link rel="stylesheet" href="index.css" />

        <title>JSP Page</title>
    </head>
    <body>
<h3 class="company-name">RenewIT</h3>
        <nav>
            
            <ul>
                <!--<li class="nav-item"><a href="#">Services</a></li>-->
                <!--<li class="nav-item"><a href="#">Bookings</a></li>-->
                <!--<li class="nav-item"><a href="./Userprofile.jsp">Profile</a></li>-->
                <li class="nav-item"><a href="#">Bookings</a></li>


            </ul>
        </nav>
    <div class="container">
        <h1 class="dashboard-title">Admin Dashboard</h1>

        <!-- Example Card 1 -->
        <div class="card">
            <h2 class="card-title">User: </h2>
            <p class="problem-description"><strong>Problem:</strong> Laptop screen not working.</p>
            <div class="status-dropdown">
                <label for="status1" class="dropdown-label">Update Status:</label>
                <select id="status1" class="dropdown-select">
                    <option value="pending">Pending</option>
                    <option value="inprogress">In Progress</option>
                    <option value="completed">Completed</option>
                </select>
            </div>
            <button class="submit-btn" onclick="updateStatus(1)">Submit</button>
        </div>
    </div>

</body>

</html>
