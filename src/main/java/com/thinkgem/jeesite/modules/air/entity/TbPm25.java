/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.air.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * PM2.5Entity
 * @author Frank Wang
 * @version 2017-04-27
 */
public class TbPm25 extends DataEntity<TbPm25> {
	
	private static final long serialVersionUID = 1L;
	private String pm25;		// pm2.5
	
	public TbPm25() {
		super();
	}

	public TbPm25(String id){
		super(id);
	}

	@Length(min=1, max=11, message="登录名长度必须介于 1 和 11 之间")
	public String getPm25() {
		return pm25;
	}

	public void setPm25(String pm25) {
		this.pm25 = pm25;
	}
	
}