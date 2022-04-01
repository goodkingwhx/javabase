package com.gk.filtertest.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 *
 * filter生命周期：从tomcat启动到tomcat关闭
 * @author goodking
 * @data 2022-03-18 13:26
 */
public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("init...filter");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        response.setCharacterEncoding("gbk");
        request.setCharacterEncoding("utf-8");
        chain.doFilter(request,response);
        System.out.println("do Filter.......");
    }

    @Override
    public void destroy() {
        System.out.println("destry...filter");
    }
}
