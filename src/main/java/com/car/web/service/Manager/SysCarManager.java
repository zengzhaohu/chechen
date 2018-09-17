package com.car.web.service.Manager;

import java.util.List;
import java.util.Map;

import com.car.web.common.entity.Page;
import com.car.web.common.entity.Query;
import com.car.web.model.SysAreaEntity;
import com.car.web.model.car.SysCarEntity;


/**
 * 车辆管理
 * 
 */
public interface SysCarManager {
	int saveCar(SysCarEntity car);
	List<SysCarEntity> list(Query query);
	SysCarEntity getCarById(Long carId);
	int updateCar(SysCarEntity car);
	int batchRemoveArea(Long[] id);
	int relativeCustomer(Map<String, String> params);
	List<SysCarEntity> listForPage(Query query, Page<SysCarEntity> page);
}
