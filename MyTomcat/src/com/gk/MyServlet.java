package com.gk;

/**
 * @author goodking
 * @data 2022-03-17 9:35
 */
public class MyServlet extends MyHttpServlet{

    @Override
    public void doGet(MyRequest request, MyResponse response) throws Exception {
        response.write("do Get");
    }

    @Override
    public void doPost(MyRequest request, MyResponse response) throws Exception {
        response.write("do Post");
    }
}
