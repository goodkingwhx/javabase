package com.example.servletcontext;



/**
 * Serxletcontexta
 * 作用:
 *      解决不同用户的数据共享间题
 * 特点:
 *      1、由服务器创建
 *      2、所有用户共享同一个ServletContext对象
 *      3、所有的servlet都可以访问到同一个ServletContext中的属性
 *      4、每一个web项目对应的是一个ServletContext
 * @author goodking
 * @data 2022-03-18 19:53
 */

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ServletContextServlet", value = "/ServletContextServlet")
public class ServletContextServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("this is doPost");
        //获取Servletcontext对象
        //1
        ServletContext context = this.getServletContext();
        ServletContext context1 = this.getServletConfig().getServletContext();
        ServletContext context2 = request.getSession().getServletContext();

        System.out.println(context==context1);
        System.out.println(context==context2);
        System.out.println(context1==context2);

        context.setAttribute("1101","lisi");

        System.out.println(context.getInitParameter("bj"));

    }
}
