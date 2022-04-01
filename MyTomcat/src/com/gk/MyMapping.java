package com.gk;

import java.util.HashMap;

/**
 * @author goodking
 * @data 2022-03-17 9:29
 */
public class MyMapping {

    public static HashMap<String,String> mapping = new HashMap<>();

    static {
        mapping.put("/mytomcat","com.gk.MyServlet");
    }

    public HashMap<String,String> getMapping() {
        return mapping;
    }
}
