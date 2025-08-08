package com.aurionpro.servletproject.studentportal;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/dashboard")
public class DashboardServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		HttpSession session = request.getSession(false);
		String studentName = (String) session.getAttribute("studentName");

		Cookie[] cookies = request.getCookies();
		String lastVisit = "First Visit!";
		if (cookies != null) {
			for (Cookie c : cookies) {
				if (c.getName().equals("lastVisit")) {
					lastVisit = c.getValue();
					break;
				}
			}
		}

		ServletContext context = getServletContext();
		String motto = (String) context.getAttribute("portalMotto");

		ServletConfig config = getServletConfig();
		String instructor = config.getInitParameter("instructorName");

		Integer onlineCount = (Integer) context.getAttribute("onlineCount");
		if (onlineCount == null)
			onlineCount = 0;

		out.println("<html><body>");
		out.println("<h2>Welcome, " + studentName + "</h2>");
		out.println("<p>Last Visit: " + lastVisit + "</p>");
		out.println(
				"<p>Current Login Time: " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "</p>");
		out.println("<p>Online Students: " + onlineCount + "</p>");
		out.println("<p>Instructor: " + instructor + "</p>");
		out.println("<p>Portal Motto: " + motto + "</p>");
		out.println("<br><a href='logout'>Logout</a>");
		out.println("</body></html>");
	}
}
