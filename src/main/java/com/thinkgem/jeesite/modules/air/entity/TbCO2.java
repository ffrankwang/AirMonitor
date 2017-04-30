/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.air.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * CO2Entity
 * @author Frank Wang
 * @version 2017-04-27
 */
public class TbCO2 extends DataEntity<TbCO2> {
	
	private static final long serialVersionUID = 1L;
	private Integer co2;		// co2浓度
	
	public TbCO2() {
		super();
	}

	public TbCO2(String id){
		super(id);
	}

	public Integer getCo2() {
		return co2;
	}

	public void setCo2(Integer co2) {
		this.co2 = co2;
	}

}