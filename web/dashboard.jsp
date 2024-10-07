<%@page import="java.util.List"%>
<%@page import="com.renewit.pojo.Appointment"%>
<%@page import="com.renewit.dao.AppointmentDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="./styles/dashboard.css" />
    <link rel="stylesheet" href="index.css" />
    <title>Admin Dashboard</title>
</head>
<body>
    <div class="container">
        <h3 style="text-align:left;" class="company-name">RenewIT</h3>
        <nav>
            <ul>
                <li style="left:0" class="nav-item"><a href="UserProfileServlet">Profile</a></li>
            </ul>
        </nav>
        <h1 class="dashboard-title">Admin Dashboard</h1>

        <%
            // Create an instance of AppointmentDAO
            AppointmentDAO appointmentDAO = new AppointmentDAO();
            // Retrieve all appointments
            List<Appointment> appointments = appointmentDAO.getAllAppointments(); // Fetch appointments from the DAO
            request.setAttribute("appointments", appointments); // Set the appointments in request scope

            if (appointments != null && !appointments.isEmpty()) {
                for (Appointment appointment : appointments) {
        %>
                    <div class="card">
                        <h2 class="card-title">Appointment ID: <%= appointment.getAid() %></h2>
                        <p><strong>User ID:</strong> <%= appointment.getUid() %></p>
                        <p><strong>Item Type:</strong> <%= appointment.getItemType() %></p>
                        <p><strong>Status:</strong> <%= appointment.getStatus() %></p>
                        <p><strong>Repair Cost:</strong> $<%= appointment.getRepairCost() %></p>

                        <form action="UpdateAppointmentStatusServlet" method="post">
                            <input type="hidden" name="appointmentId" value="<%= appointment.getAid() %>" />
                            <div class="status-dropdown">
                                <label for="status<%= appointment.getAid() %>" class="dropdown-label">Update Status:</label>
                                <select id="status<%= appointment.getAid() %>" name="status" class="dropdown-select">
                                    <option value="APPOINTMENT_CONFIRMED" <%= appointment.getStatus().equals("APPOINTMENT_CONFIRMED") ? "selected" : "" %>>Confirmed</option>
                                    <option value="REPAIR_IN_PROGRESS" <%= appointment.getStatus().equals("REPAIR_IN_PROGRESS") ? "selected" : "" %>>In Progress</option>
                                    <option value="REPAIR_SUCCESS" <%= appointment.getStatus().equals("REPAIR_SUCCESS") ? "selected" : "" %>>Completed</option>
                                </select>
                            </div>
                            <button type="submit" class="submit-btn">Submit</button>
                        </form>
                    </div>
        <%
                }
            } else {
        %>
                <p>No appointments found.</p>
        <%
            }
        %>
    </div>
</body>
</html>
