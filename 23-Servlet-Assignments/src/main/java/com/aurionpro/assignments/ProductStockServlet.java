package com.aurionpro.assignments;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/stock")
public class ProductStockServlet extends HttpServlet {

	private Map<String, Product> inventory = new HashMap<>();

	// Inner class to hold product info
	private static class Product {
		String name;
		int stock;

		Product(String name, int stock) {
			this.name = name;
			this.stock = stock;
		}
	}

	@Override
	public void init() throws ServletException {
		System.out.println("Product Stock Servlet Initialized");

		// Simulated inventory
		inventory.put("101", new Product("Laptop", 5));
		inventory.put("102", new Product("Smartphone", 0));
		inventory.put("103", new Product("Headphones", 20));
		inventory.put("104", new Product("Keyboard", 15));
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String productId = request.getParameter("productId");

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out.println("<html><body>");
		out.println("<h2>Product Stock Status</h2>");

		// Validate input
		if (productId == null || productId.trim().isEmpty()) {
			out.println("<p>Error: Product ID is required.</p>");
			out.println("<a href='stockChecker.html'>Back</a>");
			out.println("</body></html>");
			return;
		}

		productId = productId.trim();

		// Check inventory
		if (!inventory.containsKey(productId)) {
			out.println("<p>Error: Product with ID '" + productId + "' not found.</p>");
			out.println("<a href='stockChecker.html'>Back</a>");
			out.println("</body></html>");
			return;
		}

		Product product = inventory.get(productId);
		String availability = product.stock > 0 ? "In Stock" : "Out of Stock";

		// Display product info
		out.println("<p><strong>Product:</strong> " + product.name + "</p>");
		out.println("<p><strong>Stock Count:</strong> " + product.stock + "</p>");
		out.println("<p><strong>Availability:</strong> " + availability + "</p>");
		out.println("<a href='stockChecker.html'>Check Another Product</a>");
		out.println("</body></html>");
	}

	@Override
	public void destroy() {
		System.out.println("Product Stock Servlet Destroyed");
	}
}
