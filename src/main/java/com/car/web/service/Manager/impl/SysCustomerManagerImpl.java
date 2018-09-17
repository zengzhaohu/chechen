package com.car.web.service.Manager.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.car.web.common.entity.Page;
import com.car.web.common.entity.Query;
import com.car.web.mapper.car.SysCarMapper;
import com.car.web.mapper.customer.SysCustomerMapper;
import com.car.web.model.car.SysCarEntity;
import com.car.web.model.customer.SysCustomerEntity;
import com.car.web.service.Manager.SysCarManager;
import com.car.web.service.Manager.SysCustomerManager;
@Component("sysCustomerManager")
public class SysCustomerManagerImpl implements SysCustomerManager {
	
	@Autowired
	private SysCustomerMapper sysCustomerMapper;
	@Override
	public int saveCustomer(SysCustomerEntity customer) {
		int count = sysCustomerMapper.save(customer);
		return count;
	}
	@Override
	public List<SysCustomerEntity> list(Query query) {
		return sysCustomerMapper.list(query);
	}
	@Override
	public SysCustomerEntity getCustomerById(Long customerId) {
		return sysCustomerMapper.getObjectById(customerId);
	}
	@Override
	public int updateCar(SysCustomerEntity customer) {
		return sysCustomerMapper.update(customer);
	}
	@Override
	public int batchRemoveArea(Long[] id) {
		return sysCustomerMapper.batchRemove(id);
	}
	@Override
	public List<SysCustomerEntity> list(Query query, Page<SysCustomerEntity> page) {
		return sysCustomerMapper.listForPage(page, query);
	}

}
