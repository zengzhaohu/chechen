package com.car.web.mapper.maintain;
import java.util.List;

import org.mybatis.spring.annotation.MapperScan;

import com.car.web.mapper.BaseMapper;
import com.car.web.model.maintain.SysMaintainServiceCostEntity;
import com.car.web.model.service.SysServiceCostEntity;
import com.car.web.model.service.SysServiceEntity;


/**
 * 保存车辆dao
 */
@MapperScan
public interface SysMaintainServiceCostMapper extends BaseMapper<SysMaintainServiceCostEntity> {

	void batchUpdate(List<SysMaintainServiceCostEntity> updateList);
	
}
