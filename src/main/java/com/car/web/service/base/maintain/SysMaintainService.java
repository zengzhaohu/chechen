package com.car.web.service.base.maintain;

import java.util.List;
import java.util.Map;

import com.car.web.common.R;
import com.car.web.common.entity.Page;
import com.car.web.model.SysAreaEntity;
import com.car.web.model.car.SysCarEntity;
import com.car.web.model.customer.SysCustomerEntity;
import com.car.web.model.maintain.SysMaintainEntity;
import com.car.web.model.service.SysServiceEntity;
public interface SysMaintainService {
	
	R saveService(SysMaintainEntity customer);

	R list(Map<String, Object> params);

	R getServiceById(Long customerId);

	R updateService(SysMaintainEntity customer);

	R batchRemoveArea(Long[] id);

	Page<SysMaintainEntity> listForPage(Map<String, Object> params);
	
}
