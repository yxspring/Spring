package com.smart.yxsadvice;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * @ProjectName: chapter7
 * @Package: com.smart.yxsadvice
 * @ClassName: GreetingBeforeMethpd
 * @Author: yuxingsheng
 * @Description:
 * @Date: 2020/11/2 15:53
 * @Version: 1.0
 */
public class GreetingBeforeMethod implements MethodBeforeAdvice {
    public void before(Method method, Object[] args, Object o) throws Throwable {
        String clientName=args[0].toString();
        System.out.println("how are you ? Mr "+clientName);
    }
}
