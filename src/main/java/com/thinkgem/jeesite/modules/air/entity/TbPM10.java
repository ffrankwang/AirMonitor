/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.air.entity;

import java.util.Date;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * PM10Entity
 * @author Frank Wang
 * @version 2017-05-06
 */
public class TbPM10 extends DataEntity<TbPM10> {
	
	private static final long serialVersionUID = 1L;
	private Float PM10;		// PM10
	private Date beginUpdateDate;		// 开始 更新时间
	private Date endUpdateDate;		// 结束 更新时间
	
	public TbPM10() {
		super();
	}

	public TbPM10(String id){
		super(id);
	}

	public Float getPM10() {
		return PM10;
	}

	public void setPM10(Float PM10) {
		this.PM10 = PM10;
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