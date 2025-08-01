package com.aurionpro.assignments;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/weather")
public class Weather extends HttpServlet {

	@Override
	public void init() throws ServletException {
		System.out.println("Weather Servlet Initialized");
	}
	
	@Override
	public void destroy() {
		System.out.println("Weather Servlet Destroyed");
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String city = request.getParameter("city");

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		// Validate input
		if (city == null || city.trim().isEmpty()) {
			out.println("<html><body>");
			out.println("<h2>Error: City name cannot be empty!</h2>");
			out.println("<a href='weather.html'>Back</a>");
			out.println("</body></html>");
			return;
		}

		// Normalize input
		city = city.trim().toLowerCase();

		// Dummy weather data
		String temperature = "";
		String humidity = "";
		String forecast = "";

		switch (city) {
		case "delhi":
			temperature = "35°C";
			humidity = "40%";
			forecast = "Sunny";
			break;
		case "mumbai":
			temperature = "30°C";
			humidity = "70%";
			forecast = "Humid with Rain";
			break;
		case "bangalore":
			temperature = "25°C";
			humidity = "60%";
			forecast = "Cloudy";
			break;
		default:
			out.println("<html><body>");
			out.println("<h2>Error: Weather data for '" + city + "' not available.</h2>");
			out.println("<a href='weather.html'>Back</a>");
			out.println("</body></html>");
			return;
		}

		// Display weather info
		out.println("<html><body>");
		out.println("<h2>Weather Info for " + capitalize(city) + "</h2>");
		out.println("<p>Temperature: " + temperature + "</p>");
		out.println("<p>Humidity: " + humidity + "</p>");
		out.println("<p>Forecast: " + forecast + "</p>");
		out.println("<a href='weather.html'>Search Another City</a>");
		out.println("</body></html>");

	}

	// Capitalize first letter for display
	private String capitalize(String str) {
		return str.substring(0, 1).toUpperCase() + str.substring(1);
	}

}
