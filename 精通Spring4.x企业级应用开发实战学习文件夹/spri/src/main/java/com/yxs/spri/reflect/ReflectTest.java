package com.yxs.spri.reflect;

import com.yxs.spri.domain.Car;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * @ProjectName: spri
 * @Package: com.yxs.spri.reflect
 * @ClassName: ReflectTest
 * @Author: yuxingsheng
 * @Description:
 * @Date: 2020/8/25 11:04
 * @Version: 1.0
 */
public class ReflectTest {
    public static Car initByDefaultConst()throws Exception{
        //通过类的默认加载器加载car类对象
        ClassLoader loader=Thread.currentThread().getContextClassLoader();
        Class clazz=loader.loadClass("com.yxs.spri.domain.Car");
        //获取类的默认构造器对象并通过他实例化类
        Constructor cons= clazz.getDeclaredConstructor((Class[])null);
        Car car=(Car)cons.newInstance();
        //通过反射方法设置属性
        Method setBrand=clazz.getMethod("setBrand",String.class);
        setBrand.invoke(car,"红旗ASSS");
        Method setColor=clazz.getMethod("setColor",String.class);
        setColor.invoke(car,"黑色");
        Method setMaxSpeed=clazz.getMethod("setMaxSpeed",int.class);
        setMaxSpeed.invoke(car,100);
        return car;
    }

    public static void main(String[] args) throws Exception{
        Car car=initByDefaultConst();
        car.introduce();
    }

}
