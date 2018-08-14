package com.car.web.mapper.maintain;
import java.util.List;

import org.mybatis.spring.annotation.MapperScan;

import com.car.web.mapper.BaseMapper;
import com.car.web.model.maintain.SysMaintainEntity;
import com.car.web.model.service.SysServiceEntity;


/**
 * 保存车辆dao
 */
@MapperScan
public interface SysMaintainMapper extends BaseMapper<SysMaintainEntity> {

	List<SysMaintainEntity> listByStatus(String c);
	int batchUpdate(List<SysMaintainEntity> list);
	
}
