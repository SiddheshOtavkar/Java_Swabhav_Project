package com.cookies1;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/showcookie")
public class ShowCookieServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		Cookie[] cookies = request.getCookies();
		String name = null;

		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("username")) {
					name = cookie.getValue();
					break;
				}
			}
		}

		if (name != null) {
			out.println("<h1>Hello, " + name + "!</h1>");
		} else {
			out.println("<h1>No cookie found. Please login first.</h1>");
			out.println("<a href='cookie1.html'>Go to Login</a>");
		}
	}
}
