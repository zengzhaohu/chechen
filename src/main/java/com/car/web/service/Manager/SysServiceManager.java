package com.car.web.service.Manager;

import java.util.List;

import com.car.web.common.entity.Query;
import com.car.web.model.SysAreaEntity;
import com.car.web.model.car.SysCarEntity;
import com.car.web.model.customer.SysCustomerEntity;
import com.car.web.model.service.SysServiceEntity;


/**
 * 车辆管理
 * 
 */
public interface SysServiceManager {
	int saveService(SysServiceEntity customer);
	List<SysServiceEntity> list(Query query);
	SysServiceEntity getServiceById(Long customerId);
	int updateService(SysServiceEntity customer);
	int batchRemoveArea(Long[] id);
}
