package com.gk.service;

import org.springframework.stereotype.Service;

/**
 * @author goodking
 * @data 2022-02-07 15:47
 */
@Service
public class MyCalculator /*implements Calculator*/{

    public Integer add(Integer i, Integer j) throws NoSuchMethodException {
        Integer result = i+j;
        return result;
    }


    public Integer sub(Integer i, Integer j) throws NoSuchMethodException {
        Integer result = i-j;
        return result;
    }


    public Integer mul(Integer i, Integer j) throws NoSuchMethodException {
        Integer result = i*j;
        return result;
    }


    public Integer div(Integer i, Integer j) throws NoSuchMethodException {
        Integer result = i/j;
        return result;
    }
}
