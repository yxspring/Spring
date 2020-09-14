package com.smart.beanfactory;


import com.smart.Car;
import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter;
import java.beans.PropertyDescriptor;


/**
 * @ProjectName: chapter4
 * @Package: com.smart.beanfactory
 * @ClassName: MyInstantiationAwareBeanPostProcessor
 * @Author: yuxingsheng
 * @Description: 实例化Bean后置处理器
 * @Date: 2020/9/14 16:13
 * @Version: 1.0
 * Instantiation	表示实例化,对象还未生成
 * Initialization	表示初始化,对象已经生成
 */
public class MyInstantiationAwareBeanPostProcessor extends InstantiationAwareBeanPostProcessorAdapter {
    /**在bean实例化之前被调用 是自身的方法 继承自InstantiationAwareBeanPostProcessor的接口*/
    @Override
    public Object postProcessBeforeInstantiation(Class beanClass, String beanName) throws BeansException {
        //仅对Car类型的bean做处理
        if("car".equals(beanName)){
            System.out.println("在bean实例化之前被调用 是自身的方法 继承自InstantiationAwareBeanPostProcessor的接口");
        }
        return null;
    }
    /**在bean被实例化之后调用 是InstantiationAwareBeanPostProcessor的接口*/
    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        //仅对Car类型的bean做处理
       /* if(bean instanceof Car){
            System.out.println("在bean被实例化之后调用 是InstantiationAwareBeanPostProcessor的接口");
        }*/

        if("car".equals(beanName)){
            System.out.println("在bean被实例化之后调用 是InstantiationAwareBeanPostProcessor的接口");
        }
        return true;
    }
    /**对属性值进行修改，如果postProcessAfterInstantiation方法返回false，该方法可能不会被调用。可以在该方法内对属性值进行修改*/
    @Override
    public PropertyValues postProcessPropertyValues(PropertyValues pvs, PropertyDescriptor[] pds, Object bean, String beanName) throws BeansException {
        if("car".equals(beanName)){
            System.out.println("对属性值进行修改，如果postProcessAfterInstantiation方法返回false，该方法可能不会被调用。可以在该方法内对属性值进行修改" +
                    "" +
                    "这个应该是在初始化设置属性值之后调用！还要根据InstantiationAwareBeanPostProcessor的postProcessAfterInstantiation返回值做判断能否执行！");
        }
        return pvs;
    }
}
