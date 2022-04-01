package com.gk.cookie.servlet; /**
 * @author goodking
 * @data 2022-03-17 20:57
 */

import com.gk.cookie.entity.User;
import com.gk.cookie.service.UserService;
import com.gk.cookie.service.serviceimpl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CookieProjectServlet", value = "/CookieProjectServlet")
public class CookieProjectServlet extends HttpServlet {

    UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("gbk");

        //获取cookie
        Cookie[] cookies = request.getCookies();
        //cookie 有值
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                String key = cookie.getName();
                if ("uid"!=null) {
                    String value = cookie.getValue();
                    System.out.println("==========================");
                    System.out.println(key+" : "+value);
                    //去数据库查看
                    User u = userService.getUserById(Integer.valueOf(value));
                    if (u!=null) {//如果u不等于null 有值 直接登录
                        response.sendRedirect("/cookie/success.jsp");
                        return;
                    }else {
                        response.sendRedirect("/cookie/login.jsp");
                        return;
                    }
                }else {
                    response.sendRedirect("/cookie/login.jsp");
                    return;
                }
            }
        } else {//cookie没有值，跳转到登陆页面
            response.sendRedirect("/cookie/login.jsp");
            return;
        }
    }
}
