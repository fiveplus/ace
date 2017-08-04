package com.ace;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ace.dao.UserMapper;
import com.ace.entity.User;
import com.ace.service.UserService;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {
	
	@Autowired
	private UserService userService;

	@Test
	public void contextLoads() {
		User user = userService.queryById(1);
		System.out.println("User:"+user.getLoginName());
	}

}
