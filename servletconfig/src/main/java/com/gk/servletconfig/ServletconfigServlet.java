package com.gk.servletconfig; /**
 * @author goodking
 * @data 2022-03-18 21:59
 */

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ServletconfigServlet", value = "/ServletconfigServlet")
public class ServletconfigServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletConfig config = this.getServletConfig();
        String china = config.getInitParameter("china");
        System.out.println(china);
    }
}
