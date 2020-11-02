package com.smart.yxsproxy;

import org.testng.annotations.Test;

public class ForumServiceTest {


	@Test
	public void proxy() {
		ForumService forumService=new ForumServiceImpl();
		forumService.removeForum(10);
		forumService.removeTopic(1024);
	}
	 
}
