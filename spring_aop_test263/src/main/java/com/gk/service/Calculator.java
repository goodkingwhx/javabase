package com.gk.service;

/**
 * @author goodking
 * @data 2022-02-07 15:46
 */
public interface Calculator {

    public Integer add(Integer i,Integer j) throws NoSuchMethodException;
    public Integer sub(Integer i,Integer j) throws NoSuchMethodException;
    public Integer mul(Integer i,Integer j) throws NoSuchMethodException;
    public Integer div(Integer i,Integer j) throws NoSuchMethodException;
}
