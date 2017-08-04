package com.ace.controller.admin.bo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 功能：数据返回对象
 * @author hack
 *
 */
public class TreeRespBO implements Serializable{
	private List<Item> data = new ArrayList<Item>();
	private String status;

	public List<Item> getData() {
		return data;
	}

	public void setData(List<Item> data) {
		this.data = data;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}
