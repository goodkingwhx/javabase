package com.gk.firstweb; /**
 * @author goodking
 * @data 2022-03-17 14:17
 */

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Enumeration;

/**
 * HttpServletRequest用来存放客户端请求的参数
 */
@WebServlet(name = "RequestServlet", value = "/RequestServlet")
public class RequestServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
        System.out.println("this is doGet");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("this is doPost");

        /**
         * 请求行的信息
         */
        String method = request.getMethod();
        System.out.println(method);
        String requestURI = request.getRequestURI();
        System.out.println(requestURI);

        StringBuffer requestURL = request.getRequestURL();
        System.out.println(requestURL);

        String scheme = request.getScheme();
        System.out.println(scheme);

        System.out.println("================获取请求头数据======================");
        //获取请求头数据
        String header = request.getHeader("User-Agent");
        System.out.println(header);

        //获取请求头信息中的所有key的枚举对象
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String key = headerNames.nextElement();
            String value = request.getHeader(key);
            //System.out.println(headerNames.nextElement());
            System.out.println(key+" : "+value);
        }

        String[] cookies = request.getHeader("cookie").split("=");
        System.out.println(cookies[0]);
        System.out.println(cookies[1]);

        String name = request.getParameter("name");
        System.out.println(name);
        String psw = request.getParameter("pwd");
        System.out.println(psw);

        String[] favs = request.getParameterValues("fav");
        for (String fav : favs) {
            System.out.println(fav);
        }

        String remoteAddr = request.getRemoteAddr();
        System.out.println(remoteAddr);
        String remoteHost = request.getRemoteHost();
        System.out.println(remoteHost);
        int remotePort = request.getRemotePort();
        System.out.println(remotePort);

    }
}
