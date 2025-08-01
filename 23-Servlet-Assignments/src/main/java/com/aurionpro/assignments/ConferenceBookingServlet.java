package com.aurionpro.assignments;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/conferenceBooking")
public class ConferenceBookingServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String seatsStr = request.getParameter("seats");
		String dateStr = request.getParameter("date");
		String sessionType = request.getParameter("session");

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		boolean hasError = false;
		String nameError = "", emailError = "", seatsError = "", dateError = "", sessionError = "";
		int seats = 0;
		Date attendanceDate = null;

		// Validate Name
		if (name == null || name.trim().isEmpty()) {
			nameError = "Name is required.";
			hasError = true;
		} else if (!name.matches("^[A-Za-z ]+$")) {
			nameError = "Name must contain only letters and spaces.";
			hasError = true;
		}

		// Validate Email (basic regex)
		if (email == null || !email.matches("^[\\w.-]+@[\\w.-]+\\.\\w+$")) {
			emailError = "Invalid email format.";
			hasError = true;
		}

		// Validate Seats (≤5)
		try {
			seats = Integer.parseInt(seatsStr);
			if (seats <= 0 || seats > 5) {
				seatsError = "Seats must be between 1 and 5.";
				hasError = true;
			}
		} catch (NumberFormatException e) {
			seatsError = "Invalid number of seats.";
			hasError = true;
		}

		// Validate Date (format: yyyy-MM-dd)
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			sdf.setLenient(false);
			attendanceDate = sdf.parse(dateStr);
		} catch (Exception e) {
			dateError = "Invalid date format. Use yyyy-MM-dd.";
			hasError = true;
		}

		// Validate Session Type
		if (sessionType == null || sessionType.trim().isEmpty()) {
			sessionError = "Session type is required.";
			hasError = true;
		}

		// If validation fails, re-display form with errors
		if (hasError) {
			out.println("<html><body>");
			out.println("<h2>Conference Booking Form</h2>");
			out.println("<form action='conferenceBooking' method='post'>");

			out.println("Name: <input type='text' name='name' value='" + (name != null ? name : "") + "'><br>");
			if (!nameError.isEmpty())
				out.println("<span style='color:red;'>" + nameError + "</span><br><br>");

			out.println("Email: <input type='text' name='email' value='" + (email != null ? email : "") + "'><br>");
			if (!emailError.isEmpty())
				out.println("<span style='color:red;'>" + emailError + "</span><br><br>");

			out.println("Number of Seats: <input type='text' name='seats' value='" + (seatsStr != null ? seatsStr : "")
					+ "'><br>");
			if (!seatsError.isEmpty())
				out.println("<span style='color:red;'>" + seatsError + "</span><br><br>");

			out.println("Date of Attendance: <input type='date' name='date' value='" + (dateStr != null ? dateStr : "")
					+ "'><br>");
			if (!dateError.isEmpty())
				out.println("<span style='color:red;'>" + dateError + "</span><br><br>");

			out.println("Session Type: ");
			out.println("<select name='session'>");
			out.println("<option value=''>--Select--</option>");
			out.println("<option value='Technical'" + ("Technical".equals(sessionType) ? " selected" : "")
					+ ">Technical</option>");
			out.println("<option value='Workshop'" + ("Workshop".equals(sessionType) ? " selected" : "")
					+ ">Workshop</option>");
			out.println("<option value='Networking'" + ("Networking".equals(sessionType) ? " selected" : "")
					+ ">Networking</option>");
			out.println("</select><br>");
			if (!sessionError.isEmpty())
				out.println("<span style='color:red;'>" + sessionError + "</span><br><br>");

			out.println("<input type='submit' value='Book Ticket'>");
			out.println("</form></body></html>");
			return;
		}

		// If all inputs are valid, show confirmation
		out.println("<html><body>");
		out.println("<h2>Booking Confirmation</h2>");
		out.println("<p><strong>Name:</strong> " + name + "</p>");
		out.println("<p><strong>Email:</strong> " + email + "</p>");
		out.println("<p><strong>Seats Booked:</strong> " + seats + "</p>");
		out.println("<p><strong>Date of Attendance:</strong> " + dateStr + "</p>");
		out.println("<p><strong>Session:</strong> " + sessionType + "</p>");
		out.println("<h3>Thank you! Your booking is confirmed.</h3>");
		out.println("<a href='conferenceForm.html'>Make Another Booking</a>");
		out.println("</body></html>");
	}
}
