package com.renewit.controllers;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import com.renewit.pojo.User;
import java.io.PrintWriter;
import com.renewit.dao.UserDAO;


/**
 * LoginServlet for handling user login.
 */
public class LoginServlet extends HttpServlet {

    private UserDAO userDAO;

    @Override
    public void init() throws ServletException {
        userDAO = new UserDAO(); // Initialize UserDao instance
    }

    // Handles the HTTP <code>GET</code> method.
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
    }

    // Handles the HTTP <code>POST</code> method.
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Find user by name
        User user = userDAO.findUserByName(username);
        PrintWriter out = response.getWriter();
                    out.println(user.getName());
                    out.println(user.getPassword());
                    out.println(username);
                    out.println(password);

        if (user != null && (password.equals(user.getPassword()))) {
            // Create session and store user details
            HttpSession session = request.getSession();

            session.setAttribute("userId", user.getId());
            session.setAttribute("username", user.getName());
            session.setAttribute("urole", user.getUrole());
            if(user.getUrole().equals("admin")){
                response.sendRedirect("dashboard.jsp");
            }else{
            response.sendRedirect("homePage.jsp");
            }
        } else {
            request.setAttribute("errorMessage", "Invalid username or password.");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }

    // Returns a short description of the servlet.
    @Override
    public String getServletInfo() {
        return "Login Servlet";
    }
}
