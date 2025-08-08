package com.aurionpro.project1;

import java.io.IOException;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        String name = request.getParameter("username");

        // Handle null or empty name safely
        if (name != null && !name.isEmpty()) {
            response.getWriter().println("<h1>Hello, " + name + "!</h1>");
        } else {
            response.getWriter().println("<h1>Please enter your name.</h1>");
        }
    }
}

