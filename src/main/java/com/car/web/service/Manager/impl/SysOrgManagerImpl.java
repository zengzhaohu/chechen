package com.car.web.service.Manager.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.car.web.common.utils.CommonUtils;
import com.car.web.mapper.SysOrgMapper;
import com.car.web.mapper.SysRoleOrgMapper;
import com.car.web.model.SysOrgEntity;
import com.car.web.service.Manager.SysOrgManager;


/**
 * 组织架构
 *
 * @author ZhouChenglin
 * @email yczclcn@163.com
 * @url www.chenlintech.com
 * @date 2017年8月17日 上午11:32:15
 */
@Component("sysOrgManager")
public class SysOrgManagerImpl implements SysOrgManager {

	@Autowired
	private SysOrgMapper sysOrgMapper;
	
	@Autowired
	private SysRoleOrgMapper sysRoleOrgMapper;
	
	@Override
	public List<SysOrgEntity> listOrg() {
		return sysOrgMapper.list();
	}

	@Override
	public int saveOrg(SysOrgEntity org) {
		return sysOrgMapper.save(org);
	}

	@Override
	public SysOrgEntity getOrg(Long orgId) {
		return sysOrgMapper.getObjectById(orgId);
	}

	@Override
	public int updateOrg(SysOrgEntity org) {
		return sysOrgMapper.update(org);
	}

	@Override
	public int bactchRemoveOrg(Long[] id) {
		int count = sysOrgMapper.batchRemove(id);
		sysRoleOrgMapper.batchRemoveByOrgId(id);
		return count;
	}

	@Override
	public boolean hasChildren(Long[] id) {
		for(Long parentId : id) {
			int count = sysOrgMapper.countOrgChildren(parentId);
			if(CommonUtils.isIntThanZero(count)) {
				return true;
			}
		}
		return false;
	}

}
