package com.gk;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author goodking
 * @data 2022-03-17 9:38
 */
public class MyServer {

    /**
     * 定义服务端的接收程序，接收socket请求
     * @param port
     */

    public static void startServer(int port) throws Exception {
        //定义服务套接字
        ServerSocket serverSocket = new ServerSocket(port);
        //定义客户端套接字
        Socket socket = null;
        while (true) {
            socket = serverSocket.accept();

            //获取输入流和输出流
            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();

            //定义请求对象
            MyRequest request = new MyRequest(inputStream);
            //定义响应对象
            MyResponse response = new MyResponse(outputStream);

            String clazz = new MyMapping().getMapping().get(request.getRequestURL());
            if (clazz!=null) {
                Class<MyServlet> myServletClass = (Class<MyServlet>) Class.forName(clazz);
                //根据MyServletClass创建对象
                MyServlet myServlet = myServletClass.newInstance();
                myServlet.service(request,response);

            }

        }
    }

    public static void main(String[] args) {
        try {
            startServer(10086);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
