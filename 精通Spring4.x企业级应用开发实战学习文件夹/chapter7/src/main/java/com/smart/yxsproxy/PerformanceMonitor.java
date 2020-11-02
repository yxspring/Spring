package com.smart.yxsproxy;


/**
 * @ProjectName: chapter7
 * @Package: com.smart.yxsproxy
 * @ClassName: PerformanceMonitor
 * @Author: yuxingsheng
 * @Description: 性能监视实现类
 * @Date: 2020/10/27 19:13
 * @Version: 1.0
 */
public class PerformanceMonitor {
    private static ThreadLocal<MethodPerformance> performaceRecord=new ThreadLocal<MethodPerformance>();
    //启动对某一目标方法的性能检测
    public static void begin(String method){
        System.out.println("begin monitor...");
        MethodPerformance mp=new MethodPerformance(method);
        performaceRecord.set(mp);
    }
    public static void end(){
        System.out.println("end monitor...");
        MethodPerformance mp=performaceRecord.get();
        //打印出方法性能监视的结果信息
        mp.printPerformance();
    }
}
