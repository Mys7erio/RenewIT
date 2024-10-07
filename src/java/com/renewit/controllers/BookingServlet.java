package com.renewit.controllers;

import com.renewit.dao.AppointmentDAO;
import com.renewit.pojo.Appointment;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.util.Random;

public class BookingServlet extends HttpServlet {

    Random random = new Random();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve form parameters from the request

        HttpSession session = request.getSession(false); // Use false to avoid creating a new session if one doesn't exist
        Integer uid = (Integer) session.getAttribute("userId");

        String phone = request.getParameter("phone");
        String deviceModel = request.getParameter("devicemodel");
        String issueDescription = request.getParameter("issue");
        String itemType = request.getParameter("itemType");
        String preferredDate = request.getParameter("preferredDate");
        String preferredTime = request.getParameter("preferredTime");
        int repairCost = 0;

        // To add seconds to the user input. Without adding seconds, we can't convert it to the correct postgress format
        preferredTime += ":00";

        // Create an Appointment object with the retrieved data
        Appointment appointment = new Appointment();
        appointment.setUid(uid);
        appointment.setDeviceModel(deviceModel);
        appointment.setIssueDescription(issueDescription);
        appointment.setItemType(itemType);
        appointment.setPreferredDate(preferredDate);
        appointment.setPreferredTime(preferredTime);

        if (appointment.getItemType().equals("phones")) {
            repairCost = random.nextInt(201) + 300; // Corrected range: 300 to 500
        } else if (appointment.getItemType().equals("laptops")) {
            repairCost = random.nextInt(5501) + 2500; // Corrected range: 2500 to 8000
        } else if (appointment.getItemType().equals("gaming consoles")) {
            repairCost = random.nextInt(3101) + 900; // Corrected range: 900 to 4000
        }

        repairCost -= (repairCost % 50); // round off to nearest 50
        appointment.setRepairCost(repairCost);

        // Create an instance of AppointmentDAO
        AppointmentDAO appointmentDAO = new AppointmentDAO();

        PrintWriter out = response.getWriter();
        try {
            // Use the DAO to insert the appointment into the database
            boolean isInserted = appointmentDAO.addAppointment(appointment);

            // Send response back to the client based on the result of the insertion
            response.setContentType("text/html;charset=UTF-8");

            if (isInserted) {
                out.println("<h1>Booking Successful</h1>");
                out.println("<p>Your appointment has been booked successfully.</p>");
            } else {
                out.println("<h1>Booking Failed</h1>");
                out.println("<p>There was an issue processing your booking. Please try again later.</p>");
            }

            out.println("<script>");
            out.println("alert('Thank you for using our services. You will be redirected shortly');");
            out.println("setTimeout(function() { window.location.href='homePage.jsp'; }, 2000);");
            out.println("</script>");

        } catch (Exception e) {
            out.println(e.getMessage());
            out.println(e.getCause());
            out.println(e.getClass());

            // Print the stack trace using getStackTrace()
            StackTraceElement[] stackTrace = e.getStackTrace();
            for (StackTraceElement element : stackTrace) {
                out.println(element); // Prints each stack trace element
            }
        }
    }

    @Override
    public String getServletInfo() {
        return "Servlet to handle booking requests";
    }
}
