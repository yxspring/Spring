package com.smart.yxsproxy;

import org.testng.annotations.Test;

import java.lang.reflect.Proxy;

public class ForumServiceTest01 {


	@Test
	public void proxy() {
		ForumService target=new ForumService01Impl();//希望被代理的目标业务类

		PerformanceHandler handler=new PerformanceHandler(target);//将目标类和横切逻辑编织到一起
		ForumService proxy=(ForumService)Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),handler);
		proxy.removeForum(10);
		proxy.removeTopic(1024);
	}
	 
}
