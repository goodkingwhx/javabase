package com.example.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author goodking
 * @data 2022-03-18 14:36
 */
public class ListenseServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("gbk");
        req.setCharacterEncoding("utf-8");
        System.out.println("this is doGet");

        req.setAttribute("listense","listense");
        //req.removeAttribute("listense");


        //向servletcontext中添加属性值
        ServletContext sc = this.getServletContext();
        sc.setAttribute("servletContext","servletContext");

        //session
        HttpSession session = req.getSession();
        session.setAttribute("session","session");
        session.setMaxInactiveInterval(4);


        resp.getWriter().write("listense study");


    }
}
