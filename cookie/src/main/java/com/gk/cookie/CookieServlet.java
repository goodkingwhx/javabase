package com.gk.cookie; /**
 * @author goodking
 * @data 2022-03-17 19:16
 */

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

/**
 * cookie：用来处理客户端发送不同请求的时候如何使用相同的参数信息
 * cookie的使用:
 *          //创建cookie
 *         Cookie cookie = new Cookie("010","PeKing");
 *
 *         //将cookie设置到response对象中
 *         response.addCookie(cookie);
 * 特点：
 *          1.cookie是保存在浏览器端的数据名称
 *          2.cookie分类，临时cookie，默认存储在内存中
 *                          持久化cookie，默认保存在浏览器的某个目录，当时间过期后才会失效
 *          3.每一个cookie对象中保存一个key-value键值对的数据，想要存储多个k-v数据，就要创建多个cookie对象
 */
@WebServlet(name = "CookieServlet", value = "/CookieServlet")
public class CookieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("gbk");

        response.getWriter().write("学习cookie");
        //创建cookie
        Cookie cookie = new Cookie("010","PeKing");
        Cookie weifang = new Cookie("0536", "Weifang");
        cookie.setMaxAge(3*60);//秒
        //将cookie设置到response对象中
        response.addCookie(cookie);
        response.addCookie(weifang);
        //给cookie设置固定路径值
        cookie.setPath("/cookie/abc");//只要是这个路径就能获取到指定的cookie
        cookie.setComment("beijing");

    }
}
