package com.itis.spring4.aop;

import org.springframework.stereotype.Component;

/**
 * @ClassName aop
 * @Author LCX
 * @Date 2021 2021-06-05 8:00 p.m.
 * @Version 1.0
 **/
@Component
public class Aop {
    /**
     * add
     */
    public int add(int a, int b) {
      return a + b;
    }
    /**
     * sub
     */
    public int sub(int a, int b) {
        return a - b;
    }
}
