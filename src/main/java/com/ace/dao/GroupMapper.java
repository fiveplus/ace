package com.ace.dao;

import com.ace.tk.TKMapper;
import org.apache.ibatis.annotations.Param;

import com.ace.entity.Group;

public interface GroupMapper extends TKMapper<Group>{
	public Group queryByName(@Param("name") String name);
}
