package com.yxs.spri.reflect;

import com.yxs.spri.domain.PrivateCar;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @ProjectName: spri
 * @Package: com.yxs.spri.reflect
 * @ClassName: PrivateCarReflectTest
 * @Author: yuxingsheng
 * @Description: 私有类实例访问
 * @Date: 2020/8/27 13:53
 * @Version: 1.0
 */
public class PrivateCarReflectTest {
    public static void main(String[] args) throws Throwable{
        //通过类的默认加载器获取类实例
        ClassLoader loader=Thread.currentThread().getContextClassLoader();
        Class clazz= loader.loadClass("com.yxs.spri.domain.PrivateCar");
        PrivateCar pCar=(PrivateCar) clazz.newInstance();
        Field colorField=clazz.getDeclaredField("color");
        //取消Java语言检查访问机制 确保能访问private参数
        colorField.setAccessible(true);
        colorField.set(pCar,"red");
        Method driveMethod=clazz.getDeclaredMethod("drive",(Class[])null);
        //取消JAVA语言检查访问机制 以访问protected方法
        driveMethod.setAccessible(true);
        driveMethod.invoke(pCar,(Object[])null);
    }
}
