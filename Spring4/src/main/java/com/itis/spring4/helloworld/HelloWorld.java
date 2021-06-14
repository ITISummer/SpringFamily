package com.itis.spring4.helloworld;

/**
 * @ClassName HelloWorld
 * @Author LCX
 * @Date 2021 2021-06-05 1:11 p.m.
 * @Version 1.0
 **/
public class HelloWorld {
    private String name;

    public void setName(String name) {
       this.name = name;
    }

    public void hello() {
        System.out.println("Hello "+name);
    }
}
