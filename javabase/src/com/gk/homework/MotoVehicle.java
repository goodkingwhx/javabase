package com.gk.homework;

/**
 * @author goodking
 * @data 2022-02-02 10:11
 */
public abstract class MotoVehicle {
    private int no;
    private String brand;
    public MotoVehicle(int no, String brand) {
        this.no = no;
        this.brand = brand;
    }
    public MotoVehicle(){}

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public abstract int calcRent(int day);
}
