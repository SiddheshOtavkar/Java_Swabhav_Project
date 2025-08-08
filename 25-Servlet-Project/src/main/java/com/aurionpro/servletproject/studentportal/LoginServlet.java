package com.aurionpro.servletproject.studentportal;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;

@WebServlet(urlPatterns = "/login", initParams = {
		@WebInitParam(name = "instructorName", value = "Prof. Amit Tiwari") })
public class LoginServlet extends HttpServlet {
	
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

		Cookie loginTimeCookie = new Cookie("lastVisit",
				new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		loginTimeCookie.setMaxAge(60 * 60 * 24);
		response.addCookie(loginTimeCookie);

		RequestDispatcher rd = request.getRequestDispatcher("dashboard");
		rd.forward(request, response);
	}
}
