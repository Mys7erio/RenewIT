<%-- 
    Document   : Userprofile
    Created on : 06-Oct-2024, 7:31:27 pm
    Author     : gursi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--
Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Html.html to edit this template
-->
<html>
    <head>

    <title>User Profile - Repair Status</title>
    <link rel="stylesheet" href="styles/Userprofile.css">
</head>
<body>

<div class="profile-container">
    <h1>Repair Status</h1>
    
    <div class="user-info">
        <h2>User Information</h2>
        <p><strong>Full Name:</strong>${name}</p>
        <p><strong>Email:</strong> ${email}</p>
        <p><strong>Phone Number:</strong>${phoneNumber}</p>
        <p><strong>Device Type:</strong>${itemType}</p>
    </div>
    
    <div class="repair-status">
        <h2>Repair Progress</h2>
        <div class="progress-bar">
            <!--${status}-->
            
            <div class="progress" style="width: ${status=="APPOINTMENT_CONFIRMED"?100:("REPAIR_IN_PROGRESS"?0:50)}%;"></div>  
            <!--Example: 70% completed--> 
        </div>
        <p><strong>Status:</strong> ${status}</p>
    </div>

    <div class="cost-details">
        <h2>Cost and Delivery Information</h2>
        <p><strong>Estimated Cost:</strong> $150</p>
        <p><strong>Estimated Delivery Date:</strong> 10-Oct-2024</p>
    </div>
    
</div>

</body>
</html>

