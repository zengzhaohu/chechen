package com.car.web.mapper.service;
import org.mybatis.spring.annotation.MapperScan;

import com.car.web.mapper.BaseMapper;
import com.car.web.model.service.SysServiceEntity;


/**
 * 保存车辆dao
 */
@MapperScan
public interface SysServiceMapper extends BaseMapper<SysServiceEntity> {
	
}
