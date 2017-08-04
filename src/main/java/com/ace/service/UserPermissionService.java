package com.ace.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ace.dao.UserPermissionMapper;
import com.ace.entity.UserPermission;

@Service("userPermissionService")
public class UserPermissionService extends BaseService<UserPermission>{
	@Autowired
	private UserPermissionMapper deletePermissionByUserId;
	
	public int deletePermissionByUserId(int userId){
		return deletePermissionByUserId.deletePermissionByUserId(userId);
	}
	
}
