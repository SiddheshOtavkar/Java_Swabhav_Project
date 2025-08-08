package com.studentportal;

import jakarta.servlet.*;

@jakarta.servlet.annotation.WebListener
public class MyContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext context = sce.getServletContext();
        context.setAttribute("portalMotto", "Learn. Grow. Succeed.");
        context.setAttribute("onlineCount", 0);  // ✅ Properly initialized
        System.out.println("Portal Started...");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("Portal shutting down...");
    }
}
