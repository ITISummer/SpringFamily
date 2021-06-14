package com.itis.spring4.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * @Date 2021 2021-06-05 8:15 p.m.
 * 将此类声明为一个切面。可以对应于动态代理（反射技术）
 * 1. 使用 @component 将此类注入 IOC 容器中
 * 2. 使用 @Aspect 将此类标注为一个切面
 **/
@Component
@Aspect
public class LoggingAspect {
    /**
     * 定义一个方法，用于声明切入点表达式。一般地，该方法不再需要添入其他代码
     */
    @Pointcut("execution(public int com.itis.spring4.aop.Aop.*(int,int))")
    public void declareJointPointExpression() {}
    /**
     * 前置通知，在目标方法开始前执行 - 需在 xml 中配置，使注解起作用
     * @Before("execution(public int com.itis.spring4.aop.Aop.add(int,int))") // 只对 add(int,int) 起作用
     */
    @Before("declareJointPointExpression()") // 对 Aop 下的所有*(int,int)方法起作用
    public void before(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        List<Object> args = Arrays.asList(joinPoint.getArgs());
        System.out.println("before()->The method " + methodName + "() begins with " + args);
    }


    /**
     * 后置通知：在目标方法执行后（无论是否发生异常），执行的通知
     * 在后置通知中还不能访问目标方法执行的结果
     */
    @After("execution(public int com.itis.spring4.aop.*.*(int,int))") // 对 aop 下的所有类的所有*(int,int)方法起作用
    public void after(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("after()->The method " + methodName + "() ended");
    }
    /**
     * 返回通知：在方法正常执行后执行的通知
     * 返回通知中可以访问目标方法执行的结果
     */
    @AfterReturning(value = "execution(public int com.itis.spring4.aop.*.*(..))",returning = "res") // 对 aop 下的所有类的所有方法起作用
    public void afterReturning(JoinPoint joinPoint, Object res) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("afterReturning()->The method " + methodName + "() ended with "+res);
    }
    /**
     * 异常通知：在方法遇到运行时异常后执行的通知
     * 可以访问到异常对象，且可以指定在出现特定异常时才执行特定的切面通知代码
     */
    @AfterThrowing(value = "execution(public int com.itis.spring4.aop.*.*(..))",throwing = "exception") // 对 aop 下的所有类的所有方法起作用
    public void afterThrowing(JoinPoint joinPoint, Exception exception) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("afterThrowing()->The method " + methodName + "() occurs with exception: "+exception);
    }
    /**
     * 环绕通知需要携带 ProceedingJoinPoint 类型的参数
     * 环绕通知：类似于动态代理的全过程:ProceedingJoinPoint 类型的参数可以决定是否执行目标方法
     * 环绕通知必须有返回值，且返回值为目标方法的返回值
     * @return
     */
    @Around(value = "execution(public int com.itis.spring4.aop.Aop.add(int,int))") // 对aop下的Aop类的add(int,int)方法起作用
    public Object around(ProceedingJoinPoint pjp) {
        Object res = null;
        String methodName = pjp.getSignature().getName();
        try {
            // 前置通知
            List<Object> args = Arrays.asList(pjp.getArgs());
            System.out.println("-------->around()->The method " + methodName + "() begins with " + args);
            // 返回通知
            res = pjp.proceed();
            System.out.println("-------->around()->The method " + methodName + "() ended with "+res);
        } catch (Throwable e) {
            // 异常通知
            System.out.println("-------->around()->The method " + methodName + "() occurs with exception: "+e);
        }
        // 后置通知
        System.out.println("-------->around()->The method " + methodName + "() ended");
        return res;
    }
}
