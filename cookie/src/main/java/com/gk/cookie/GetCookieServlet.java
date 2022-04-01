package com.gk.cookie; /**
 * @author goodking
 * @data 2022-03-17 20:19
 */

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "GetCookieServlet", value = "/GetCookieServlet")
public class GetCookieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("gbk");
        request.setCharacterEncoding("utf-8");

        //获取cookie
        Cookie[] cookies = request.getCookies();
        //最好做个判断
        if (cookies.length>0) {
            for (Cookie cookie : cookies) {
                String key = cookie.getName();
                String value = cookie.getValue();
                System.out.println(key+" : " +value);
            }
        }
    }
}
