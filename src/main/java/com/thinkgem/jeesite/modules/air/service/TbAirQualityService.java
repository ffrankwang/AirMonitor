/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.air.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.common.utils.IdGen;
import com.thinkgem.jeesite.common.utils.JMap;
import com.thinkgem.jeesite.modules.air.entity.TbAirQuality;
import com.thinkgem.jeesite.modules.air.entity.TbCO2;
import com.thinkgem.jeesite.modules.air.entity.TbPm25;
import com.thinkgem.jeesite.modules.air.entity.TbTempHum;
import com.thinkgem.jeesite.modules.air.util.AQGenerator;
import com.thinkgem.jeesite.modules.air.dao.TbAirQualityDao;

/**
 * 空气质量Service
 * @author Frank Wang
 * @version 2017-04-27
 */
@Service
@Transactional(readOnly = false)
public class TbAirQualityService extends CrudService<TbAirQualityDao, TbAirQuality> {
	@Autowired
	private TbCO2Service co2Service;
	@Autowired
	private TbPm25Service pm25Service;
	@Autowired
	private TbTempHumService tempHumSerice;
	
	
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
	public  void save(TbAirQuality tbAirQuality) {
		
	}
	
	@Transactional(readOnly = false)
	public void delete(TbAirQuality tbAirQuality) {
		super.delete(tbAirQuality);
	}

    public JMap getCurrentAQ() {
    	JMap create = JMap.create();
    	TbAirQuality currentAQ = AQGenerator.getCurrentAQ();
    	//将温度信息保存到数据库中
    	TbCO2 co2 = new TbCO2();
    	TbPm25 pm25 = new TbPm25();
    	TbTempHum tempHum = new TbTempHum();
    	co2.setCo2(currentAQ.getCo2().getCo2());
    	pm25.setPm25(currentAQ.getPm25().getPm25());
    	tempHum.setTemp(currentAQ.getTempHum().getTemp());
    	tempHum.setHum(currentAQ.getTempHum().getHum());
    	co2Service.save(co2);
    	pm25Service.save(pm25);
    	tempHumSerice.save(tempHum);
    	
    	Map<String,Object> map=new HashMap<String,Object>();
    	map.put("temp", currentAQ.getTempHum().getTemp());
    	map.put("hum", currentAQ.getTempHum().getHum());
    	map.put("co2", currentAQ.getCo2().getCo2());
    	map.put("pm25", currentAQ.getPm25().getPm25());
    	create.set(map);
    	return create;
    }
}