package com.ace.dao;

import org.apache.ibatis.annotations.Param;

import com.ace.entity.Group;
import com.github.abel533.mapper.Mapper;

public interface GroupMapper extends Mapper<Group>{
	public Group queryByName(@Param("name") String name);
}
