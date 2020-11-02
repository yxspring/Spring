package com.smart.yxsproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @ProjectName: chapter7
 * @Package: com.smart.yxsproxy
 * @ClassName: PerformanceHandler
 * @Author: yuxingsheng
 * @Description: 实现InvocationHandler接口的性能监视横切代码
 * @Date: 2020/10/28 18:42
 * @Version: 1.0
 */
public class PerformanceHandler implements InvocationHandler {
    private Object target;
    public PerformanceHandler(Object target){ //target为目标业务类
        this.target=target;
    }
    //
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        PerformanceMonitor.begin(target.getClass().getName()+"."+method.getName());
        Object o=method.invoke(target,args);
        PerformanceMonitor.end();
        return o;
    }
}
