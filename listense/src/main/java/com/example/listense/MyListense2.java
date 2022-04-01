package com.example.listense;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * @author goodking
 * @data 2022-03-18 22:58
 */
public class MyListense2 implements HttpSessionListener, ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        //获取application
        ServletContext context = sce.getServletContext();
        //设置在线人数的初始值
        context.setAttribute("count",0);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("servletContext被销毁");
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        //获取application对象
        ServletContext servletContext = se.getSession().getServletContext();
        int count = (int)servletContext.getAttribute("count");
        servletContext.setAttribute("count",++count);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        //获取application对象
        ServletContext servletContext = se.getSession().getServletContext();
        int count = (int)servletContext.getAttribute("count");
        servletContext.setAttribute("count",--count);
    }
}
