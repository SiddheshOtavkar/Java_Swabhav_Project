package com.aurionpro.models;

import java.io.IOException;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/initCounter")
public class CounterInitServlet extends HttpServlet {
	
	@Override
	public void init() throws ServletException {
		ServletContext context = getServletContext();
		context.setAttribute("counter", 0);
		System.out.println("Count is initialized with 0");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.getWriter().write("Counter initialized. You can now to /visit");
	}
	
}
