package com.car.web.model.car;

import java.io.Serializable;
import java.util.Date;

public class SysCarEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private long id;
	private String plateNumber;//车牌号码
	private String carType;//车辆类型
	private String age;//车龄
	private String mileage;//里程
	private String remark;
	private String deFlag;
	private Date createTime;
	private String creator;
	private Date updateTime;
	private String updator;
	private String userName="未关联车主";
	private String phone="";
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getPlateNumber() {
		return plateNumber;
	}
	public void setPlateNumber(String plateNumber) {
		this.plateNumber = plateNumber;
	}
	public String getCarType() {
		return carType;
	}
	public void setCarType(String carType) {
		this.carType = carType;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getMileage() {
		return mileage;
	}
	public void setMileage(String mileage) {
		this.mileage = mileage;
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
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
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
	@Override
	public String toString() {
		return "SysCarEntity [id=" + id + ", plateNumber=" + plateNumber + ", carType=" + carType + ", age=" + age
				+ ", mileage=" + mileage + ", remark=" + remark + ", deFlag=" + deFlag + ", createTime=" + createTime
				+ ", creator=" + creator + ", updateTime=" + updateTime + ", updator=" + updator + ", userName="
				+ userName + ", phone=" + phone + "]";
	}
	
	
	
}
