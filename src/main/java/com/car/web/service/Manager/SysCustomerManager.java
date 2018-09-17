package com.car.web.service.Manager;

import java.util.List;

import com.car.web.common.entity.Page;
import com.car.web.common.entity.Query;
import com.car.web.model.SysAreaEntity;
import com.car.web.model.car.SysCarEntity;
import com.car.web.model.customer.SysCustomerEntity;


/**
 * 车辆管理
 * 
 */
public interface SysCustomerManager {
	int saveCustomer(SysCustomerEntity customer);
	List<SysCustomerEntity> list(Query query);
	SysCustomerEntity getCustomerById(Long customerId);
	int updateCar(SysCustomerEntity customer);
	int batchRemoveArea(Long[] id);
	List<SysCustomerEntity> list(Query query, Page<SysCustomerEntity> page);
}
