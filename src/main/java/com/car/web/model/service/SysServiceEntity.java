package com.car.web.model.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SysServiceEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private long id;
	private String carId;
	private String plateNumber;//车牌
	private String date;//保养日期
	private String type;
	private String cost;//本次保养花费
	private String mileage;//里程
	private String remark;
	private String deFlag;
	private Date createTime;
	private String creator;
	private Date updateTime;
	private String updator;
	private List<SysServiceCostEntity> serviceCostList;
	private List<SysMaterialCostEntity> materialCostList;
	private List<SysOtherCostEntity> otherCostList;
	private List<Long> removeServiceCostIDList=new ArrayList<Long>();
	private List<Long> removeMaterialCostIDList=new ArrayList<Long>();
	private List<Long> removeOtherCostIDList=new ArrayList<Long>();
	private Object handler;
	
	private String userName="未关联车主";
	private String phone="";
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
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
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getCost() {
		return cost;
	}
	public void setCost(String cost) {
		this.cost = cost;
	}
	public String getMileage() {
		return mileage;
	}
	public void setMileage(String mileage) {
		this.mileage = mileage;
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
	@Override
	public String toString() {
		return "SysServiceEntity [id=" + id + ", plateNumber=" + plateNumber + ", date=" + date + ", nextDate="
				+ ", cost=" + cost + ", mileage=" + mileage + ", remark=" + remark + ", deFlag=" + deFlag
				+ ", createTime=" + createTime + ", creator=" + creator + ", updateTime=" + updateTime + ", updator="
				+ updator + "]";
	}
	public String getCarId() {
		return carId;
	}
	public void setCarId(String carId) {
		this.carId = carId;
	}
	public List<SysServiceCostEntity> getServiceCostList() {
		return serviceCostList;
	}
	public void setServiceCostList(List<SysServiceCostEntity> serviceCostList) {
		this.serviceCostList = serviceCostList;
	}
	public List<SysMaterialCostEntity> getMaterialCostList() {
		return materialCostList;
	}
	public void setMaterialCostList(List<SysMaterialCostEntity> materialCostList) {
		this.materialCostList = materialCostList;
	}
	public List<SysOtherCostEntity> getOtherCostList() {
		return otherCostList;
	}
	public void setOtherCostList(List<SysOtherCostEntity> otherCostList) {
		this.otherCostList = otherCostList;
	}
	public List<Long> getRemoveServiceCostIDList() {
		return removeServiceCostIDList;
	}
	public void setRemoveServiceCostIDList(List<Long> removeServiceCostIDList) {
		this.removeServiceCostIDList = removeServiceCostIDList;
	}
	public List<Long> getRemoveMaterialCostIDList() {
		return removeMaterialCostIDList;
	}
	public void setRemoveMaterialCostIDList(List<Long> removeMaterialCostIDList) {
		this.removeMaterialCostIDList = removeMaterialCostIDList;
	}
	public List<Long> getRemoveOtherCostIDList() {
		return removeOtherCostIDList;
	}
	public void setRemoveOtherCostIDList(List<Long> removeOtherCostIDList) {
		this.removeOtherCostIDList = removeOtherCostIDList;
	}
	public Object getHandler() {
		return handler;
	}
	public void setHandler(Object handler) {
		this.handler = handler;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
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
	
	
}
