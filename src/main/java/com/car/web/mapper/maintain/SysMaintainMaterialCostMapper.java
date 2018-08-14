package com.car.web.mapper.maintain;
import java.util.List;

import org.mybatis.spring.annotation.MapperScan;

import com.car.web.mapper.BaseMapper;
import com.car.web.model.maintain.SysMaintainMaterialCostEntity;
import com.car.web.model.service.SysMaterialCostEntity;
import com.car.web.model.service.SysServiceEntity;


/**
 * 保存车辆dao
 */
@MapperScan
public interface SysMaintainMaterialCostMapper extends BaseMapper<SysMaintainMaterialCostEntity> {

	void batchUpdate(List<SysMaintainMaterialCostEntity> updateList);
	
}
