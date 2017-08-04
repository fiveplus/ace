package com.ace.controller.admin.bo;

import java.io.Serializable;

/**
 * 节点信息
 * @author hack
 *
 */
public class Item implements Serializable{
	/**
	 * 节点名字
	 */
	private String name;
	/**
	 * 节点类型："item":文件  "folder":目录
	 */
	private String type;
	/**
	 * 子节点信息
	 */
	private AdditionalParameters additionalParameters;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public AdditionalParameters getAdditionalParameters() {
		return additionalParameters;
	}
	public void setAdditionalParameters(AdditionalParameters additionalParameters) {
		this.additionalParameters = additionalParameters;
	}
	
}
