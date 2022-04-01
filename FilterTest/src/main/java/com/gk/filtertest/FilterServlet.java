package com.gk.filtertest; /**
 * @author goodking
 * @data 2022-03-18 13:26
 */

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "FilterServlet", value = "/FilterServlet")
public class FilterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
        System.out.println("我是doGet");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("我是doPost");
        response.getWriter().write("我是doPost");
    }
}
