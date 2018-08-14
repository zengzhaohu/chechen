/**
 * 
 */
package com.car.web.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.car.web.model.CarUser;
import com.car.web.service.CarUserService;
import com.github.pagehelper.PageInfo;

/**
 * 	@author zengzhaohu
 *	@date 2017年9月27日 下午10:00:04 
 * 	@version V1.0   
 */
@RestController
@RequestMapping("/test")
public class TestController {
	
	@Autowired
	private CarUserService carUserService;
	
	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	@RequestMapping
	public PageInfo<CarUser> getAll(CarUser user){
		List<CarUser> list = carUserService.getAll(user);
		return new PageInfo<CarUser>(list);
	}
	
	@RequestMapping(value="/add")
	public CarUser add(){
		return new CarUser();
	}
	
	@RequestMapping(value="/view/{id}")
	public CarUser view(@PathVariable Long id){
		@SuppressWarnings("unused")
		List<Map<String, Object>> list =  jdbcTemplate.queryForList("select * from car_user");
		CarUser user = carUserService.getById(id);
		return user;
	}
	
	@RequestMapping(value="/delete/{id}")
	public ModelMap delete(@PathVariable Long id){
		ModelMap result = new ModelMap();
		carUserService.deleteById(id);
		result.addAttribute("msg", "删除成功");
		return result;
	}
	@RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelMap save(CarUser user) {
        ModelMap result = new ModelMap();
        String msg = user.getId() == null ? "新增成功!" : "更新成功!";
        carUserService.save(user);
        result.put("city", user);
        result.put("msg", msg);
        return result;
    }
	
	
}
