package com.yxs.spri.domain;

/**
 * @ProjectName: spri
 * @Package: com.yxs.spri.domain
 * @ClassName: PrivateCar
 * @Author: yuxingsheng
 * @Description: 私有类
 * @Date: 2020/8/26 8:38
 * @Version: 1.0
 */
public class PrivateCar {
    //private成员变量；使用传统的类实例调用方式，只能在本类的实例中访问
    private String color;
    //protected方法；使用传统的类实例调用方式，只能在本类的实例和本包中访问
    protected void drive(){
        System.out.println("drive the private car ! this color is "+color);
    }
}
