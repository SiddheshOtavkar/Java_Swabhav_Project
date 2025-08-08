package com.studentportal;

import java.io.IOException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/studentLogin")
public class StudentLoginServlet extends HttpServlet {
	
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String studentName = request.getParameter("studentName");

        if (studentName == null || studentName.trim().isEmpty()) {
            RequestDispatcher rd = request.getRequestDispatcher("error.html");
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

        RequestDispatcher rd = request.getRequestDispatcher("studentDashboard");
        rd.forward(request, response);
    }
}
