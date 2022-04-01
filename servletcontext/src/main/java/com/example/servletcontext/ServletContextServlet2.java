package com.example.servletcontext; /**
 * @author goodking
 * @data 2022-03-18 21:10
 */

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ServletContextServlet2", value = "/ServletContextServlet2")
public class ServletContextServlet2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext context = request.getServletContext();
        String attribute = (String)context.getAttribute("1101");
        System.out.println(attribute);
        response.getWriter().write(attribute);
    }
}
