package com.car.web.model.customer;

import java.io.Serializable;
import java.util.Date;

public class SysCustomerEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private long id;
	private String userName;//客户名称
	private String phone;//电话
	private String gender;//性别
	private String address;
	private String remark;
	private String deFlag;
	private Date createTime;
	private String creator;
	private Date updateTime;
	private String updator;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getDeFlag() {
		return deFlag;
	}
	public void setDeFlag(String deFlag) {
		this.deFlag = deFlag;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public String getUpdator() {
		return updator;
	}
	public void setUpdator(String updator) {
		this.updator = updator;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "SysCustomerEntity [id=" + id + ", userName=" + userName
				+ ", phone=" + phone + ", gender=" + gender + ", address="
				+ address + ", remark=" + remark + ", deFlag=" + deFlag
				+ ", createTime=" + createTime + ", creator=" + creator
				+ ", updateTime=" + updateTime + ", updator=" + updator + "]";
	}
}
