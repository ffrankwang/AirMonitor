/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.air.entity;

import java.util.Date;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 甲醛Entity
 * @author Frank Wang
 * @version 2017-05-06
 */
public class TbHCHO extends DataEntity<TbHCHO> {
	
	private static final long serialVersionUID = 1L;
	private Float HCHO;		// HCHO
	private Date beginUpdateDate;		// 开始 更新时间
	private Date endUpdateDate;		// 结束 更新时间
	
	public TbHCHO() {
		super();
	}

	public TbHCHO(String id){
		super(id);
	}

	public Float getHCHO() {
		return HCHO;
	}

	public void setHCHO(Float HCHO) {
		this.HCHO = HCHO;
	}
	
	public Date getBeginUpdateDate() {
		return beginUpdateDate;
	}

	public void setBeginUpdateDate(Date beginUpdateDate) {
		this.beginUpdateDate = beginUpdateDate;
	}
	
	public Date getEndUpdateDate() {
		return endUpdateDate;
	}

	public void setEndUpdateDate(Date endUpdateDate) {
		this.endUpdateDate = endUpdateDate;
	}
		
}