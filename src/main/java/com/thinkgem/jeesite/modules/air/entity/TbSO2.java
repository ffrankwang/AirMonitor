/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.air.entity;

import java.util.Date;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 二氧化硫Entity
 * @author Frank Wang
 * @version 2017-05-06
 */
public class TbSO2 extends DataEntity<TbSO2> {
	
	private static final long serialVersionUID = 1L;
	private Float SO2;		// SO2
	private Date beginUpdateDate;		// 开始 更新时间
	private Date endUpdateDate;		// 结束 更新时间
	
	public TbSO2() {
		super();
	}

	public TbSO2(String id){
		super(id);
	}

	public Float getSO2() {
		return SO2;
	}

	public void setSO2(Float SO2) {
		this.SO2 = SO2;
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