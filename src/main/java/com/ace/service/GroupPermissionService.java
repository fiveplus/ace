package com.ace.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ace.dao.GroupPermissionMapper;
import com.ace.entity.GroupPermission;

@Service("groupPermissionService")
public class GroupPermissionService extends BaseService<GroupPermission>{
	@Autowired
	private GroupPermissionMapper groupPermissionMapper;
	
	public int deletePermissionByGroupId(int groupId){
		return groupPermissionMapper.deletePermissionByGroupId(groupId);
	}
	
	
}
