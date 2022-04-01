package com.example.num; /**
 * @author goodking
 * @data 2022-03-18 21:19
 */

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "NumServlet", value = "/NumServlet")
public class NumServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        ServletContext context = request.getServletContext();
        Integer num = (Integer)context.getAttribute("num");
        if (num!=null) {
            num++;
            context.setAttribute("num",num);
        }else {
            context.setAttribute("num",1);
        }

        request.getRequestDispatcher("/num.jsp").forward(request,response);
    }
}
