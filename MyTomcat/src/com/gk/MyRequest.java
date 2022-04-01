package com.gk;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author goodking
 * @data 2022-03-17 9:15
 */
public class MyRequest {

    public String getRequestMethod() {
        return requestMethod;
    }

    public void setRequestMethod(String requestMethod) {
        this.requestMethod = requestMethod;
    }

    public String getRequestURL() {
        return requestURL;
    }

    public void setRequestURL(String requestURL) {
        this.requestURL = requestURL;
    }

    //请求方法 GET/POST
    private String requestMethod;

    //请求url
    private String requestURL;

    public MyRequest(InputStream inputStream) throws IOException {
        //缓冲区
        byte[] buffer = new byte[1024];
        //读取数据的长度
        int len = 0;
        //定义请求的变量
        String str = null;
        if ((len = inputStream.read(buffer))>0) {
            str = new String(buffer,0,len);
        }

        //GET / HTTP/1.1
        String data = str.split("\n")[0];
        String[] params = data.split(" ");
        this.requestMethod = params[0];
        this.requestURL = params[1];

    }
}
