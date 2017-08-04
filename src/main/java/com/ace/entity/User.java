package com.ace.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Transient;

@Table(name="tbl_user")
public class User implements Serializable{
	@Id
	private int id;
	@Column
	private int groupId;
	@Column
	private String userName;
	@Column
	private String loginName;
	@Column
	private String password;
	@Column
	private String portrait;
	@Column
	private String remark;
	@Column
	private String isAdmin;
	@Column
	private Long createTime;
	@Transient
	private List<Permission> pers;
	
	public User(){}
	public User(User user){
		this.id = user.getId();
		this.groupId = user.getGroupId();
		this.userName = user.getUserName();
		this.loginName = user.getLoginName();
		this.password = user.getPassword();
		this.portrait = user.getPortrait();
		this.remark = user.getRemark();
		this.isAdmin = user.getIsAdmin();
		this.createTime = user.getCreateTime();
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getGroupId() {
		return groupId;
	}
	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPortrait() {
		return portrait;
	}
	public void setPortrait(String portrait) {
		this.portrait = portrait;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getIsAdmin() {
		return isAdmin;
	}
	public void setIsAdmin(String isAdmin) {
		this.isAdmin = isAdmin;
	}
	public Long getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Long createTime) {
		this.createTime = createTime;
	}
	public List<Permission> getPers() {
		return pers;
	}
	public void setPers(List<Permission> pers) {
		this.pers = pers;
	}
	
	
}
