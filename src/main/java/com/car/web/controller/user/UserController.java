/**
 * 
 */
package com.car.web.controller.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;




import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.car.web.model.ChechenUser;
import com.car.web.service.ChechenUserService;
import com.github.pagehelper.PageInfo;

/**
 * 打开用户界面
 * 	@author zengzhaohu
 *	@date 2017年10月30日 上午10:58:10 
 * 	@version V1.0   
 */
@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	ChechenUserService chechenUserService;
	@RequestMapping
	public ModelAndView index (ChechenUser user){
		ModelAndView result = new ModelAndView("/user/user_index");
		List<ChechenUser> list = chechenUserService.getAll(user);
		result.addObject("pageInfo", new PageInfo<ChechenUser>(list));
        result.addObject("queryParam", user);
        result.addObject("page", user.getPage());
        result.addObject("rows", user.getRows());
		return result;
	}
	
	@RequestMapping(value="/add")
	public ModelAndView add(){
		ModelAndView model = new ModelAndView("/user/user_add");
		model.addObject("user",new ChechenUser());
		return model;
	}
	
	@RequestMapping(value="/view/{id}")
	public ModelAndView view(@PathVariable String id){
		ModelAndView model = new ModelAndView("/user/user_add");
		ChechenUser user = null;
		if(id!=null){
			 user = chechenUserService.getById(Long.parseLong(id));
		}else{
			user = new ChechenUser();
		}
		model.addObject("user",user);
		return model;
	}
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public ModelAndView save(ChechenUser user){
		ModelAndView model = new ModelAndView("/user/user_add"); 
		String msg = user.getId()==null?"新增成功":"更新成功";
		chechenUserService.save(user);
		model.addObject("user", user);
		model.addObject("msg",msg);
		return model;
	}
	
	@RequestMapping(value="/delete/{id}")
	public ModelAndView delete(@PathVariable String id,RedirectAttributes ra){
		ModelAndView model = new ModelAndView("redirect:/user/");
		if(id !=null){
			chechenUserService.deleteById(Long.parseLong(id));
			ra.addFlashAttribute("msg", "删除成功");
		}
		
		return model;
	}
}
