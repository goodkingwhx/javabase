package com.gk.firstweb; /**
 * @author goodking
 * @data 2022-03-17 11:28
 */

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ServletLife", value = "/ServletLife")
public class ServletLife extends HttpServlet {

    /**
     * 完成servlet对象的初始化工作
     * 在servlet接受到第一次请求的时候创建对象
     * 生命周期：从第一次接受请求你开始到服务关闭之后销毁
     * 当在web.xml文件中配置<load-on-startup></load-on-startup>,
     * 在启动tomcat的时候就会创建servlet对象,中间的数值是优先级
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write("servlet life");
        System.out.println("servlet life");
    }

    @Override
    public void init() throws ServletException {
        System.out.println("init...");
    }

    @Override
    public void destroy() {
        System.out.println("destroy....");
    }
}
