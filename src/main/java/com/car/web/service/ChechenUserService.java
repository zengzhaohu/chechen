/**
 * 
 */
package com.car.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tk.mybatis.mapper.entity.Example;

import com.car.web.mapper.ChechenUserMapper;
import com.car.web.model.ChechenUser;
import com.github.pagehelper.PageHelper;

/**
 * 	用户信息服务
 * 	@author zengzhaohu
 *	@date 2017年10月28日 下午6:15:35 
 * 	@version V1.0   
 */
@Service
public class ChechenUserService {
	@Autowired
	private ChechenUserMapper chechenUserMapper; 
	
	public List<ChechenUser> getAll(ChechenUser user){
		if(user.getPage()!=null && user.getRows()!=null){
			PageHelper.startPage(user.getPage(), user.getRows());
		}
		Example example = new Example(ChechenUser.class);
		Example.Criteria criteria = example.createCriteria();
		if(user.getId()!=null){
			criteria.andCondition("id", user.getId());
		}
		if(user.getUsercode()!=null&& user.getUsercode().trim().length()>0){
			criteria.andLike("usercode", "%"+user.getUsercode().trim()+"%");
		}
		if(user.getUsername()!=null && user.getUsername().trim().length()>0){
			criteria.andLike("username", "%"+user.getUsername()+"%");
		}
		return chechenUserMapper.selectByExample(example);
	}
	
	public ChechenUser getById(Long id){
		return chechenUserMapper.selectByPrimaryKey(id);
	}
	
	public void deleteById(Long id){
		chechenUserMapper.deleteByPrimaryKey(id);
	}
	
	public void save(ChechenUser user){
		if(user.getId()!=null){
			chechenUserMapper.updateByPrimaryKey(user);
		}else{
			chechenUserMapper.insert(user);
		}
	}
}
