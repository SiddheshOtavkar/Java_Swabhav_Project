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

@WebServlet("/rating")
public class MovieRatingServlet extends HttpServlet {

    private Map<String, Movie> movieDatabase = new HashMap<>();

    // Movie class to hold data
    private static class Movie {
        String name;
        String genre;
        double rating;
        String review;

        Movie(String name, String genre, double rating, String review) {
            this.name = name;
            this.genre = genre;
            this.rating = rating;
            this.review = review;
        }
    }

    @Override
    public void init() throws ServletException {
        System.out.println("Movie Rating Servlet Initialized");

        // Hardcoded movie data
        movieDatabase.put("INCEPTION", new Movie("Inception", "Sci-Fi", 8.8, "Mind-bending thriller!"));
        movieDatabase.put("TITANIC", new Movie("Titanic", "Romance/Drama", 7.8, "Epic love story with tragedy."));
        movieDatabase.put("AVENGERS", new Movie("Avengers", "Action/Superhero", 8.0, "Epic superhero action."));
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String movieName = request.getParameter("movieName");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><body>");
        out.println("<h2>Movie Rating Summary</h2>");

        // Validate input
        if (movieName == null || movieName.trim().isEmpty()) {
            out.println("<p>Error: Movie name is required.</p>");
            out.println("<a href='movieRating.html'>Back</a>");
            out.println("</body></html>");
            return;
        }

        movieName = movieName.trim().toUpperCase();

        // Search for movie
        if (!movieDatabase.containsKey(movieName)) {
            out.println("<p>Error: No data found for movie '" + movieName + "'.</p>");
            out.println("<a href='movieRating.html'>Back</a>");
            out.println("</body></html>");
            return;
        }

        Movie movie = movieDatabase.get(movieName);

        // Display movie data
        out.println("<p><strong>Movie:</strong> " + movie.name + "</p>");
        out.println("<p><strong>Genre:</strong> " + movie.genre + "</p>");
        out.println("<p><strong>Rating:</strong> " + movie.rating + "/10</p>");
        out.println("<p><strong>Review:</strong> " + movie.review + "</p>");
        out.println("<a href='movieRating.html'>Search Another Movie</a>");
        out.println("</body></html>");
    }

    @Override
    public void destroy() {
        System.out.println("Movie Rating Servlet Destroyed");
    }
}
