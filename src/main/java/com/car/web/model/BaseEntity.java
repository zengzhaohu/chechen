package com.car.web.model;

import java.beans.Transient;


/**
 * 实体基类，封装分页信息
 * 	@author zengzhaohu
 *	@date 2017年9月27日 下午8:01:31 
* 	@version V1.0
 */
public class BaseEntity {
	
	private Integer page = 1;
	
	private Integer rows = 10;

	/**
	 * @return the page
	 */
	public Integer getPage() {
		return page;
	}

	/**
	 * @param page the page to set
	 */
	public void setPage(Integer page) {
		this.page = page;
	}

	/**
	 * @return the rows
	 */
	public Integer getRows() {
		return rows;
	}

	/**
	 * @param rows the rows to set
	 */
	public void setRows(Integer rows) {
		this.rows = rows;
	}
	
}
