package com.smart.yxsproxy;

/**
 * @ProjectName: chapter7
 * @Package: com.smart.yxsproxy
 * @ClassName: ForumService
 * @Author: yuxingsheng
 * @Description: 包含性能监视横切代码
 * @Date: 2020/10/27 19:09
 * @Version: 1.0
 */
public interface ForumService {
    public void removeTopic(int topicId);
    public void removeForum(int forumId);
}
