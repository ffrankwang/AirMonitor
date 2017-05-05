/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.air.entity;


import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * PM10Entity
 * @author Frank Wang
 * @version 2017-05-05
 */
public class TbPM10 extends DataEntity<TbPM10> {
	
	private static final long serialVersionUID = 1L;
	private Float PM10;		// PM10
	
	public TbPM10() {
		super();
	}

	public TbPM10(String id){
		super(id);
	}

	public Float getPM10() {
		return PM10;
	}

	public void setPM10(Float pM10) {
		PM10 = pM10;
	}

	
}