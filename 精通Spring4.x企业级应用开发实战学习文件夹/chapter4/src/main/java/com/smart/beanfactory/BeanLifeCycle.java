package com.smart.beanfactory;

import com.smart.Car;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * @ProjectName: chapter4
 * @Package: com.smart.beanfactory
 * @ClassName: BeanLifeCycle
 * @Author: yuxingsheng
 * @Description: 装载配置文件。注册后处理器 可以参考 学习：https://blog.csdn.net/qq_38526573/article/details/88091702#comments_13252421
 * @Date: 2020/9/14 17:19
 * @Version: 1.0
 */
public class BeanLifeCycle {
    private static void lifeCycleInBeanFactory(){
        /**
         * 装载配置文件并启动容器
         * */
        Resource res=new   ClassPathResource("com/smart/beanfactory/beans.xml");
        BeanFactory bf=new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader((DefaultListableBeanFactory)bf);
        reader.loadBeanDefinitions(res);

        //向容器中注册MyBeanPostProcessor后处理器 和 MyInstantiationAwareBeanPostProcessor后处理器
        ((DefaultListableBeanFactory) bf).addBeanPostProcessor(new MyBeanPostProcessor());
        ((DefaultListableBeanFactory) bf).addBeanPostProcessor(new MyInstantiationAwareBeanPostProcessor());
        //第一次从容器中取car，将触发容器实例化Car,将引发bean生命周期方法的调用
       Car car1=(Car)bf.getBean("car");
       car1.introduce();
       car1.setColor("红色");
        //第2次从容器中取car ，将从缓存池里直接返回car
        Car car2=(Car)bf.getBean("car");
        System.out.println("car1==car2 ? "+ (car1==car2));
        //容器销毁
        ((DefaultListableBeanFactory) bf).destroySingletons();
    }

    public static void main(String[] args) {
        lifeCycleInBeanFactory();
    }
}
