/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.air.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 空气质量Entity
 * @author Frank Wang
 * @version 2017-04-27
 */
public class TbAirQuality extends DataEntity<TbAirQuality> {
	
	private static final long serialVersionUID = 1L;
	private TbTempHum tempHum;		// temp_hum
	private TbPm25 pm25;		// pm25
	private TbCO2 co2;		// co2
	
	public TbAirQuality() {
		super();
	}

	public TbAirQuality(String id){
		super(id);
	}

	public TbTempHum getTempHum() {
		return tempHum;
	}

	public void setTempHum(TbTempHum tempHum) {
		this.tempHum = tempHum;
	}

	public TbPm25 getPm25() {
		return pm25;
	}

	public void setPm25(TbPm25 pm25) {
		this.pm25 = pm25;
	}

	public TbCO2 getCo2() {
		return co2;
	}

	public void setCo2(TbCO2 co2) {
		this.co2 = co2;
	}
}