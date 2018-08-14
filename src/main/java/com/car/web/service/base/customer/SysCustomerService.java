package com.car.web.service.base.customer;

import java.util.List;
import java.util.Map;

import com.car.web.common.R;
import com.car.web.model.SysAreaEntity;
import com.car.web.model.car.SysCarEntity;
import com.car.web.model.customer.SysCustomerEntity;

/**
 * 车辆管理
 * 
 */
public interface SysCustomerService {
	
	R saveCustomer(SysCustomerEntity customer);

	R list(Map<String, Object> params);

	R getCustomerById(Long customerId);

	R updateCustomer(SysCustomerEntity customer);

	R batchRemoveArea(Long[] id);
	
}
