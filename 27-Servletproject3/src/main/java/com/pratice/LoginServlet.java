//package com.pratice;
//
//import java.io.IOException;
//import jakarta.servlet.*;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.*;
//
//@WebServlet("/login")
//public class LoginServlet extends HttpServlet {
//	protected void doPost(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//
//		String username = request.getParameter("username");
//
//		if (username == null || username.trim().isEmpty()) {
//			response.sendRedirect("login.html");
//			return;
//		}
//
//		request.setAttribute("username", username);
//
//		RequestDispatcher rd = request.getRequestDispatcher("welcome");
//		rd.forward(request, response);
//	}
//}