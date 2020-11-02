package com.smart.yxsadvice;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ProjectName: chapter7
 * @Package: com.smart.yxsadvice
 * @ClassName: BeforeAdviceXmlTest
 * @Author: yuxingsheng
 * @Description: 测试xml配置的前置增强
 * @Date: 2020/11/2 18:48
 * @Version: 1.0
 */
public class BeforeAdviceXmlTest {
    @Test
    public void before(){
        String configPath="com/smart/yxsadvice/beans.xml";
        ApplicationContext ctx=new ClassPathXmlApplicationContext(configPath);
        Waiter waiter=(Waiter)ctx.getBean("waiter");
        waiter.serveTo("yuxs");

        Waiter waiter2=(Waiter)ctx.getBean("waiter2");
        waiter.greetTo("yuxs");
    }
}
