package com.gk.cookie.servlet; /**
 * @author goodking
 * @data 2022-03-17 15:34
 */


import com.gk.cookie.entity.User;
import com.gk.cookie.service.UserService;
import com.gk.cookie.service.serviceimpl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {

    UserService us = new UserServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("gbk");
        request.setCharacterEncoding("utf-8");

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User user = new User(username, password);
        User u = us.checkUser(user);
        System.out.println(u);

        if (u!=null) {
            response.getWriter().write("success!");
            request.setAttribute("username",u.getUsername());

            //设置cookie
            Cookie cookie = new Cookie("uid",u.getId()+"");
            //设置过期时间
            cookie.setMaxAge(7*24*3600);
            //将cookie信息设置到response
            response.addCookie(cookie);

            response.sendRedirect("/cookie/success.jsp");
            return;
        }else {
            //response.getWriter().write("fail!!");
            request.setAttribute("message","用户名和密码有误");
            response.sendRedirect("/cookie/login.jsp");
            return;

        }
    }
}
