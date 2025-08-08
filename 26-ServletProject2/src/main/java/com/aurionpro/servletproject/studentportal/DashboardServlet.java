package com.aurionpro.servletproject.studentportal;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/dashboard")
public class DashboardServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession(false);
        String studentName = (String) session.getAttribute("studentName");

        String lastVisit = "First Visit!";
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals("lastVisit")) {
                    lastVisit = URLDecoder.decode(c.getValue(), "UTF-8");
                    break;
                }
            }
        }

        ServletContext context = getServletContext();
        String motto = (String) context.getAttribute("portalMotto");
        Integer onlineCount = (Integer) context.getAttribute("onlineCount");

        out.println("<html><body>");
        out.println("<h2>Welcome, " + studentName + "</h2>");
        out.println("<p>Last Visit: " + lastVisit + "</p>");
        out.println("<p>Current Time: " + new SimpleDateFormat("d MMMM yyyy HH:mm").format(new Date()) + "</p>");
        out.println("<p>Online Students: " + onlineCount + "</p>");
        out.println("<p>Portal Motto: " + motto + "</p>");
        out.println("<a href='logout'>Logout</a>");
        out.println("</body></html>");
    }
}
