<%-- 
    Document   : Userprofile
    Created on : 06-Oct-2024, 7:31:27 pm
    Author     : gursi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.renewit.pojo.Appointment" %>

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
    
    <%
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phoneNumer = request.getParameter("phoneNumber");
//        String itemType = request.getParameter("itemType");
        List<Appointment> appointments = (List<Appointment>) request.getAttribute("appointments");
    %>
    
    <div class="user-info">
        <h2>User Information</h2>
        <p><strong>Full Name:</strong>${name}</p>
        <p><strong>Email:</strong> ${email}</p>
        <p><strong>Phone Number:</strong>${phoneNumber}</p>
        
        
        <% if (appointments != null && !appointments.isEmpty()) { %>
        <p><strong>Repairs:</strong> <%= appointments.size() %> Devices repaired</p>
    <% } else{%>
    <p><strong>Repairs:</strong> <%= appointments.size() %> Devices repaired</p>
    <%}%>

    </div>
    
    <div class="repair-status">
        <h2>Repair Progress</h2>
        <div class="progress-bar">
            <!--${status}-->
            
            <div class="progress" style="width: ${status=="APPOINTMENT_CONFIRMED"?100:("REPAIR_IN_PROGRESS"?50:0)}%;"></div>  
            <!--Example: 70% completed--> 
        </div>
        <p><strong>Status:</strong> ${status}</p>
    </div>

    <div class="cost-details">
        <h2>Cost and Delivery Information</h2>
        <p><strong>Estimated Cost:</strong> $150</p>
        <p style="visibility:"><strong>Estimated Delivery Date:</strong> 10-Oct-2024</p>
    </div>
    <button style="visibility: ${status=="REPAIR_SUCCESS"?"display":"hidden"}"><a href="./feedback.jsp">Feedback</a></button>

    
</div>

</body>
</html>

