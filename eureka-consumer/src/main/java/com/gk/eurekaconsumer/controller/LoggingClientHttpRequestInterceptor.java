package com.gk.eurekaconsumer.controller;

import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import java.io.IOException;

/**
 * @author goodking
 * @data 2022-03-24 21:33
 */
public class LoggingClientHttpRequestInterceptor implements ClientHttpRequestInterceptor {
    @Override
    public ClientHttpResponse intercept(HttpRequest httpRequest, byte[] bytes, ClientHttpRequestExecution clientHttpRequestExecution) throws IOException {

        System.out.println("拦截啦！！！");
        System.out.println(httpRequest.getURI());

        ClientHttpResponse response = clientHttpRequestExecution.execute(httpRequest, bytes);

        System.out.println(response.getHeaders());
        return response;
    }
}
