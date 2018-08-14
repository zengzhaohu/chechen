package com.car.web.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.car.web.common.R;
import com.car.web.model.SysMenuEntity;
import com.car.web.service.SysMenuService;
import com.car.web.service.Manager.SysMenuManager;

/**
 * 系统菜单
 *
 * @author ZhouChenglin
 * @email yczclcn@163.com
 * @url www.chenlintech.com
 * @date 2017年8月10日 上午10:36:31
 */
@Service("sysMenuService")
public class SysMenuServiceImpl implements SysMenuService {

	@Autowired
	private SysMenuManager sysMenuManager;
	/* (non-Javadoc)
	 * @see com.car.web.service.SysMenuService#listUserMenu(java.lang.Long)
	 */
	@Override
	public R listUserMenu(Long userId) {
		return R.ok().put("menuList", sysMenuManager.listUserMenu(userId));
	}

	/* (non-Javadoc)
	 * @see com.car.web.service.SysMenuService#listMenu(java.util.Map)
	 */
	@Override
	public List<SysMenuEntity> listMenu(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.car.web.service.SysMenuService#listNotButton()
	 */
	@Override
	public R listNotButton() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.car.web.service.SysMenuService#saveMenu(com.car.web.model.SysMenuEntity)
	 */
	@Override
	public R saveMenu(SysMenuEntity menu) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.car.web.service.SysMenuService#getMenuById(java.lang.Long)
	 */
	@Override
	public R getMenuById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.car.web.service.SysMenuService#updateMenu(com.car.web.model.SysMenuEntity)
	 */
	@Override
	public R updateMenu(SysMenuEntity menu) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.car.web.service.SysMenuService#batchRemove(java.lang.Long[])
	 */
	@Override
	public R batchRemove(Long[] id) {
		// TODO Auto-generated method stub
		return null;
	}
}
