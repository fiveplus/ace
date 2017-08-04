package com.ace.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.github.abel533.entity.Example;
import com.github.abel533.mapper.Mapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;


public class BaseService<T> {
	@Autowired
	private Mapper<T> mapper;
	
	//根据ID查询实体
	public T queryById(Object id){
		return this.mapper.selectByPrimaryKey(id);
	}
	
	//查询所有
	public List<T> queryAll(){
		return this.mapper.select(null);
	}
	
	//条件查询
	public List<T> queryListByWhere(T param){
		return this.mapper.select(param);
	}
	
	//查询记录数
	public Integer queryCount(T param){
		return this.mapper.selectCount(param);
	}
	
	//分页
	public PageInfo<T> queryPageListByWhere(T param,Integer page,Integer rows){
		PageHelper.startPage(page, rows);
		List<T> list = this.queryListByWhere(param);
		return new PageInfo<T>(list);
	}
	
	//查询一条记录
	public T queryOne(T param){
		return this.mapper.selectOne(param);
	}
	
	//插入
	public Integer save(T param){
		return this.mapper.insert(param);
	}
	
	//新增非空字段
	public Integer saveSelect(T param){
		return this.mapper.insertSelective(param);
	}
	
	//根据主键更新
	public Integer update(T param){
		return this.mapper.updateByPrimaryKey(param);
	}
	
	//根据主键更新非空字段
	public Integer updateSelective(T param){
		return this.mapper.updateByPrimaryKeySelective(param);
	}
	
	//根据主键删除
	public Integer deleteByIds(Class<T> clazz,List<Object> values){
		Example example = new Example(clazz);
		example.createCriteria().andIn("id", values);
		return this.mapper.deleteByExample(example);
	}
	
	public Integer delete(String id){
		return this.mapper.deleteByPrimaryKey(id);
	}
	
}
