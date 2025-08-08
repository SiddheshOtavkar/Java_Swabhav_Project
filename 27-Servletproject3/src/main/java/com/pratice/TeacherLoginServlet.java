package com.pratice;

import java.io.IOException;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/teacherLogin")
public class TeacherLoginServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String teacherName = request.getParameter("teacherName");

		if (teacherName == null || teacherName.trim().isEmpty()) {
			response.setContentType("text/html");
			response.getWriter().println("<h3 style='color:red'>Name required. Go back and try again.</h3>");
			return;
		}

		request.setAttribute("teacherName", teacherName);
		RequestDispatcher rd = request.getRequestDispatcher("welcome-teacher.html");
		rd.forward(request, response);
	}
}
