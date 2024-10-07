/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.renewit.controllers;

import java.io.IOException;
import java.io.PrintWriter;
//import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author joyfd
 */
//@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Invalidate the session
        HttpSession session = request.getSession(false); // Do not create a new session if one does not exist
        if (session != null) {
            session.invalidate(); // End the session
        }

        // Set content type for response
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        // Create a JavaScript alert and redirect
        out.println("<script type='text/javascript'>");
        out.println("alert('You have been logged out successfully.');");
        out.println("setTimeout(function() { window.location.href='index.jsp'; }, 100);");
        out.println("</script>");
    }
}
