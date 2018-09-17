package com.car.web.service.base.customer.impl;

import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.car.web.common.R;
import com.car.web.common.entity.Page;
import com.car.web.common.entity.Query;
import com.car.web.common.utils.CommonUtils;
import com.car.web.model.car.SysCarEntity;
import com.car.web.model.customer.SysCustomerEntity;
import com.car.web.service.Manager.SysCustomerManager;
import com.car.web.service.base.customer.SysCustomerService;
@Service("syCustomerService")
public class SysCustomerServiceImpl implements SysCustomerService {
	
	@Autowired
	private SysCustomerManager sysCustomerManager;
	
	@Override
	public R saveCustomer(SysCustomerEntity customer) {
		int count = sysCustomerManager.saveCustomer(customer);
		return CommonUtils.msg(count);
	}

	@Override
	public Page<SysCustomerEntity> list(Map<String, Object> params) {
		Query query = new Query(params);
		Page<SysCustomerEntity> page = new Page<>(query);
		sysCustomerManager.list(query,page);
		return page;
	}

	@Override
	public R getCustomerById(Long carId) {
		SysCustomerEntity car = sysCustomerManager.getCustomerById(carId);
		return CommonUtils.msg(car);
	}

	@Override
	public R updateCustomer(SysCustomerEntity car) {
		int count = sysCustomerManager.updateCar(car);
		return CommonUtils.msg(count);
	}

	@Override
	public R batchRemoveArea(Long[] id) {
		int count = sysCustomerManager.batchRemoveArea(id);
		return CommonUtils.msg(count);
	}

}
