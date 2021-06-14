package com.itis.spring4.aop;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AopTest{
    @Test
    public void aopTest() {
        // 1. 创建 spring 的 IOC 容器
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        // 2. 从 IOC 容器获取 bean 实例
        Aop aop = ctx.getBean(Aop.class);
        // 3. 使用 bean
        int res = aop.add(1, 2);
        System.out.println("add 结果为：" + res);
    }

}