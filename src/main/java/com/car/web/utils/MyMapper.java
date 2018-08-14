/**
 * 
 */
package com.car.web.utils;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;
/**
 * 	@author zengzhaohu
 *	@date 2017年9月27日 下午8:13:14 
 * 	@version V1.0   
 */
public interface MyMapper<T> extends Mapper<T>, MySqlMapper<T>  {

}
