package com.studentportal;

import jakarta.servlet.*;
import jakarta.servlet.http.*;

@jakarta.servlet.annotation.WebListener
public class MySessionListener implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        ServletContext context = se.getSession().getServletContext();
        Integer count = (Integer) context.getAttribute("onlineCount");

        if (count == null) {
            count = 0;  // Safety fallback (extra precaution)
        }

        count++;
        context.setAttribute("onlineCount", count);
        System.out.println("Session Created. Online Students: " + count);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        ServletContext context = se.getSession().getServletContext();
        Integer count = (Integer) context.getAttribute("onlineCount");

        if (count == null || count <= 0) {
            count = 0;
        } else {
            count--;
        }

        context.setAttribute("onlineCount", count);
        System.out.println("Session Destroyed. Online Students: " + count);
    }
}
