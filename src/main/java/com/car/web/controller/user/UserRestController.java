/**
 * 
 */
package com.car.web.controller.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.car.web.model.ChechenUser;
import com.car.web.service.ChechenUserService;
import com.github.pagehelper.PageInfo;

/**
 * 用户信息管理
 * 	@author zengzhaohu
 *	@date 2017年10月30日 上午10:34:34 
 * 	@version V1.0   
 */
@RestController
@RequestMapping("/restUser")
public class UserRestController {
	
	@Autowired
	private ChechenUserService chechenUserService;
	
	@RequestMapping
	public PageInfo<ChechenUser> getAll(ChechenUser user){
		List<ChechenUser> list = chechenUserService.getAll(user);
		return new PageInfo<ChechenUser>(list);
	}
	
	@RequestMapping(value = "/add",method=RequestMethod.POST)
	public String add(ChechenUser user){
		chechenUserService.save(user);
		return "success";
	}
	
	@RequestMapping(value="/view/{id}")
	public ChechenUser view(@PathVariable Long id){
		return chechenUserService.getById(id);
	}
	
	@RequestMapping(value="/delete/{id}")
	public String deleteById(@PathVariable Long id){
		chechenUserService.deleteById(id);
		return "success";
	}
}
