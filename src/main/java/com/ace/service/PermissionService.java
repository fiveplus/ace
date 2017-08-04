package com.ace.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ace.dao.PermissionMapper;
import com.ace.entity.Permission;

@Service("permissionService")
public class PermissionService extends BaseService<Permission>{
	@Autowired
	private PermissionMapper permissionMapper;
	
	public List<Permission> getParentMenu(){
		return permissionMapper.getParentMenu();
	}
	
	public List<Permission> getChildPermissionByGroupId(Integer groupId){
		return permissionMapper.getChildPermissionByGroupId(groupId);
	}
	
	public List<Permission> getChildPermissionByUserId(Integer userId){
		return permissionMapper.getChildPermissionByUserId(userId);
	}
	
	public List<Permission> getParentPermission(){
		return permissionMapper.getParentPermission();
	}
	
	public List<Permission> getPermissionByParentId(String parentId){
		return permissionMapper.getPermissionByParentId(parentId);
	}
	
	public Integer getCountByParentId(String parentId){
		return permissionMapper.getCountByParentId(parentId);
	}
	
}
