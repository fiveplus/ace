package com.ace.dao;

import org.apache.ibatis.annotations.Param;

import com.ace.entity.UserPermission;
import com.ace.tk.TKMapper;

public interface UserPermissionMapper extends TKMapper<UserPermission>{
	public int deletePermissionByUserId(@Param("userId") Integer userId);
}
