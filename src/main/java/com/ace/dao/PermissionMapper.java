package com.ace.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ace.entity.Permission;
import com.github.abel533.mapper.Mapper;

public interface PermissionMapper extends Mapper<Permission>{
	public List<Permission> getParentMenu();
	public List<Permission> getChildPermissionByGroupId(@Param("groupId") Integer groupId);
	public List<Permission> getChildPermissionByUserId(@Param("userId") Integer userId);
	public List<Permission> getParentPermission();
	public List<Permission> getPermissionByParentId(@Param("parentId") String parentId);
	public Integer getCountByParentId(@Param("parentId") String parentId);
}
