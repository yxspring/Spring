package com.smart.beanfactory;

import com.smart.Car;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @ProjectName: chapter4
 * @Package: com.smart.beanfactory
 * @ClassName: MyBeanPostProcessor
 * @Author: yuxingsheng
 * @Description: bean后置处理器   初始化的时候用的
 * @Date: 2020/9/14 16:56
 * @Version: 1.0
 */

public class MyBeanPostProcessor implements BeanPostProcessor {


    /**在Bean的自定义初始化方法之前执行,继承自BeanPostProcessor接口中方法*/
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if("car".equals(beanName)){
            Car car=(Car)bean;
            System.out.println("在Bean的自定义初始化方法之前执行,继承自BeanPostProcessor接口中方法,查看一下bean的属性是不是都为空啊？");
            System.out.println("========"+beanName+"---->"+bean.toString());
            System.out.println("========"+beanName+"---->"+car.toString());
            car.setColor("黑色");
        }
        return bean;
    }
    /**在bean的自定义初始化方法执行之后执行，继承自BeanPostProcessor接口中的方法*/
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if("car".equals(beanName)){
            Car car=(Car)bean;
            System.out.println("在bean的自定义初始化方法执行之后执行，继承自BeanPostProcessor接口中的方法");
            if(car.getMaxSpeed()>=200){
                car.setMaxSpeed(200);
            }
            System.out.println("========"+beanName+"---->"+bean.toString());
            System.out.println("========"+beanName+"---->"+car.toString());
        }
        return bean;
    }
}
