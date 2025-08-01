package com.aurionpro.assignments;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/fundTransfer")
public class FundTransferServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String sourceAcc = request.getParameter("sourceAccount");
		String destAcc = request.getParameter("destinationAccount");
		String amountStr = request.getParameter("amount");

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		boolean hasError = false;
		String sourceAccError = "";
		String destAccError = "";
		String amountError = "";

		double amount = 0;

		// Validate source account
		if (sourceAcc == null || sourceAcc.trim().isEmpty()) {
			sourceAccError = "Source Account is required.";
			hasError = true;
		}

		// Validate destination account
		if (destAcc == null || destAcc.trim().isEmpty()) {
			destAccError = "Destination Account is required.";
			hasError = true;
		}

		// Check same account
		if (!hasError && sourceAcc.equals(destAcc)) {
			destAccError = "Source and Destination cannot be same.";
			hasError = true;
		}

		// Validate amount
		if (amountStr == null || amountStr.trim().isEmpty()) {
			amountError = "Amount is required.";
			hasError = true;
		} else {
			try {
				amount = Double.parseDouble(amountStr);
				if (amount <= 0 || amount > 50000) {
					amountError = "Amount must be between ₹1 and ₹50,000.";
					hasError = true;
				}
			} catch (NumberFormatException e) {
				amountError = "Invalid amount.";
				hasError = true;
			}
		}

		// If any validation error, re-render form with messages
		if (hasError) {
			out.println("<html><body>");
			out.println("<h2>Bank Fund Transfer Form</h2>");
			out.println("<form action='fundTransfer' method='post'>");

			out.println("Source Account Number: <input type='text' name='sourceAccount' value='"
					+ (sourceAcc != null ? sourceAcc : "") + "'><br>");
			if (!sourceAccError.isEmpty())
				out.println("<span style='color:red;'>" + sourceAccError + "</span><br><br>");
			else
				out.println("<br><br>");

			out.println("Destination Account Number: <input type='text' name='destinationAccount' value='"
					+ (destAcc != null ? destAcc : "") + "'><br>");
			if (!destAccError.isEmpty())
				out.println("<span style='color:red;'>" + destAccError + "</span><br><br>");
			else
				out.println("<br><br>");

			out.println("Amount to Transfer (₹): <input type='text' name='amount' value='"
					+ (amountStr != null ? amountStr : "") + "'><br>");
			if (!amountError.isEmpty())
				out.println("<span style='color:red;'>" + amountError + "</span><br><br>");
			else
				out.println("<br><br>");

			out.println("<input type='submit' value='Transfer'>");
			out.println("</form></body></html>");
			return;
		}

		// If no error, show success
		out.println("<html><body>");
		out.println("<h2>Fund Transfer Result</h2>");
		out.println("<p style='color:green;'>Transfer Successful!</p>");
		out.println("<p>From Account: " + sourceAcc + "</p>");
		out.println("<p>To Account: " + destAcc + "</p>");
		out.println("<p>Amount: ₹" + String.format("%.2f", amount) + "</p>");
		out.println("<a href='fundTransfer.html'>Make Another Transfer</a>");
		out.println("</body></html>");
	}
}
