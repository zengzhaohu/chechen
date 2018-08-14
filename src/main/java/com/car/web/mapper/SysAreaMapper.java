package com.car.web.mapper;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;

import com.car.web.common.entity.Query;
import com.car.web.model.SysAreaEntity;


/**
 * 行政区域
 *
 * @author ZhouChenglin
 * @email yczclcn@163.com
 * @url www.chenlintech.com
 * @date 2017年8月18日 下午3:36:04
 */
@MapperScan
public interface SysAreaMapper extends BaseMapper<SysAreaEntity> {

	List<SysAreaEntity> listAreaByParentCode(Query query);
	
	int countAreaChildren(Long areaId);
	
}
