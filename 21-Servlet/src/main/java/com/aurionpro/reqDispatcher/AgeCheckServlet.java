package com.aurionpro.reqDispatcher;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/checkAge")
public class AgeCheckServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int age = Integer.parseInt(request.getParameter("age"));

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Include index.html content first
        RequestDispatcher rd = request.getRequestDispatcher("index.html");
        rd.include(request, response);

        // Now append the result message below the form
        out.println("<hr>");
        out.println("<h3>Result:</h3>");

        if (age >= 18) {
            out.println("<p style='color:green;'>✅ You are eligible. Age: " + age + "</p>");
        } else {
            out.println("<p style='color:red;'>❌ You are not eligible. Age: " + age + "</p>");
        }

        out.close();
    }
}
