package com.aurionpro.assignments;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class StudentRegistrationServlet extends HttpServlet {

	@Override
	public void init() throws ServletException {
		System.out.println("Student Registration Servlet Initialized");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String ageStr = request.getParameter("age");
		String course = request.getParameter("course");
		int age = Integer.parseInt(ageStr);

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out.println("<html><body>");
		out.println("<h2>Student Registration Result</h2>");

		boolean hasError = false;

//		// Validate name and email
//		if (name == null || name.trim().isEmpty()) {
//			out.println("<p>Error: Name is required.</p>");
//			hasError = true;
//		}
//
//		if (email == null || email.trim().isEmpty()) {
//			out.println("<p>Error: Email is required.</p>");
//			hasError = true;
//		}
//
//		int age = 0;
//		try {
//			age = Integer.parseInt(ageStr);
//			if (age < 18) {
//				out.println("<p>Error: Age must be 18 or older.</p>");
//				hasError = true;
//			}
//		} catch (NumberFormatException e) {
//			out.println("<p>Error: Invalid age entered.</p>");
//			hasError = true;
//		}
//
//		if (course == null || course.trim().isEmpty()) {
//			out.println("<p>Error: Course must be selected.</p>");
//			hasError = true;
//		}

		if (!hasError) {
			// Success
			out.println("<h3>Registration Successful!</h3>");
			out.println("<p><strong>Name:</strong> " + name + "</p>");
			out.println("<p><strong>Email:</strong> " + email + "</p>");
			out.println("<p><strong>Age:</strong> " + age + "</p>");
			out.println("<p><strong>Course:</strong> " + course + "</p>");
		} else {
			out.println("<a href='studentRegistration.html'>Back to Form</a>");
		}

		out.println("</body></html>");
	}

	@Override
	public void destroy() {
		System.out.println("Student Registration Servlet Destroyed");
	}
}
