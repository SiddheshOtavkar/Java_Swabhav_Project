package com.aurionpro.session;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/Session")
public class SessionDemo2 extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Create or get existing session
        HttpSession session = request.getSession(true);

        // Set session timeout to 5 minutes (in seconds)
        session.setMaxInactiveInterval(300);  // 5 minutes

        // Format time: dd-MM-yyyy HH:mm:ss
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

        Date createTime = new Date(session.getCreationTime());
        Date lastAccessTime = new Date(session.getLastAccessedTime());

        String formattedCreateTime = formatter.format(createTime);
        String formattedLastAccessTime = formatter.format(lastAccessTime);

        String title = "Welcome to Servlet Demo";
        Integer visitCount = 0;
        String visitCountKey = "visitCount";
        String userIDKey = "userID";
        String userID = "Admin";

        if (session.isNew()) {
            title = "Welcome to Servlet Demo (First Visit)";
            session.setAttribute(userIDKey, userID);
        } else {
            visitCount = (Integer) session.getAttribute(visitCountKey);
            visitCount = visitCount + 1;
            userID = (String) session.getAttribute(userIDKey);
        }

        // Invalidate session if visitCount > 5
        if (visitCount > 5) {
            session.invalidate();
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();

            out.println("<html><body bgcolor='#f0f0f0'>");
            out.println("<h1 align='center'>Session Ended</h1>");
            out.println("<p align='center' style='color:red;'>❌ Visit limit exceeded. Session has been invalidated.</p>");
            out.println("</body></html>");
            out.close();
            return; // Stop further processing
        }

        session.setAttribute(visitCountKey, visitCount);

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html><head><title>" + title + "</title></head>");
        out.println("<body bgcolor='#f0f0f0'>");
        out.println("<h1 align='center'>" + title + "</h1>");
        out.println("<h2 align='center'>Session Information</h2>");
        out.println("<table border='1' align='center'>");

        out.println("<tr bgcolor='#949494'><th>Session Info</th><th>Value</th></tr>");
        out.println("<tr><td>Session ID</td><td>" + session.getId() + "</td></tr>");
        out.println("<tr><td>Creation Time</td><td>" + formattedCreateTime + "</td></tr>");
        out.println("<tr><td>Last Access Time</td><td>" + formattedLastAccessTime + "</td></tr>");
        out.println("<tr><td>User ID</td><td>" + userID + "</td></tr>");
        out.println("<tr><td>Number of Visits</td><td>" + visitCount + "</td></tr>");
        out.println("<tr><td>Session Timeout</td><td>5 minutes</td></tr>");

        out.println("</table>");
        out.println("</body></html>");
        out.close();
    }
}

