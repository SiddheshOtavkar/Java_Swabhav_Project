package com.aurionpro.reqDispatcher;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.*;

import jakarta.servlet.annotation.WebServlet;

import jakarta.servlet.http.*;

@WebServlet("/login")

public class LoginServlet extends HttpServlet {

	@Override

	protected void doPost(HttpServletRequest req, HttpServletResponse res)

			throws ServletException, IOException {

		String user = req.getParameter("username");

		String pass = req.getParameter("password");

		if ("admin".equals(user) && "1234".equals(pass)) {

			RequestDispatcher rd = req.getRequestDispatcher("welcome");

			rd.forward(req, res);

		} else {

			res.setContentType("text/html");

			PrintWriter out = res.getWriter();

			out.println("<p style='color:red;'>Invalid username or password. Please try again.</p>");

			RequestDispatcher rd = req.getRequestDispatcher("index.html");

			rd.include(req, res);

		}

	}

}
