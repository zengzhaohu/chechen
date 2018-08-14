package com.car.web.service.Manager.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.car.web.common.entity.Query;
import com.car.web.mapper.car.SysCarMapper;
import com.car.web.model.car.SysCarEntity;
import com.car.web.service.Manager.SysCarManager;
@Component("sysCarManager")
public class SysCarManagerImpl implements SysCarManager {
	
	@Autowired
	private SysCarMapper sysCarMapper;
	@Override
	public int saveCar(SysCarEntity car) {
		int count = sysCarMapper.save(car);
		return count;
	}
	@Override
	public List<SysCarEntity> list(Query query) {
		return sysCarMapper.list(query);
	}
	@Override
	public SysCarEntity getCarById(Long carId) {
		return sysCarMapper.getObjectById(carId);
	}
	@Override
	public int updateCar(SysCarEntity car) {
		return sysCarMapper.update(car);
	}
	@Override
	public int batchRemoveArea(Long[] id) {
		return sysCarMapper.batchRemove(id);
	}
	@Override
	public int relativeCustomer(Map<String, String> params) {
		sysCarMapper.removeOldCarRelative(params.get("carId"));
		return sysCarMapper.saveRelativeCustomer(params);
	}

}
