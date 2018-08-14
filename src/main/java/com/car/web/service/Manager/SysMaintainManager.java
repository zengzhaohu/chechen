package com.car.web.service.Manager;

import java.util.List;

import com.car.web.common.entity.Query;
import com.car.web.model.SysAreaEntity;
import com.car.web.model.car.SysCarEntity;
import com.car.web.model.customer.SysCustomerEntity;
import com.car.web.model.maintain.SysMaintainEntity;
import com.car.web.model.service.SysServiceEntity;


/**
 * 车辆管理
 * 
 */
public interface SysMaintainManager {
	int saveMaintain(SysMaintainEntity maintain);
	List<SysMaintainEntity> list(Query query);
	SysMaintainEntity getServiceById(Long customerId);
	int updateService(SysMaintainEntity customer);
	int batchRemoveArea(Long[] id);
}
