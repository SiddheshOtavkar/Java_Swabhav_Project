package com.aurionpro.servletproject.studentportal;

import jakarta.servlet.ServletContext;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.*;

@WebListener
public class MySessionListener implements HttpSessionListener {
    public void sessionCreated(HttpSessionEvent se) {
        ServletContext context = se.getSession().getServletContext();
        Integer count = (Integer) context.getAttribute("onlineCount");
        context.setAttribute("onlineCount", count + 1);
        System.out.println("Session Created. Online Students: " + (count + 1));
    }

    public void sessionDestroyed(HttpSessionEvent se) {
        ServletContext context = se.getSession().getServletContext();
        Integer count = (Integer) context.getAttribute("onlineCount");
        context.setAttribute("onlineCount", count - 1);
        System.out.println("Session Destroyed. Online Students: " + (count - 1));
    }
}
