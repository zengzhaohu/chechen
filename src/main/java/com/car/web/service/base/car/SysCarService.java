package com.car.web.service.base.car;

import java.util.List;
import java.util.Map;

import com.car.web.common.R;
import com.car.web.model.SysAreaEntity;
import com.car.web.model.car.SysCarEntity;

/**
 * 车辆管理
 * 
 */
public interface SysCarService {
	
	R saveCar(SysCarEntity car);

	R list(Map<String, Object> params);

	R getCarById(Long areaId);

	R updateCar(SysCarEntity car);

	R batchRemoveArea(Long[] id);

	R relativeCustomer(Map<String, String> params);
	
}
