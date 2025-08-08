package com.aurionpro.reqDispatcher;

import java.io.*;

import jakarta.servlet.*;

import jakarta.servlet.annotation.WebServlet;

import jakarta.servlet.http.*;

@WebServlet("/welcome")

public class WelcomeServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse res)

			throws ServletException, IOException {

		processRequest(req, res);

	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res)

			throws ServletException, IOException {

		processRequest(req, res);

	}

	private void processRequest(HttpServletRequest req, HttpServletResponse res)

			throws IOException {

		res.setContentType("text/html");

		PrintWriter out = res.getWriter();

		out.println("<h1>Welcome, Admin!</h1>");

		out.println("<p>You have successfully logged in.</p>");

	}

}
