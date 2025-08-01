package com.aurionpro.assignments;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/courses")
public class CourseCatalogServlet extends HttpServlet {

    private Map<String, List<String>> courseCatalog = new HashMap<>();

    @Override
    public void init() throws ServletException {
        System.out.println("Course Catalog Servlet Initialized");

        // Initialize course catalog data
        courseCatalog.put("CS", Arrays.asList("Data Structures", "Operating Systems", "Algorithms"));
        courseCatalog.put("ME", Arrays.asList("Thermodynamics", "Fluid Mechanics", "Heat Transfer"));
        courseCatalog.put("EE", Arrays.asList("Circuit Theory", "Electromagnetics", "Power Systems"));
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String dept = request.getParameter("department");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><body>");
        out.println("<h2>Course Catalog Result</h2>");

        // Validate input
        if (dept == null || dept.trim().isEmpty()) {
            out.println("<p>Error: Department is required.</p>");
            out.println("<a href='courseCatalog.html'>Back</a>");
            out.println("</body></html>");
            return;
        }

        dept = dept.trim().toUpperCase();

        // Check if department exists
        if (!courseCatalog.containsKey(dept)) {
            out.println("<p>Error: No courses found for department '" + dept + "'.</p>");
            out.println("<a href='courseCatalog.html'>Back</a>");
            out.println("</body></html>");
            return;
        }

        // Display course list
        out.println("<p>Department: " + dept + "</p>");
        out.println("<ul>");
        for (String course : courseCatalog.get(dept)) {
            out.println("<li>" + course + "</li>");
        }
        out.println("</ul>");
        out.println("<a href='courseCatalog.html'>Search Another Department</a>");
        out.println("</body></html>");
    }

    @Override
    public void destroy() {
        System.out.println("Course Catalog Servlet Destroyed");
    }
}
