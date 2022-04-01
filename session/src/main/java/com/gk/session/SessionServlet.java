package com.gk.session; /**
 * @author goodking
 * @data 2022-03-18 15:55
 */

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

/**
 * session
 * 作用：
 *      解决相同用户发送不同请求是的数据共享问题
 * 特点：
 *      1.服务器端存储共享数据的技术
 *      2.session需要依赖cookie技术
 *      3.每个用户对应一个独立的session对象
 *      4.每个session对象的有效时长是30分钟
 *      5.但是每次关闭浏览器的时候，重新请求都会开启一个新的session对象，
 *        因为返回的JSESSIONID保存在浏览器的内存中，是临时cookie，所以关闭之后自然消失
 *      6.
 *
 * 使用：
 *      获取session对象
 *      修改session的保持时间
 */
@WebServlet(name = "SessionServlet", value = "/SessionServlet")
public class SessionServlet extends HttpServlet {
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
        System.out.println(session.getId());
        //修改session的保持时间
       // session.setMaxInactiveInterval(5);
        //设置session强制失效
        //session.invalidate();
        session.setAttribute("zhangsan","11111");
        response.getWriter().write("学习session");
    }
}
