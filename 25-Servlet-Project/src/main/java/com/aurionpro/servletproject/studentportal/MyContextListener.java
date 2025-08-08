package com.aurionpro.servletproject.studentportal;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class MyContextListener implements ServletContextListener {
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext context = sce.getServletContext();
        context.setAttribute("portalMotto", "Empowering Students Through Technology");
        context.setAttribute("onlineCount", 0);
        System.out.println("Portal Started");
    }

    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("Portal Shutdown");
    }
}
