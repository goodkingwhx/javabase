package com.gk.homework;

/**
 * @author goodking
 * @data 2022-02-02 10:18
 */
public class Bus extends MotoVehicle{
    private int seatCount;
    public Bus(int seatCount) {
        this.seatCount = seatCount;
    }
    public Bus(){}

    public Bus(int no,String brand,int seatCount) {
        super(no,brand);
        this.seatCount = seatCount;
    }

    public int getSeatCount() {
        return seatCount;
    }

    public void setSeatCount(int seatCount) {
        this.seatCount = seatCount;
    }

    @Override
    public int calcRent(int day) {
        if (seatCount>16) {
            return 1500*day;
        }else {
            return 800*day;
        }
    }
}
