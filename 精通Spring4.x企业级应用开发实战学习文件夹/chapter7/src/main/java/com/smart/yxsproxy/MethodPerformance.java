package com.smart.yxsproxy;


/**
 * @ProjectName: chapter7
 * @Package: com.smart.yxsproxy
 * @ClassName: MethodPerformance
 * @Author: yuxingsheng
 * @Description: 记录性能监视信息
 * @Date: 2020/10/27 19:18
 * @Version: 1.0
 */
public class MethodPerformance {
    private long begin;
    private long end;
    private String serviceMethod;
    public MethodPerformance(String serviceMethod){
        this.serviceMethod=serviceMethod;
        this.begin=System.currentTimeMillis();
    }
    public void printPerformance(){
        end=System.currentTimeMillis();
        long elapse=end-begin;
        System.out.println(serviceMethod+"花费"+elapse+"毫秒");
    }
}
