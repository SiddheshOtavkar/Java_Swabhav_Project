package com.aurionpro.cookies;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String name = request.getParameter("username");

		// Create Cookie
		Cookie cookie = new Cookie("username", name);

		// No expiry set, cookie will last until browser is closed
		// cookie.setMaxAge(3600); // ← commented out

		cookie.setPath("/"); // cookie valid for entire app
		response.addCookie(cookie);

		// Redirect to welcome page
		response.sendRedirect("welcome");

	}
}
