package com.car.web.controller.base.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.car.web.common.R;
import com.car.web.common.annotation.SysLog;
import com.car.web.controller.AbstractController;
import com.car.web.model.SysAreaEntity;
import com.car.web.model.car.SysCarEntity;
import com.car.web.model.customer.SysCustomerEntity;
import com.car.web.model.service.SysServiceEntity;
import com.car.web.service.base.area.SysAreaService;
import com.car.web.service.base.car.SysCarService;
import com.car.web.service.base.customer.SysCustomerService;
import com.car.web.service.base.service.SysServiceService;

/**
 * 维修管理
 */
@RestController
@RequestMapping("/sys/service")
public class SysServiceController extends AbstractController {
	
	@Autowired
	private SysServiceService syServiceService;
	
	/**
	 * 根据父级code查询子节点，子区域列表
	 * @param params
	 * @return
	 */
	@RequestMapping("/list")
	public R list(@RequestBody Map<String, Object> params) {
		return syServiceService.list(params);
	}
	/**
	 * 新增区域
	 * @param area
	 * @return
	 */
	@SysLog("新增车辆")
	@RequestMapping("/save")
	public R save(@RequestBody SysServiceEntity service) {
		return syServiceService.saveService(service);
	}
	
	/**
	 * 查询详情
	 * @param areaId
	 * @return
	 */
	@RequestMapping("/info")
	public R info(@RequestBody Long areaId) {
		return syServiceService.getServiceById(areaId);
	}
	
	/**
	 * 修改区域
	 * @param area
	 * @return
	 */
	@SysLog("修改车辆")
	@RequestMapping("/update")
	public R update(@RequestBody SysServiceEntity service) {
		return syServiceService.updateService(service);
	}
	
	/**
	 * 删除区域
	 * @param id
	 * @return
	 */
	@SysLog("删除区域")
	@RequestMapping("/remove")
	public R remove(@RequestBody Long[] id) {
		return syServiceService.batchRemoveArea(id);
	}
	
}
