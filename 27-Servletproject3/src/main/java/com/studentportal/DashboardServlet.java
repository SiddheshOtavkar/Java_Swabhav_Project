package com.studentportal;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet(urlPatterns = "/studentDashboard")
public class DashboardServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);
        String name = (String) session.getAttribute("studentName");
        String lastVisit = null;

        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals("lastVisit")) {
                    lastVisit = URLDecoder.decode(c.getValue(), "UTF-8");
                    break;
                }
            }
        }

        String instructor = getServletConfig().getInitParameter("instructor");
        ServletContext context = getServletContext();
        String motto = (String) context.getAttribute("portalMotto");
        Integer onlineCount = (Integer) context.getAttribute("onlineCount");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><head><title>Dashboard</title></head><body>");
        out.println("<h2>Welcome, " + name + "</h2>");
        out.println("<p>Last visit: " + (lastVisit != null ? lastVisit : "First time login") + "</p>");
        out.println("<p>Instructor: " + instructor + "</p>");
        out.println("<p>Motto: " + motto + "</p>");
        out.println("<p>Students Online: " + onlineCount + "</p>");
        out.println("<a href='logoutStudent'>Logout</a>");
        out.println("</body></html>");
    }
}
