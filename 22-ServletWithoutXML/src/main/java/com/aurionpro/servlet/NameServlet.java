package com.aurionpro.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class NameServlet extends HttpServlet {

//	@Override
//	protected void doPost(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//
//		String name = request.getParameter("username");
//
//		response.setContentType("text/html");
//		PrintWriter out = response.getWriter();
//
//		out.println("<html><body>");
//		out.println("<h2>Hello, " + name + "!</h2>");
//		out.println("<form>");
//		out.println("<button type='button' onclick='alert(\"Welcome, " + name + "!\")'>Click Me</button>");
//		out.println("</form>");
//		out.println("</body></html>");
//
//	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		if (username != null && password != null) {
			// Validate credentials
			if ("admin".equals(username) && "1234".equals(password)) {
				out.println("<html><body>");
				out.println("<h2>Login Successfully</h2>");
				out.println("<p>Welcome, " + username + "</p>");
				out.println("</body></html>");
			} else {
				out.println("<html><body>");
				out.println("<h2>Invalid Credentials</h2>");
				out.println("<p>Please try again.</p>");
				out.println("<a href='index1.html'>Back to Login</a>");
//				response.sendRedirect("index1.html");
				out.println("</body></html>");
			}
		} else {
			out.println("<html><body>");
			out.println("<h2>Error: Missing username or password!</h2>");
			out.println("<a href='index1.html'>Back to Login</a>");
//			response.sendRedirect("index1.html");
			out.println("</body></html>");
		}
	}

}
