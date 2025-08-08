package com.aurionpro.servletproject.studentportal;

import java.io.IOException;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.*;

@WebFilter("/dashboard")
public class AuthFilter implements Filter {
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpSession session = req.getSession(false);

        if (session == null || session.getAttribute("studentName") == null) {
            ((HttpServletResponse) response).sendRedirect("student-login.html");
            return;
        }

        chain.doFilter(request, response);
    }
}
