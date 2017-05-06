/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.air.entity;

import java.util.Date;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 一氧化碳Entity
 * @author Frank Wang
 * @version 2017-05-06
 */
public class TbCO extends DataEntity<TbCO> {
	
	private static final long serialVersionUID = 1L;
	private Float CO;		// 一氧化碳
	private Date beginUpdateDate;		// 开始 更新时间
	private Date endUpdateDate;		// 结束 更新时间
	
	public TbCO() {
		super();
	}

	public TbCO(String id){
		super(id);
	}

	
	public Float getCO() {
		return CO;
	}

	public void setCO(Float cO) {
		CO = cO;
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