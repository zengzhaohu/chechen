package com.car.web.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.car.web.model.SysRoleEntity;


/**
 * 系统角色
 *
 * @author ZhouChenglin
 * @email yczclcn@163.com
 * @url www.chenlintech.com
 * @date 2017年8月12日 上午12:35:51
 */
@Mapper
public interface SysRoleMapper extends BaseMapper<SysRoleEntity> {
	
	List<String> listUserRoles(Long userId);
	
}
