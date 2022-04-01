package com.gk.lambda.stream;

/**
 * @author goodking
 * @data 2022-03-16 22:33
 */
public class Person {

    private String name;

    public Person(String name) {
        this.name = name;
    }

    public Person() {
    }

    public static Person build(String name) {
        Person p = new Person();
        p.setName(name);
        return p;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}
