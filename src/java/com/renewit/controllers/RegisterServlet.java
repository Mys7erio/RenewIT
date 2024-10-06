/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.renewit.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author joyfd
 */


import com.renewit.dao.UserDAO;

import java.io.IOException;


public class RegisterServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Retrieve form parameters
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");
        String urole = request.getParameter("urole"); // User role

        // Basic validation
        if (name == null || password == null || email == null) {
            request.setAttribute("errorMessage", "Name, password, and email are required.");
            request.getRequestDispatcher("/registration.jsp").forward(request, response);
            return;
        }

        // Create a new user in the database
        UserDAO userDAO = new UserDAO();
        userDAO.createUser(name, password, email, address, phone, urole);
        
        // Redirect to a success page or login page
        response.sendRedirect(request.getContextPath() + "/registrationSuccess.jsp");
    }
}
