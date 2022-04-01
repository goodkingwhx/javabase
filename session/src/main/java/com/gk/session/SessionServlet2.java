package com.gk.session; /**
 * @author goodking
 * @data 2022-03-18 16:14
 */

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "SessionServlet2", value = "/SessionServlet2")
public class SessionServlet2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("gbk");
        System.out.println("接受到请求get");
        //获取session对象
        HttpSession session = request.getSession();

        String zhangsan = (String) session.getAttribute("zhangsan");
        System.out.println(zhangsan);
        response.getWriter().write(zhangsan);
    }
}
