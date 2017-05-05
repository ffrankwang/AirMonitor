/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.air.entity;


import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 甲醛Entity
 * @author Frank Wang
 * @version 2017-05-05
 */
public class TbHCHO extends DataEntity<TbHCHO> {
	
	private static final long serialVersionUID = 1L;
	private Float HCHO;		// HCHO
	
	public TbHCHO() {
		super();
	}

	public TbHCHO(String id){
		super(id);
	}

	public Float getHCHO() {
		return HCHO;
	}

	public void setHCHO(Float hCHO) {
		HCHO = hCHO;
	}

	
}