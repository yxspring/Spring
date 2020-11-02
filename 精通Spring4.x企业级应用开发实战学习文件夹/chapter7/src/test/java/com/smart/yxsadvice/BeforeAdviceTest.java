package com.smart.yxsadvice;

import org.springframework.aop.framework.ProxyFactory;
import org.testng.annotations.Test;

/**
 * @ProjectName: chapter7
 * @Package: com.smart.yxsadvice
 * @ClassName: BeforeAdviceTest
 * @Author: yuxingsheng
 * @Description:
 * @Date: 2020/11/2 16:02
 * @Version: 1.0
 */
public class BeforeAdviceTest {
    @Test
    public void before(){
        Waiter nativeWaiter=new NativeWaiter();
        GreetingBeforeMethod gb=new GreetingBeforeMethod();
        ProxyFactory pf=new ProxyFactory();
        //加入setInterfaces 采用jdk代理
        //pf.setInterfaces(nativeWaiter.getClass().getInterfaces());
        //仍然是cglib优先
        //pf.setOptimize(true);
        //设置代理目标
        pf.setTarget(nativeWaiter);
        //为代理类添加增强
        pf.addAdvice(gb);
        //获取实例
       Waiter waiter= (Waiter)pf.getProxy();
       waiter.greetTo("yuxs");
       waiter.serveTo("zhanghl");
    }
}
