package com.gk.loginproject.servlet; /**
 * @author goodking
 * @data 2022-03-17 15:34
 */

import com.gk.loginproject.entity.User;
import com.gk.loginproject.service.UserService;
import com.gk.loginproject.service.serviceimpl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
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
            request.getRequestDispatcher("/success.jsp").forward(request,response);
        }else {
            //response.getWriter().write("fail!!");
            request.setAttribute("message","用户名和密码有误");
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }
    }
}
