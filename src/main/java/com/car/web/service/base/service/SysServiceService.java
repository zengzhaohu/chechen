package com.car.web.service.base.service;

import java.util.List;
import java.util.Map;

import com.car.web.common.R;
import com.car.web.model.SysAreaEntity;
import com.car.web.model.car.SysCarEntity;
import com.car.web.model.customer.SysCustomerEntity;
import com.car.web.model.service.SysServiceEntity;
public interface SysServiceService {
	
	R saveService(SysServiceEntity customer);

	R list(Map<String, Object> params);

	R getServiceById(Long customerId);

	R updateService(SysServiceEntity customer);

	R batchRemoveArea(Long[] id);
	
}
