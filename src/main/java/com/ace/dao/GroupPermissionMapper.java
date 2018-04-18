package com.ace.dao;

import com.ace.tk.TKMapper;
import org.apache.ibatis.annotations.Param;

import com.ace.entity.GroupPermission;

public interface GroupPermissionMapper extends TKMapper<GroupPermission> {
	public int deletePermissionByGroupId(@Param("groupId") Integer groupId);
}
