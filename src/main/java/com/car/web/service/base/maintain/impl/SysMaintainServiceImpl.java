package com.car.web.service.base.maintain.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.car.web.common.R;
import com.car.web.common.entity.Query;
import com.car.web.common.utils.CommonUtils;
import com.car.web.model.car.SysCarEntity;
import com.car.web.model.customer.SysCustomerEntity;
import com.car.web.model.maintain.SysMaintainEntity;
import com.car.web.model.service.SysServiceEntity;
import com.car.web.service.Manager.SysCustomerManager;
import com.car.web.service.Manager.SysMaintainManager;
import com.car.web.service.Manager.SysServiceManager;
import com.car.web.service.base.customer.SysCustomerService;
import com.car.web.service.base.maintain.SysMaintainService;
import com.car.web.service.base.service.SysServiceService;
@Service("syMaintainService")
public class SysMaintainServiceImpl implements SysMaintainService {
	
	@Autowired
	private SysMaintainManager sysMaintainManager;
	
	@Override
	public R saveService(SysMaintainEntity customer) {
		int count = sysMaintainManager.saveMaintain(customer);
		return CommonUtils.msg(count);
	}

	@Override
	public R list(Map<String, Object> params) {
		Query query = new Query(params);
		List<SysMaintainEntity> areas = sysMaintainManager.list(query);
		return CommonUtils.msg(areas);
	}

	@Override
	public R getServiceById(Long carId) {
		SysMaintainEntity car = sysMaintainManager.getServiceById(carId);
		return CommonUtils.msg(car);
	}

	@Override
	public R updateService(SysMaintainEntity car) {
		int count = sysMaintainManager.updateService(car);
		return CommonUtils.msg(count);
	}

	@Override
	public R batchRemoveArea(Long[] id) {
		int count = sysMaintainManager.batchRemoveArea(id);
		return CommonUtils.msg(count);
	}

}
