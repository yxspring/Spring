package com.smart.yxsproxy;

import org.testng.annotations.Test;

import java.lang.reflect.Proxy;

public class ForumServiceTest02 {


	@Test
	public void proxy() {
		CglibProxy proxy=new CglibProxy();
		//通过动态生成子类的方式创建代理类
		ForumService01Impl forumService01=(ForumService01Impl)proxy.getProxy(ForumService01Impl.class);
		forumService01.removeForum(10);
		forumService01.removeTopic(1024);
	}
	 
}
