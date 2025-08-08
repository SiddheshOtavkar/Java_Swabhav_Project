package com.aurionpro.servletproject.studentportal;

import java.io.IOException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String studentName = request.getParameter("studentName");

        if (studentName == null || studentName.trim().isEmpty()) {
            RequestDispatcher rd = request.getRequestDispatcher("login-error.html");
            rd.forward(request, response);
            return;
        }

        HttpSession session = request.getSession();
        session.setAttribute("studentName", studentName);

        String timestamp = new SimpleDateFormat("d MMMM yyyy HH:mm").format(new Date());
        String safeTimestamp = URLEncoder.encode(timestamp, "UTF-8");

        Cookie loginTimeCookie = new Cookie("lastVisit", safeTimestamp);
        loginTimeCookie.setMaxAge(60 * 60 * 24); // 1 day
        response.addCookie(loginTimeCookie);

        RequestDispatcher rd = request.getRequestDispatcher("dashboard");
        rd.forward(request, response);
    }

    // For testing servlet deployment
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.getWriter().println("✅ LoginServlet is working via GET.");
    }
}
