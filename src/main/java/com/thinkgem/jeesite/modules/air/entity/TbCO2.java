/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.air.entity;

import java.util.Date;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 二氧化碳Entity
 * @author Frank Wang
 * @version 2017-05-06
 */
public class TbCO2 extends DataEntity<TbCO2> {
	
	private static final long serialVersionUID = 1L;
	private Float CO2;		// CO2浓度
	private Date beginUpdateDate;		// 开始 更新时间
	private Date endUpdateDate;		// 结束 更新时间
	
	public TbCO2() {
		super();
	}

	public TbCO2(String id){
		super(id);
	}

	public Float getCO2() {
		return CO2;
	}

	public void setCO2(Float CO2) {
		this.CO2 = CO2;
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