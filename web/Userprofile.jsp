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
        <link rel="stylesheet" href="./index.css" />
    </head>
    <body>
        <h3 style="text-align: left; padding-left: 40px" class="company-name">RenewIT</h3>
        <nav style="position: absolute; top: 0; right:0; padding: 40px;">

            <ul>
                <li class="nav-item"><a href="./homePage.jsp">Services</a></li>
                <li class="nav-item"><a href="UserProfileServlet">Profile</a></li>

                <form action="LogoutServlet" method="POST" style="width: 8rem;">
                    <button type="submit" style=" width: 100%;
                            background-color: rgba(167, 139, 250, 1);
                            padding: 0.75rem;
                            text-align: center;
                            color: rgba(17, 24, 39, 1);
                            border: none;
                            border-radius: 0.375rem;
                            font-weight: 600;
                            cursor: pointer;
                            align-self: flex-end;" >Logout</button>
                </form>
            </ul>
        </nav>

        <div class="profile-container">
            <h1>Repair Status</h1>

            <%
                String name = request.getParameter("name");
                String email = request.getParameter("email");
                String phoneNumer = request.getParameter("phoneNumber");
                List<Appointment> appointments = (List<Appointment>) request.getAttribute("appointments");
                int devicesRepaired = 0, deviceBeingRepaired = 0;

                for (Appointment app : appointments) {
                    if (app.getStatus().equals("REPAIR_SUCCESS")) {
                        devicesRepaired++;
                    }
                }
                deviceBeingRepaired = appointments.size() - devicesRepaired;
            %>

            <div class="user-info">
                <h2>User Information</h2>
                <p><strong>Full Name:</strong>${name}</p>
                <p><strong>Email:</strong> ${email}</p>
                <p><strong>Phone Number:</strong>${phoneNumber}</p>

                <p><strong>Repairs in Progress:</strong> <%= devicesRepaired%> repairs in progress</p>
                <p><strong>Repairs Completed:</strong> <%= deviceBeingRepaired%> devices repaired</p>



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

