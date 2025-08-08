package com.cookies1;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/setcookie")
public class SetCookieServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String name = request.getParameter("username");

		// Create cookie
		Cookie cookie = new Cookie("username", name);
		// cookie.setMaxAge(3600); // Optional: 1 hour
		cookie.setPath("/"); // Valid for whole app
		response.addCookie(cookie);

		// Redirect to showcookie servlet
		response.sendRedirect("showcookie");

	}
}
