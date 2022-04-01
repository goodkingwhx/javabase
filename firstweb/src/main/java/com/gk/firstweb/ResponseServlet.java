package com.gk.firstweb; /**
 * @author goodking
 * @data 2022-03-17 14:52
 */

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

/**
 * response表示服务端返回数据的响应对象
 * 响应头：
 * 响应行
 * 响应体
 */
@WebServlet(name = "ResponseServlet", value = "/ResponseServlet")
public class ResponseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("this is doGet");
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("this is doPost");
        //设置相应头，按照key-value键值对的方式来设置
        response.setHeader("CN","China");
        response.addHeader("BJ","Beijing");

        response.setHeader("CN","Chinese");
        response.addHeader("BJ","shanghai");

        //设置状态码
        //response.sendError(404,"not found");

        //服务端返回的对象数据要按照一定的格式要求进行渲染，只有是html格式才会识别标签
        response.setHeader("Content-Type","text/html");
        //response.setContentType("text/html");
        response.getWriter().write("<h>java is easy</h>");
    }
}
