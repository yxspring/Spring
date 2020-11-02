package com.smart.yxsadvice;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

/**
 * @ProjectName: chapter7
 * @Package: com.smart.yxsadvice
 * @ClassName: GreetingAfterMethod
 * @Author: yuxingsheng
 * @Description:
 * @Date: 2020/11/2 19:18
 * @Version: 1.0
 */
public class GreetingAfterMethod implements AfterReturningAdvice {
    public void afterReturning(Object o, Method method, Object[] objects, Object o1) throws Throwable {
        System.out.println("please enjoy yourself !");
    }
}
