package com.studentportal;

import java.io.IOException;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/studentDashboard")
public class StudentDashboardServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Handle POST if user directly posts to dashboard (optional safeguard)
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        String studentName = (session != null) ? (String) session.getAttribute("studentName") : null;

        response.setContentType("text/html");
        response.getWriter().println("<!DOCTYPE html><html><head><title>Dashboard</title>");
        response.getWriter().println("<style>body{font-family:Arial;background:#e0f7fa;padding:20px;}");
        response.getWriter().println("h1{color:#00796b;}</style></head><body>");

        if (studentName == null) {
            response.getWriter().println("<h1>You are not logged in!</h1>");
            response.getWriter().println("<a href='login-student.html'>Login Again</a>");
        } else {
            response.getWriter().println("<h1>Welcome, " + studentName + "!</h1>");
            response.getWriter().println("<p>This is your dashboard.</p>");
            response.getWriter().println("<a href='login-student.html'>Logout</a>");
        }

        response.getWriter().println("</body></html>");
    }
}
