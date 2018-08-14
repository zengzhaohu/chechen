/**
 * 
 */
package com.car.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.car.web.mapper.CarUserMapper;
import com.car.web.model.CarUser;
import com.github.pagehelper.PageHelper;

/**
 * 	@author zengzhaohu
 *	@date 2017年9月27日 下午10:02:28 
 * 	@version V1.0   
 */
@Service
public class CarUserService {
	@Autowired
	private CarUserMapper carUserMapper;
	
	public List<CarUser> getAll(CarUser carUser){
		if(carUser.getPage()!=null && carUser.getRows()!=null){
			PageHelper.startPage(carUser.getPage(),carUser.getRows());
		}
		return carUserMapper.selectAll();
	}
	
	public CarUser getById(Long id){
		return carUserMapper.selectByPrimaryKey(id);
	}
	
	public void deleteById(Long id){
		carUserMapper.deleteByPrimaryKey(id);
	}
	
	public void save(CarUser user){
		if(user.getId()!=null){
			carUserMapper.updateByPrimaryKey(user);
		}else{
			carUserMapper.insert(user);
			
		}
	}
}
