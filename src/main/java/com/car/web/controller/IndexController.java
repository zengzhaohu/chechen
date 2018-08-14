/**
 * 
 */
package com.car.web.controller;


import lombok.extern.log4j.Log4j2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 	@author zengzhaohu
 *	@date 2017年9月28日 下午4:04:35 
 * 	@version V1.0   
 */
@Controller
@RequestMapping(value="/")
@Log4j2(topic="IndexController")
public class IndexController {
	
	@RequestMapping
	public String index(Model model){
		return "index";
	}
}
