/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.air.entity;


import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 温湿度Entity
 * @author Frank Wang
 * @version 2017-04-27
 */
public class TbTempHum extends DataEntity<TbTempHum> {
	
	private static final long serialVersionUID = 1L;
	private String temp;		// 温度
	private String hum;		// 湿度
	
	public TbTempHum() {
		super();
	}

	public TbTempHum(String id){
		super(id);
	}

	public String getTemp() {
		return temp;
	}

	public void setTemp(String temp) {
		this.temp = temp;
	}
	
	public String getHum() {
		return hum;
	}

	public void setHum(String hum) {
		this.hum = hum;
	}
	
}