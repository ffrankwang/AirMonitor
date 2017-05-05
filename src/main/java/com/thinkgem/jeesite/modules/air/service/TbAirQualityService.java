/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.air.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.common.utils.JMap;
import com.thinkgem.jeesite.modules.air.dao.TbAirQualityDao;
import com.thinkgem.jeesite.modules.air.entity.TbAirQuality;
import com.thinkgem.jeesite.modules.air.entity.TbCO2;
import com.thinkgem.jeesite.modules.air.entity.TbHCHO;
import com.thinkgem.jeesite.modules.air.entity.TbPM10;
import com.thinkgem.jeesite.modules.air.entity.TbSO2;
import com.thinkgem.jeesite.modules.air.entity.TbTempHum;
import com.thinkgem.jeesite.modules.air.util.AQGenerator;

/**
 * 空气质量Service
 * 
 * @author Frank Wang
 * @version 2017-04-27
 */
@Service
@Transactional(readOnly = false)
public class TbAirQualityService extends CrudService<TbAirQualityDao, TbAirQuality> {
	@Autowired
	private TbCO2Service co2Service;
	@Autowired
	private TbSO2Service so2Service;
	@Autowired
	private TbTempHumService tempHumService;
	@Autowired
	private TbPM10Service pm10Service;
	@Autowired
	private TbHCHOService hchoService;

	public TbAirQuality get(String id) {
		return super.get(id);
	}

	public List<TbAirQuality> findList(TbAirQuality tbAirQuality) {
		return super.findList(tbAirQuality);
	}

	public Page<TbAirQuality> findPage(Page<TbAirQuality> page, TbAirQuality tbAirQuality) {
		return super.findPage(page, tbAirQuality);
	}

	@Transactional(readOnly = false)
	public void save(TbAirQuality tbAirQuality) {

	}

	@Transactional(readOnly = false)
	public void delete(TbAirQuality tbAirQuality) {
		super.delete(tbAirQuality);
	}

	public JMap getCurrentAQ() {
		JMap create = JMap.create();
		Map<String, Object> currentAQ = AQGenerator.getCurrentAQ();
		create.set(currentAQ);
		//保存信息
		TbCO2 co2 = new TbCO2();
		TbSO2 so2 = new TbSO2();
		TbTempHum tempHum = new TbTempHum();
		TbPM10 pm10 = new TbPM10();
		TbHCHO hcho = new TbHCHO();
		co2.setCO2((Float) currentAQ.get("CO2"));
		so2.setSO2((Float) currentAQ.get("SO2"));
		tempHum.setTemp((Float) currentAQ.get("temp"));
		tempHum.setHum((Float) currentAQ.get("hum"));
		pm10.setPM10((Float) currentAQ.get("PM10"));
		hcho.setHCHO((Float) currentAQ.get("HCHO"));
		co2Service.save(co2);
		so2Service.save(so2);
		tempHumService.save(tempHum);
		pm10Service.save(pm10);
		hchoService.save(hcho);
		return create;
	}
}