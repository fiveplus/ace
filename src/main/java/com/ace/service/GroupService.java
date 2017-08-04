package com.ace.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ace.dao.GroupMapper;
import com.ace.entity.Group;

@Service("groupService")
public class GroupService extends BaseService<Group>{
	@Autowired
	private GroupMapper groupMapper;
	
	public Group queryByName(String name){
		return groupMapper.queryByName(name);
	}
	
}
