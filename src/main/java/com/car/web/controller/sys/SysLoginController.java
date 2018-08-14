package com.car.web.controller.sys;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.car.web.common.R;
import com.car.web.common.annotation.SysLog;
import com.car.web.common.utils.MD5Utils;
import com.car.web.common.utils.ShiroUtils;
import com.car.web.controller.AbstractController;
import com.car.web.model.SysUserEntity;
import com.car.web.service.SysUserService;

/**
 * 用户controller
 *
 * @author ZhouChenglin
 * @email yczclcn@163.com
 * @url www.chenlintech.com
 * @date 2017年8月8日 下午2:48:50
 */
@RestController
@RequestMapping("/sys")
public class SysLoginController extends AbstractController {
	
	@Autowired
	private SysUserService sysUserService;
	
	/**
	 * 登录
	 */
	@SysLog("登录")
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public R login(String username, String password)throws IOException {
		SysUserEntity user = sysUserService.getByUserName(username);
		password = MD5Utils.encrypt(username, password);
		
		if(user == null || !user.getPassword().equals(password)) {
			return R.error("用户名或密码错误");
		}
		
		if(user.getStatus() == 0) {
			return R.error("账号已被锁定,请联系管理员");
		}
		R r = sysUserService.saveUserToken(user.getUserId());
		ServletRequestAttributes attrs = (ServletRequestAttributes) RequestContextHolder 
				.getRequestAttributes();
		attrs.getRequest().getSession().setAttribute("token", r.get("token"));
		attrs.getRequest().getSession().setAttribute("expire", r.get("expire"));
		System.out.println("login session id="+attrs.getRequest().getSession().getId());
		return  r;
	}
	
	/**
	 * 退出
	 */
	@SysLog("退出系统")
	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	public R logout() {
		R r = sysUserService.updateUserToken(getUserId());
		ShiroUtils.logout();
		
		return r;
	}
	
}
