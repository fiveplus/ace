package com.ace.dao;

import org.apache.ibatis.annotations.Param;

import com.ace.entity.UserPermission;
import com.github.abel533.mapper.Mapper;

public interface UserPermissionMapper extends Mapper<UserPermission>{
	public int deletePermissionByUserId(@Param("userId") int userId);
}
