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
//import jakarta.servlet.annotation.WebServlet;
/**
 *
 * @author joyfd
 */


import com.renewit.dao.UserDAO;

import java.io.IOException;

//@WebServlet("/signup")
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
        String check = request.getParameter("admin"); // User role
        String urole=" ";
        if(check=="0")
            urole="admin";
        else
            urole="user";
        
//        PrintWriter out=response.getWriter();
//        
//        out.println(name+password);

        // Basic validation
        if (name == null || password == null || email == null) {
            request.setAttribute("errorMessage", "Name, password, and email are required.");
            request.getRequestDispatcher("signup.jsp").forward(request, response);
            return;
        }

        // Create a new user in the database
        UserDAO userDAO = new UserDAO();
        userDAO.createUser(name, password, email, address, phone, urole);
        
        // Redirect to a success page or login page
        response.sendRedirect(request.getContextPath() + "/index.jsp");
    }
}
