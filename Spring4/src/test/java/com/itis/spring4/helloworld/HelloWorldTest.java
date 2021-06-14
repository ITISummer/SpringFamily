package com.itis.spring4.helloworld;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ClassName HelloWorldTest
 * @Author LCX
 * @Date 2021 2021-06-05 1:17 p.m.
 * @Version 1.0
 **/
public class HelloWorldTest {
    @Test
    public void test1() throws Exception {
        /**
         * 1.加载Spring的配置文件
         * 2.取出Bean容器中的实例
         * 3.调用bean方法
         */
        // 1.加载Spring的配置文件，从类路径加载配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        // 2.取出Bean容器中的实例
        HelloWorld helloWorld = (HelloWorld) context.getBean("helloService");
        // 3.调用bean方法
        helloWorld.hello();
    }
}
