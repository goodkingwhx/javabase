package com.gk.service;

/**
 * @author goodking
 * @data 2022-02-07 15:47
 */
public class MyCalculator implements Calculator{
    @Override
    public Integer add(Integer i, Integer j) throws NoSuchMethodException {
        Integer result = i+j;
        return result;
    }

    @Override
    public Integer sub(Integer i, Integer j) throws NoSuchMethodException {
        Integer result = i-j;
        return result;
    }

    @Override
    public Integer mul(Integer i, Integer j) throws NoSuchMethodException {
        Integer result = i*j;
        return result;
    }

    @Override
    public Integer div(Integer i, Integer j) throws NoSuchMethodException {
        Integer result = i/j;
        return result;
    }
}
