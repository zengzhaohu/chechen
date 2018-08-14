package com.car.web.service.Manager.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.car.web.common.entity.Query;
import com.car.web.mapper.car.SysCarMapper;
import com.car.web.mapper.customer.SysCustomerMapper;
import com.car.web.mapper.service.SysMaterialCostMapper;
import com.car.web.mapper.service.SysOtherCostMapper;
import com.car.web.mapper.service.SysServiceCostMapper;
import com.car.web.mapper.service.SysServiceMapper;
import com.car.web.model.car.SysCarEntity;
import com.car.web.model.customer.SysCustomerEntity;
import com.car.web.model.service.SysMaterialCostEntity;
import com.car.web.model.service.SysOtherCostEntity;
import com.car.web.model.service.SysServiceCostEntity;
import com.car.web.model.service.SysServiceEntity;
import com.car.web.service.Manager.SysCarManager;
import com.car.web.service.Manager.SysCustomerManager;
import com.car.web.service.Manager.SysServiceManager;
@Component("sysServiceManager")
public class SysServiceManagerImpl implements SysServiceManager {
	
	@Autowired
	private SysServiceMapper sysServiceMapper;
	@Autowired
	private SysServiceCostMapper sysServiceCostMapper;
	
	@Autowired
	private SysMaterialCostMapper sysMaterialCostMapper;
	
	@Autowired
	private SysOtherCostMapper sysOtherCostMapper;
	
	@Override
	public int saveService(SysServiceEntity service) {
		int count = sysServiceMapper.save(service);
		List<SysServiceCostEntity> serviceCostList = service.getServiceCostList();
		//维修费用
		if(serviceCostList.size()>0){
			List<SysServiceCostEntity> addList = new ArrayList<SysServiceCostEntity>();
			for(SysServiceCostEntity entity:serviceCostList){
				entity.setServiceId(service.getId());
				addList.add(entity);
			}
			if(addList.size()>0){
				sysServiceCostMapper.batchSave(addList);
			}
		}
		List<SysMaterialCostEntity> meterialCostList = service.getMaterialCostList();
		if(meterialCostList.size()>0){
			List<SysMaterialCostEntity> addList = new ArrayList<SysMaterialCostEntity>();
			for(SysMaterialCostEntity entity:meterialCostList){
				entity.setServiceId(service.getId());
				addList.add(entity);
			}
			if(addList.size()>0){
				sysMaterialCostMapper.batchSave(addList);
			}
		}
		List<SysOtherCostEntity> otherCostList = service.getOtherCostList();
		if(otherCostList.size()>0){
			List<SysOtherCostEntity> addList = new ArrayList<SysOtherCostEntity>();
			for(SysOtherCostEntity entity:otherCostList){
				entity.setServiceId(service.getId());
				addList.add(entity);
			}
			if(addList.size()>0){
				sysOtherCostMapper.batchSave(addList);
			}
		}
		return count;
	}
	@Override
	public List<SysServiceEntity> list(Query query) {
		return sysServiceMapper.list(query);
	}
	@Override
	public SysServiceEntity getServiceById(Long customerId) {
		return sysServiceMapper.getObjectById(customerId);
	}
	@Override
	public int updateService(SysServiceEntity service) {
		int count = sysServiceMapper.update(service);
		List<SysServiceCostEntity> serviceCostList = service.getServiceCostList();
		//维修费用
		if(serviceCostList.size()>0){
			List<SysServiceCostEntity> addList = new ArrayList<SysServiceCostEntity>();
			List<SysServiceCostEntity> updateList = new ArrayList<SysServiceCostEntity>();
			for(SysServiceCostEntity entity:serviceCostList){
				entity.setServiceId(service.getId());
				if(entity.getId()!=null){
					updateList.add(entity);
				}else{
					addList.add(entity);
				}
			}
			if(addList.size()>0){
				sysServiceCostMapper.batchSave(addList);
			}
			if(updateList.size()>0){
				sysServiceCostMapper.batchUpdate(updateList);
			}
		}
		List<SysMaterialCostEntity> meterialCostList = service.getMaterialCostList();
		if(meterialCostList.size()>0){
			List<SysMaterialCostEntity> addList = new ArrayList<SysMaterialCostEntity>();
			List<SysMaterialCostEntity> updateList = new ArrayList<SysMaterialCostEntity>();
			for(SysMaterialCostEntity entity:meterialCostList){
				entity.setServiceId(service.getId());
				if(entity.getId()!=null){
					updateList.add(entity);
				}else{
					addList.add(entity);
				}
			}
			if(addList.size()>0){
				sysMaterialCostMapper.batchSave(addList);
			}
			if(updateList.size()>0){
				sysMaterialCostMapper.batchUpdate(updateList);
			}
		}
		List<SysOtherCostEntity> otherCostList = service.getOtherCostList();
		if(otherCostList.size()>0){
			List<SysOtherCostEntity> addList = new ArrayList<SysOtherCostEntity>();
			List<SysOtherCostEntity> updateList = new ArrayList<SysOtherCostEntity>();
			for(SysOtherCostEntity entity:otherCostList){
				entity.setServiceId(service.getId());
				if(entity.getId()!=null){
					updateList.add(entity);
				}else{
					addList.add(entity);
				}
			}
			if(addList.size()>0){
				sysOtherCostMapper.batchSave(addList);
			}
			if(updateList.size()>0){
				sysOtherCostMapper.batchUpdate(updateList);
			}
		}
		
		//删除
		if(service.getRemoveServiceCostIDList().size()>0){
			sysServiceCostMapper.batchRemove(service.getRemoveServiceCostIDList().toArray());
		}
		if(service.getRemoveMaterialCostIDList().size()>0){
			sysMaterialCostMapper.batchRemove(service.getRemoveMaterialCostIDList().toArray());
		}
		if(service.getRemoveOtherCostIDList().size()>0){
			sysOtherCostMapper.batchRemove(service.getRemoveOtherCostIDList().toArray());
		}
		return count;
	}
	@Override
	public int batchRemoveArea(Long[] id) {
		return sysServiceMapper.batchRemove(id);
	}

}
