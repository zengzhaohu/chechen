package com.car.web.mapper.customer;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;

import com.car.web.mapper.BaseMapper;
import com.car.web.model.customer.SysCustomerEntity;


/**
 * 保存车辆dao
 */
@MapperScan
public interface SysCustomerMapper extends BaseMapper<SysCustomerEntity> {
	
}
