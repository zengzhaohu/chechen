package com.car.web.schedule;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.car.web.mapper.maintain.SysMaintainMapper;
import com.car.web.model.maintain.SysMaintainEntity;

@Component
public class MaintainSchedule {

	@Autowired
	SysMaintainMapper sysMaintainMapper;
	/**
	 * 每天凌晨执行
	 * 
	 * 0 0 0 * * ?
	 */
	@Scheduled(cron="0 0 0 * * ?")
	public void updateMaintain(){
		List<SysMaintainEntity> list = sysMaintainMapper.listByStatus("0");
		if(list.size()>0){
			for(SysMaintainEntity entity:list){
				entity.setStatus("1");
			}
			int count = sysMaintainMapper.batchUpdate(list);
			System.out.println("定时任务更新count="+count);
		}
			
	}
}
