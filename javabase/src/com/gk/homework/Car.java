package com.gk.homework;

/**
 * @author goodking
 * @data 2022-02-02 10:10
 */
public class Car extends MotoVehicle{
    private String type;
    public Car(String type){
        this.type = type;
    }
    public Car(){}

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Car(int no, String brand, String type) {
        super(no,brand);
        this.type = type;
    }
    @Override
    public int calcRent(int day) {
        if (type.equals("0")){
            return 600*day;
        }else if (type.equals("1")) {
            return 500*day;
        }else if ((type.equals("2"))) {
            return 300*day;
        }else {
            System.out.println("类型有误！");
            return 0;
        }

    }
}
