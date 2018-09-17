package com.car.web.service.Manager.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.car.web.common.entity.Page;
import com.car.web.common.entity.Query;
import com.car.web.mapper.maintain.SysMaintainMapper;
import com.car.web.mapper.maintain.SysMaintainMaterialCostMapper;
import com.car.web.mapper.maintain.SysMaintainOtherCostMapper;
import com.car.web.mapper.maintain.SysMaintainServiceCostMapper;
import com.car.web.model.maintain.SysMaintainEntity;
import com.car.web.model.maintain.SysMaintainMaterialCostEntity;
import com.car.web.model.maintain.SysMaintainOtherCostEntity;
import com.car.web.model.maintain.SysMaintainServiceCostEntity;
import com.car.web.service.Manager.SysMaintainManager;
@Component("sysMaintainManager")
public class SysMaintainManagerImpl implements SysMaintainManager {
	
	@Autowired
	private SysMaintainMapper sysMaintainMapper;
	@Autowired
	private SysMaintainServiceCostMapper sysMaintainServiceCostMapper;
	
	@Autowired
	private SysMaintainMaterialCostMapper sysMaintainMaterialCostMapper;
	
	@Autowired
	private SysMaintainOtherCostMapper sysMaintainOtherCostMapper;
	
	@Override
	public int saveMaintain(SysMaintainEntity service) {
		int count = sysMaintainMapper.save(service);
		List<SysMaintainServiceCostEntity> serviceCostList = service.getServiceCostList();
		//维修费用
		if(serviceCostList.size()>0){
			List<SysMaintainServiceCostEntity> addList = new ArrayList<SysMaintainServiceCostEntity>();
			for(SysMaintainServiceCostEntity entity:serviceCostList){
				entity.setServiceId(service.getId());
				addList.add(entity);
			}
			if(addList.size()>0){
				sysMaintainServiceCostMapper.batchSave(addList);
			}
		}
		List<SysMaintainMaterialCostEntity> meterialCostList = service.getMaterialCostList();
		if(meterialCostList.size()>0){
			List<SysMaintainMaterialCostEntity> addList = new ArrayList<SysMaintainMaterialCostEntity>();
			for(SysMaintainMaterialCostEntity entity:meterialCostList){
				entity.setServiceId(service.getId());
				addList.add(entity);
			}
			if(addList.size()>0){
				sysMaintainMaterialCostMapper.batchSave(addList);
			}
		}
		List<SysMaintainOtherCostEntity> otherCostList = service.getOtherCostList();
		if(otherCostList.size()>0){
			List<SysMaintainOtherCostEntity> addList = new ArrayList<SysMaintainOtherCostEntity>();
			for(SysMaintainOtherCostEntity entity:otherCostList){
				entity.setServiceId(service.getId());
				addList.add(entity);
			}
			if(addList.size()>0){
				sysMaintainOtherCostMapper.batchSave(addList);
			}
		}
		return count;
	}
	@Override
	public List<SysMaintainEntity> list(Query query) {
		return sysMaintainMapper.list(query);
	}
	@Override
	public SysMaintainEntity getServiceById(Long customerId) {
		return sysMaintainMapper.getObjectById(customerId);
	}
	@Override
	public int updateService(SysMaintainEntity service) {
		int count = sysMaintainMapper.update(service);
		List<SysMaintainServiceCostEntity> serviceCostList = service.getServiceCostList();
		//维修费用
		if(serviceCostList.size()>0){
			List<SysMaintainServiceCostEntity> addList = new ArrayList<SysMaintainServiceCostEntity>();
			List<SysMaintainServiceCostEntity> updateList = new ArrayList<SysMaintainServiceCostEntity>();
			for(SysMaintainServiceCostEntity entity:serviceCostList){
				entity.setServiceId(service.getId());
				if(entity.getId()!=null){
					updateList.add(entity);
				}else{
					addList.add(entity);
				}
			}
			if(addList.size()>0){
				sysMaintainServiceCostMapper.batchSave(addList);
			}
			if(updateList.size()>0){
				sysMaintainServiceCostMapper.batchUpdate(updateList);
			}
		}
		List<SysMaintainMaterialCostEntity> meterialCostList = service.getMaterialCostList();
		if(meterialCostList.size()>0){
			List<SysMaintainMaterialCostEntity> addList = new ArrayList<SysMaintainMaterialCostEntity>();
			List<SysMaintainMaterialCostEntity> updateList = new ArrayList<SysMaintainMaterialCostEntity>();
			for(SysMaintainMaterialCostEntity entity:meterialCostList){
				entity.setServiceId(service.getId());
				if(entity.getId()!=null){
					updateList.add(entity);
				}else{
					addList.add(entity);
				}
			}
			if(addList.size()>0){
				sysMaintainMaterialCostMapper.batchSave(addList);
			}
			if(updateList.size()>0){
				sysMaintainMaterialCostMapper.batchUpdate(updateList);
			}
		}
		List<SysMaintainOtherCostEntity> otherCostList = service.getOtherCostList();
		if(otherCostList.size()>0){
			List<SysMaintainOtherCostEntity> addList = new ArrayList<SysMaintainOtherCostEntity>();
			List<SysMaintainOtherCostEntity> updateList = new ArrayList<SysMaintainOtherCostEntity>();
			for(SysMaintainOtherCostEntity entity:otherCostList){
				entity.setServiceId(service.getId());
				if(entity.getId()!=null){
					updateList.add(entity);
				}else{
					addList.add(entity);
				}
			}
			if(addList.size()>0){
				sysMaintainOtherCostMapper.batchSave(addList);
			}
			if(updateList.size()>0){
				sysMaintainOtherCostMapper.batchUpdate(updateList);
			}
		}
		
		//删除
		if(service.getRemoveServiceCostIDList().size()>0){
			sysMaintainServiceCostMapper.batchRemove(service.getRemoveServiceCostIDList().toArray());
		}
		if(service.getRemoveMaterialCostIDList().size()>0){
			sysMaintainMaterialCostMapper.batchRemove(service.getRemoveMaterialCostIDList().toArray());
		}
		if(service.getRemoveOtherCostIDList().size()>0){
			sysMaintainOtherCostMapper.batchRemove(service.getRemoveOtherCostIDList().toArray());
		}
		return count;
	}
	@Override
	public int batchRemoveArea(Long[] id) {
		return sysMaintainMapper.batchRemove(id);
	}
	@Override
	public List<SysMaintainEntity> listForPage(Query query, Page<SysMaintainEntity> page) {
		return sysMaintainMapper.listForPage(page, query);
	}

}
