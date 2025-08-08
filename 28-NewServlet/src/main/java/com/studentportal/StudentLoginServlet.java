package com.studentportal;

import java.io.IOException;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/studentLogin")
public class StudentLoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String studentName = request.getParameter("studentName");

        if (studentName == null || studentName.trim().isEmpty()) {
            RequestDispatcher rd = request.getRequestDispatcher("error.html");
            rd.forward(request, response);
            return;
        }

        HttpSession session = request.getSession();
        session.setAttribute("studentName", studentName);

        RequestDispatcher rd = request.getRequestDispatcher("studentDashboard");
        rd.forward(request, response);
    }
}
