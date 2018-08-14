package com.car.web.service.base.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.car.web.common.R;
import com.car.web.common.entity.Query;
import com.car.web.common.utils.CommonUtils;
import com.car.web.model.car.SysCarEntity;
import com.car.web.model.customer.SysCustomerEntity;
import com.car.web.model.service.SysServiceEntity;
import com.car.web.service.Manager.SysCustomerManager;
import com.car.web.service.Manager.SysServiceManager;
import com.car.web.service.base.customer.SysCustomerService;
import com.car.web.service.base.service.SysServiceService;
@Service("syServiceService")
public class SysServiceServiceImpl implements SysServiceService {
	
	@Autowired
	private SysServiceManager sysServiceManager;
	
	@Override
	public R saveService(SysServiceEntity customer) {
		int count = sysServiceManager.saveService(customer);
		return CommonUtils.msg(count);
	}

	@Override
	public R list(Map<String, Object> params) {
		Query query = new Query(params);
		List<SysServiceEntity> areas = sysServiceManager.list(query);
		return CommonUtils.msg(areas);
	}

	@Override
	public R getServiceById(Long carId) {
		SysServiceEntity car = sysServiceManager.getServiceById(carId);
		return CommonUtils.msg(car);
	}

	@Override
	public R updateService(SysServiceEntity car) {
		int count = sysServiceManager.updateService(car);
		return CommonUtils.msg(count);
	}

	@Override
	public R batchRemoveArea(Long[] id) {
		int count = sysServiceManager.batchRemoveArea(id);
		return CommonUtils.msg(count);
	}

}
