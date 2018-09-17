package com.car.web.service.base.car.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.car.web.common.R;
import com.car.web.common.entity.Page;
import com.car.web.common.entity.Query;
import com.car.web.common.utils.CommonUtils;
import com.car.web.model.SysAreaEntity;
import com.car.web.model.car.SysCarEntity;
import com.car.web.service.Manager.SysCarManager;
import com.car.web.service.base.car.SysCarService;
@Service("sysCarService")
public class SysCarServiceImpl implements SysCarService {
	
	@Autowired
	private SysCarManager sysCarManager;
	
	@Override
	public R saveCar(SysCarEntity car) {
		int count = sysCarManager.saveCar(car);
		return CommonUtils.msg(count);
	}

	@Override
	public Page<SysCarEntity> list(Map<String, Object> params) {
		Query query = new Query(params);
		Page<SysCarEntity> page = new Page<SysCarEntity>();
		List<SysCarEntity> areas = sysCarManager.listForPage(query,page);
		return page;
	}

	@Override
	public R getCarById(Long carId) {
		SysCarEntity car = sysCarManager.getCarById(carId);
		return CommonUtils.msg(car);
	}

	@Override
	public R updateCar(SysCarEntity car) {
		int count = sysCarManager.updateCar(car);
		return CommonUtils.msg(count);
	}

	@Override
	public R batchRemoveArea(Long[] id) {
		int count = sysCarManager.batchRemoveArea(id);
		return CommonUtils.msg(count);
	}

	@Override
	public R relativeCustomer(Map<String, String> params) {
		int count = sysCarManager.relativeCustomer(params);
		return CommonUtils.msg(count);
	}

}
