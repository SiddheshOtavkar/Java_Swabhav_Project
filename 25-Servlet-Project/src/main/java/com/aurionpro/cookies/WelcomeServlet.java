package com.aurionpro.cookies;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class WelcomeServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		Cookie[] cookies = request.getCookies();
		
		String name = null;
		
		if(cookies != null) {
			for(Cookie cookie : cookies) {
				if(cookie.getName().equals("username")) {
					name = cookie.getValue();
					break;
				}
			}
		}
		
		if(name != null) {
			out.println("<h1>Welcome back, " + name + "!</h1>");
		} else {
			out.println("<h2>No username found.Please login first.</h2>");
			out.println("<a href='index.html'>Go to Login</a>");
		}
	}
}
