package com.yxs.spri.reflect;

/**
 * @ProjectName: spri
 * @Package: com.yxs.spri.reflect
 * @ClassName: ClassLocaderTest
 * @Author: yuxingsheng
 * @Description: 类装载器测试类
 * @Date: 2020/8/25 14:57
 * @Version: 1.0
 */
public class ClassLocaderTest {
    public static void main(String[] args) {
       ClassLoader loader= Thread.currentThread().getContextClassLoader();
       System.out.println("current Loader: "+loader);
       System.out.println("parent Loader: "+loader.getParent());
       System.out.println("grand parent Loader: "+loader.getParent().getParent());
    }
}
