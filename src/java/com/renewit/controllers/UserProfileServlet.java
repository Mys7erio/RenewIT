/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.renewit.controllers;

import com.renewit.dao.ConnectionPool;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.renewit.pojo.User;
import com.renewit.dao.UserDAO;
//import jakarta.servlet.annotation.WebServlet;
import com.renewit.dao.AppointmentDAO;
import jakarta.servlet.http.HttpSession;
import java.sql.Connection;
import com.renewit.pojo.Appointment;
import java.util.List;
import java.util.ArrayList;


/**
 *
 * @author joyfd
 */

//@WebServlet("/profile")
public class UserProfileServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UserProfileServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UserProfileServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
         // Get the session object
        HttpSession session = request.getSession();

        // Retrieve a session variable
        Integer userId = (Integer) session.getAttribute("userId");
        String urole= (String)session.getAttribute("urole");
                

        if (userId == null) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "User ID is required");
            return;
        }

//        try {
//            userId = Integer.parseInt(userId);
//        } catch (NumberFormatException e) {
//            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid User ID");
//            return;
//        }

        UserDAO userDAO = new UserDAO();
        AppointmentDAO appDAO= new AppointmentDAO();
        User user = null;
        List<Appointment> apps = new ArrayList<>();

        try (Connection connection = ConnectionPool.getInstance().getConnection()) {
            user = userDAO.findUserById(connection, userId); // Assuming a findUserById method is created
            if(urole.equals("user"))
            apps = appDAO.getAllAppointmentsByUserId(user.getId());
            else if(urole.equals("admin"))
            apps = appDAO.getAllAppointments();    
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Database error");
            return;
        }

        if (user != null) {
            request.setAttribute("name", user.getName());
            request.setAttribute("email", user.getEmail());
            request.setAttribute("phoneNumber", user.getPhone());
            
            if (apps != null) {
                request.setAttribute("appointments", apps);
            }
            
            request.getRequestDispatcher("/Userprofile.jsp").forward(request, response);
        } else {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "User not found");
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
