/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.air.entity;


import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 二氧化硫Entity
 * @author Frank Wang
 * @version 2017-05-05
 */
public class TbSO2 extends DataEntity<TbSO2> {
	
	private static final long serialVersionUID = 1L;
	private Float SO2;		// SO2
	
	public TbSO2() {
		super();
	}

	public TbSO2(String id){
		super(id);
	}

	public Float getSO2() {
		return SO2;
	}

	public void setSO2(Float sO2) {
		SO2 = sO2;
	}

	
}