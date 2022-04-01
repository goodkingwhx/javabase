package com.example.listense;

import javax.servlet.*;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
import java.util.Date;

/**
 * 监听器：
 *      监听作用域对象的创建和销毁以及属性的相关配置，可以添加一些公共的属性配置，做逻辑判断
 *
 *      主要监听三种作用域：
 *              ServletContext(application) session request
 *       request
 *                  接口
 *                  ServletRequestListener, 监听request对象的创建和销毁
 *                  ServletRequestAttributeListener，监听request作用域属性的添加，删除和更改
 *
 *                  servletcontex 在tomcat启动或者关闭的时候才监控
 * @author goodking
 * @data 2022-03-18 14:37
 */
public class MyListense implements ServletRequestListener, ServletRequestAttributeListener, ServletContextListener,ServletContextAttributeListener, HttpSessionAttributeListener, HttpSessionBindingListener {

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        System.out.println("request对象被创建---"+new Date());
    }

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        System.out.println("request对象被销毁---"+new Date());
    }

    @Override
    public void attributeAdded(ServletRequestAttributeEvent srae) {
        System.out.println("向request作用域添加数据");
        System.out.println(srae.getName());
        System.out.println(srae.getValue());
    }

    @Override
    public void attributeRemoved(ServletRequestAttributeEvent srae) {
        System.out.println("向request作用域删除数据");
        System.out.println(srae.getName());
        System.out.println(srae.getValue());
    }

    @Override
    public void attributeReplaced(ServletRequestAttributeEvent srae) {
        System.out.println("向request作用域属性替换");
        System.out.println(srae.getName());
        System.out.println(srae.getValue());
    }

    /**
     * 开启tomcat服务的时候开启监控
     * @param sce
     */
    @Override
    public void contextInitialized(ServletContextEvent sce) {

        System.out.println("servletcontext 创建");
    }

    /**
     * 关闭tomcat服务的时候监控
     */
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("servlet context 销毁");
    }

    @Override
    public void attributeAdded(ServletContextAttributeEvent event) {
        System.out.println("context 添加属性");
    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent event) {
        System.out.println("context 移除属性");    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent event) {
        System.out.println("context 替换属性");    }

    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {
        System.out.println("session添加属性");
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent event) {
        System.out.println("session移除属性");
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent event) {
        System.out.println("session替换属性");
    }

}
