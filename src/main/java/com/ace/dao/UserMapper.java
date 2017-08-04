package com.ace.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.github.abel533.mapper.Mapper;
import com.ace.controller.admin.bo.UserBO;
import com.ace.entity.User;


public interface UserMapper extends Mapper<User>{
	public User getUserToLoginName(@Param("loginName") String loginName);
	public List<UserBO> getUserList();
	public UserBO getUserById(@Param("id") int id);
}
