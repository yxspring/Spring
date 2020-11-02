package com.smart.yxsadvice;

/**
 * @ProjectName: chapter7
 * @Package: com.smart.yxsadvice
 * @ClassName: NativeWaiter
 * @Author: yuxingsheng
 * @Description: 实际服务生实现类
 * @Date: 2020/11/2 15:44
 * @Version: 1.0
 */
public class NativeWaiter implements Waiter{

    public void greetTo(String name) {
        System.out.println("greet "+name+"...");
    }

    public void serveTo(String name) {
        System.out.println("serve "+name+"...");
    }
}
