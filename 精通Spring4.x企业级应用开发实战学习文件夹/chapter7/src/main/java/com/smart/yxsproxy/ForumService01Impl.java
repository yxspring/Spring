package com.smart.yxsproxy;

/**
 * @ProjectName: chapter7
 * @Package: com.smart.yxsproxy
 * @ClassName: ForumServiceImpl
 * @Author: yuxingsheng
 * @Description: 包含性能监视横切代码 采用jdk动态代理抽取入切面中
 * @Date: 2020/10/27 19:24
 * @Version: 1.0
 */
public class ForumService01Impl implements ForumService{

    public void removeTopic(int topicId) {
        //PerformanceMonitor.begin("com.smart.yxsproxy.ForumServiceImpl.removeTopic");
        System.out.println("模拟删除Topic记录:"+topicId);
        try {
            Thread.currentThread().sleep(20);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
        //PerformanceMonitor.end();
    }

    public void removeForum(int forumId) {
        //PerformanceMonitor.begin("com.smart.yxsproxy.ForumServiceImpl.removeForum");
        System.out.println("模拟删除Forum记录:"+forumId);
        try {
            Thread.currentThread().sleep(20);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
        //PerformanceMonitor.end();
    }
}
