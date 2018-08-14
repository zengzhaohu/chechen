package com.car.web.controller.base.car;

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
import com.car.web.service.base.area.SysAreaService;
import com.car.web.service.base.car.SysCarService;

/**
 * 车辆管理
 */
@RestController
@RequestMapping("/sys/car")
public class SysCarController extends AbstractController {
	
	@Autowired
	private SysCarService sysCarService;
	
	/**
	 * 根据父级code查询子节点，子区域列表
	 * @param params
	 * @return
	 */
	@RequestMapping("/list")
	public R list(@RequestBody Map<String, Object> params) {
		return sysCarService.list(params);
	}
	/**
	 * 新增区域
	 * @param area
	 * @return
	 */
	@SysLog("新增车辆")
	@RequestMapping("/save")
	public R save(@RequestBody SysCarEntity car) {
		return sysCarService.saveCar(car);
	}
	
	/**
	 * 查询详情
	 * @param areaId
	 * @return
	 */
	@RequestMapping("/info")
	public R info(@RequestBody Long areaId) {
		return sysCarService.getCarById(areaId);
	}
	
	/**
	 * 修改区域
	 * @param area
	 * @return
	 */
	@SysLog("修改车辆")
	@RequestMapping("/update")
	public R update(@RequestBody SysCarEntity car) {
		return sysCarService.updateCar(car);
	}
	
	/**
	 * 删除区域
	 * @param id
	 * @return
	 */
	@SysLog("删除区域")
	@RequestMapping("/remove")
	public R remove(@RequestBody Long[] id) {
		return sysCarService.batchRemoveArea(id);
	}
	
	/**
	 * 车辆关联车主
	 * @param params
	 * @return
	 */
	@SysLog("车辆关联车主")
	@RequestMapping("/relativeCustomer")
	public R relativeCustomer(@RequestBody Map<String,String> params) {
		return sysCarService.relativeCustomer(params);
	}
}
