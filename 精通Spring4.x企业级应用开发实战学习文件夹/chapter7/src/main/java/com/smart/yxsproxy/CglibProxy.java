package com.smart.yxsproxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @ProjectName: chapter7
 * @Package: com.smart.yxsproxy
 * @ClassName: CglibProxy
 * @Author: yuxingsheng
 * @Description: cglib动态代理横切逻辑
 * @Date: 2020/10/29 8:19
 * @Version: 1.0
 */
public class CglibProxy implements MethodInterceptor {
    private Enhancer enghancer=new Enhancer();
    public Object getProxy(Class clazz){
        enghancer.setSuperclass(clazz);
        enghancer.setCallback(this);
        return enghancer.create();
    }
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        PerformanceMonitor.begin(obj.getClass().getName()+"."+method.getName());
        Object result=proxy.invokeSuper(obj,args);
        PerformanceMonitor.end();
        return result;
    }
}
