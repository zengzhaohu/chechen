package com.car.web.mapper.car;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.annotation.MapperScan;

import com.car.web.mapper.BaseMapper;
import com.car.web.model.car.SysCarEntity;


/**
 * 保存车辆dao
 */
@MapperScan
public interface SysCarMapper extends BaseMapper<SysCarEntity> {

	int saveRelativeCustomer(Map<String, String> params);

	void removeOldCarRelative(String string);
	
}
