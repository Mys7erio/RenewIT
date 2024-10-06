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
        <h1 class="dashboard-title">Admin Dashboard</h1>

        <%
            // Create an instance of AppointmentDAO
            AppointmentDAO appointmentDAO = new AppointmentDAO();
            // Retrieve all appointments
            List<Appointment> appointments = appointmentDAO.getAllAppointments();
        %>

        <c:if test="${not empty appointments}">
            <c:forEach var="appointment" items="${appointments}">
                <div class="card">
                    <h2 class="card-title">Appointment ID: ${appointment.aid}</h2>
                    <p><strong>User ID:</strong> ${appointment.uid}</p>
                    <p><strong>Item Type:</strong> ${appointment.itemType}</p>
                    <p><strong>Status:</strong> ${appointment.status}</p>
                    <p><strong>Repair Cost:</strong> $${appointment.repairCost}</p>

                    <form action="UpdateAppointmentStatusServlet" method="post">
                        <input type="hidden" name="appointmentId" value="${appointment.aid}" />
                        <div class="status-dropdown">
                            <label for="status${appointment.aid}" class="dropdown-label">Update Status:</label>
                            <select id="status${appointment.aid}" name="status" class="dropdown-select">
                                <option value="APPOINTMENT_CONFIRMED" ${appointment.status == 'APPOINTMENT_CONFIRMED' ? 'selected' : ''}>Confirmed</option>
                                <option value="REPAIR_IN_PROGRESS" ${appointment.status == 'REPAIR_IN_PROGRESS' ? 'selected' : ''}>In Progress</option>
                                <option value="REPAIR_SUCCESS" ${appointment.status == 'REPAIR_SUCCESS' ? 'selected' : ''}>Completed</option>
                            </select>
                        </div>
                        <button type="submit" class="submit-btn">Submit</button>
                    </form>
                </div>
            </c:forEach>
        </c:if>

        <c:if test="${empty appointments}">
            <p>No appointments found.</p>
        </c:if>
    </div>
</body>
</html>
