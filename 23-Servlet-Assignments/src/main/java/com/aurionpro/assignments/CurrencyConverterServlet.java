package com.aurionpro.assignments;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

import jakarta.security.auth.message.callback.PrivateKeyCallback.Request;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/convert")
public class CurrencyConverterServlet extends HttpServlet {

	private Map<String, Double> conversionRates = new HashMap<>();

	@Override
	public void init() throws ServletException {
		System.out.println("Currency Converter Servlet Initialized");

		conversionRates.put("USD", 1.0);
		conversionRates.put("INR", 83.0);
		conversionRates.put("EUR", 0.92);
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String amountStr = request.getParameter("amount");
		String from = request.getParameter("from");
		String to = request.getParameter("to");

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out.println("<html><body>");
		out.println("<h2>Currency Converter Result</h2>");

		// Validate inputs
		if (amountStr == null || from == null || to == null || amountStr.trim().isEmpty() || from.trim().isEmpty()
				|| to.trim().isEmpty()) {
			out.println("<p>Error: All parameters (amount, from, to) are required.</p>");
			out.println("<a href='currencyConverter.html'>Back</a>");
			out.println("</body></html>");
			return;
		}

		double amount;
		try {
			amount = Double.parseDouble(amountStr);
			if (amount < 0)
				throw new NumberFormatException();
		} catch (NumberFormatException e) {
			out.println("<p>Error: Invalid amount. Must be a positive number.</p>");
			out.println("<a href='currencyConverter.html'>Back</a>");
			out.println("</body></html>");
			return;
		}

		// Check supported currencies
		if (!conversionRates.containsKey(from.toUpperCase()) || !conversionRates.containsKey(to.toUpperCase())) {
			out.println("<p>Error: Unsupported currency.</p>");
			out.println("<a href='currencyConverter.html'>Back</a>");
			out.println("</body></html>");
			return;
		}

		// Conversion logic: amount in USD → target currency
		double amountInUSD = amount / conversionRates.get(from.toUpperCase());
		double convertedAmount = amountInUSD * conversionRates.get(to.toUpperCase());

		DecimalFormat df = new DecimalFormat("0.00");

		out.println("<p>" + df.format(amount) + " " + from.toUpperCase() + " = " + df.format(convertedAmount) + " "
				+ to.toUpperCase() + "</p>");
		out.println("<a href='currencyConverter.html'>Convert Another</a>");
		out.println("</body></html>");

	}

	@Override
	public void destroy() {
		System.out.println("Currency Converter Servlet Destroyed");
	}

}
