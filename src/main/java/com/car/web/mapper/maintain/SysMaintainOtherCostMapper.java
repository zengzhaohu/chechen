package com.car.web.mapper.maintain;
import java.util.List;

import org.mybatis.spring.annotation.MapperScan;

import com.car.web.mapper.BaseMapper;
import com.car.web.model.maintain.SysMaintainOtherCostEntity;
import com.car.web.model.service.SysOtherCostEntity;
import com.car.web.model.service.SysServiceEntity;


/**
 * 保存车辆dao
 */
@MapperScan
public interface SysMaintainOtherCostMapper extends BaseMapper<SysMaintainOtherCostEntity> {

	void batchUpdate(List<SysMaintainOtherCostEntity> updateList);
	
}
