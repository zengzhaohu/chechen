/**
 * 
 */
package com.car.web.controller;

import com.car.web.model.SysUserEntity;
import com.car.web.utils.ShiroUtils;

import lombok.extern.log4j.Log4j2;

/**
 * 	@author zengzhaohu
 *	@date 2017年11月8日 上午9:32:16 
 * 	@version V1.0   
 */
@Log4j2
public abstract class AbstractController {
	protected SysUserEntity getUser(){
		return ShiroUtils.getUserEntity();
	}
	protected Long getUserId(){
		return getUser().getUserId();
	}
}
