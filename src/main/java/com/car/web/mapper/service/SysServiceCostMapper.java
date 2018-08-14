package com.car.web.mapper.service;
import java.util.List;

import org.mybatis.spring.annotation.MapperScan;

import com.car.web.mapper.BaseMapper;
import com.car.web.model.service.SysServiceCostEntity;
import com.car.web.model.service.SysServiceEntity;


/**
 * 保存车辆dao
 */
@MapperScan
public interface SysServiceCostMapper extends BaseMapper<SysServiceCostEntity> {

	void batchUpdate(List<SysServiceCostEntity> updateList);
	
}
