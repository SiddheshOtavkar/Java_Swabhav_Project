package com.aurionpro.assignments;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/resumeUpload")
public class ResumeUploadServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String resumeText = request.getParameter("resume");
		String skills = request.getParameter("skills");

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		boolean hasError = false;
		String nameError = "", emailError = "", skillsError = "";

		// Validate name (min length 2)
		if (name == null || name.trim().length() < 2) {
			nameError = "Name must be at least 2 characters.";
			hasError = true;
		}

		// Validate email (basic check)
		if (email == null || !email.matches("^[\\w.-]+@[\\w.-]+\\.\\w+$")) {
			emailError = "Invalid email format.";
			hasError = true;
		}

		// Validate skills
		if (skills == null || skills.trim().isEmpty()) {
			skillsError = "At least one skill is required.";
			hasError = true;
		}

		// If errors exist, re-render form with error messages
		if (hasError) {
			out.println("<html><body>");
			out.println("<h2>Resume Submission Form</h2>");
			out.println("<form action='resumeUpload' method='post'>");

			out.println("Name: <input type='text' name='name' value='" + (name != null ? name : "") + "'><br>");
			if (!nameError.isEmpty())
				out.println("<span style='color:red;'>" + nameError + "</span><br>");
			out.println("<br>");

			out.println("Email: <input type='text' name='email' value='" + (email != null ? email : "") + "'><br>");
			if (!emailError.isEmpty())
				out.println("<span style='color:red;'>" + emailError + "</span><br>");
			out.println("<br>");

			out.println("Skills (comma-separated):<br>");
			out.println(
					"<textarea name='skills' rows='3' cols='40'>" + (skills != null ? skills : "") + "</textarea><br>");
			if (!skillsError.isEmpty())
				out.println("<span style='color:red;'>" + skillsError + "</span><br>");
			out.println("<br>");

			out.println("Resume:<br>");
			out.println("<textarea name='resume' rows='5' cols='50'>" + (resumeText != null ? resumeText : "")
					+ "</textarea><br><br>");

			out.println("<input type='submit' value='Submit Resume'>");
			out.println("</form></body></html>");
			return;
		}

		// If valid, show resume preview
		out.println("<html><body>");
		out.println("<h2>Resume Preview</h2>");
		out.println("<p><strong>Name:</strong> " + name + "</p>");
		out.println("<p><strong>Email:</strong> " + email + "</p>");

		out.println("<p><strong>Skills:</strong></p>");
		out.println("<ul>");
		for (String skill : skills.split(",")) {
			out.println("<li>" + skill.trim() + "</li>");
		}
		out.println("</ul>");

		out.println("<p><strong>Resume Text:</strong></p>");
		out.println("<pre>" + resumeText + "</pre>");

		out.println("<a href='resumeForm.html'>Submit Another Resume</a>");
		out.println("</body></html>");
	}
}
