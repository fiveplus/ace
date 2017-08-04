package com.ace.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ace.controller.admin.bo.UserBO;
import com.ace.dao.UserMapper;
import com.ace.entity.User;
import com.ace.util.Resource;
import com.ace.util.StringUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service("userService")
public class UserService extends BaseService<User>{
	@Autowired
	private UserMapper userMapper;
	
	public User getUserToLoginName(String loginName){
		return userMapper.getUserToLoginName(loginName);
	}
	
	public PageInfo<UserBO> getUserList(int page){
		PageHelper.startPage(page,10);
		List<UserBO> list = userMapper.getUserList();
		PageInfo<UserBO> p = new PageInfo<UserBO>(list);
		return p;
	}
	
	public UserBO getUserById(int id){
		return userMapper.getUserById(id);
	}
	
	public Integer saveUser(User us){
		us.setCreateTime(StringUtils.getDateToLong(new Date()));
		us.setPortrait("");
		us.setRemark("");
		us.setIsAdmin("N");
		//TODO 密码加密
		Md5PasswordEncoder md5 = new Md5PasswordEncoder();
		String password = md5.encodePassword(Resource.PASSWORD, us.getLoginName());
		us.setPassword(password);
		Integer count = saveSelect(us);
		return count;
	}
	
}
