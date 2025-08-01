package com.aurionpro.assignments;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/feedback")
public class FeedbackServlet extends HttpServlet {

	// In-memory storage of feedback (for demo purposes)
	private List<String> feedbackList = new ArrayList<>();

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String productId = request.getParameter("productId");
		String ratingStr = request.getParameter("rating");
		String review = request.getParameter("review");

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out.println("<html><body>");
		out.println("<h2>Feedback Submission Result</h2>");

		// Input validation
		boolean hasError = false;
		int rating = 0;

		if (productId == null || productId.trim().isEmpty()) {
			out.println("<p>Error: Product ID is required.</p>");
			hasError = true;
		}

		try {
			rating = Integer.parseInt(ratingStr);
			if (rating < 1 || rating > 5) {
				out.println("<p>Error: Rating must be between 1 and 5.</p>");
				hasError = true;
			}
		} catch (NumberFormatException e) {
			out.println("<p>Error: Invalid rating.</p>");
			hasError = true;
		}

		if (review == null || review.trim().isEmpty()) {
			out.println("<p>Error: Review cannot be empty.</p>");
			hasError = true;
		}

		if (hasError) {
			out.println("<a href='feedback.html'>Go Back</a>");
			out.println("</body></html>");
			return;
		}

		// Store feedback in list (simulate database)
		String feedbackEntry = "Product ID: " + productId + ", Rating: " + rating + ", Review: " + review;
		feedbackList.add(feedbackEntry);

		out.println("<p>Thank you for your feedback!</p>");
		out.println("<p>Product ID: " + productId + "</p>");
		out.println("<p>Rating: " + rating + "</p>");
		out.println("<a href='feedback.html'>Submit Another Feedback</a>");
		out.println("</body></html>");
	}

	@Override
	public void destroy() {
		System.out.println("FeedbackServlet destroyed. All feedbacks collected:");
		for (String feedback : feedbackList) {
			System.out.println(feedback);
		}
	}
}
