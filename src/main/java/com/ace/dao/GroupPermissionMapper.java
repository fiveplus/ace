package com.ace.dao;

import org.apache.ibatis.annotations.Param;

import com.ace.entity.GroupPermission;
import com.github.abel533.mapper.Mapper;

public interface GroupPermissionMapper extends Mapper<GroupPermission>{
	public int deletePermissionByGroupId(@Param("groupId") int groupId);
}
