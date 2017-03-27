package com.sidney.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import com.sidney.domain.User;
 

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:applicationContext.xml"})
public class TestUserService {
	
	@Autowired
	private UserService userService;
	
	@SuppressWarnings("resource")
	@Test
	public void hasMatchUser(){

		boolean b1 = userService.hasMatchUser("admin", "123456");
		boolean b2 = userService.hasMatchUser("admin", "1111");
		
		System.err.println(b1);
		System.err.println(b2);
	}
	@Test
	public void findUserByUserName(){
		User user = userService.findUserByUserName("admin");
		junit.framework.Assert.assertEquals(user.getUserName(), "admin");
	}

}
