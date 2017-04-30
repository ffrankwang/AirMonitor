/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.air.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.common.utils.JMap;
import com.thinkgem.jeesite.modules.air.entity.TbAirQuality;
import com.thinkgem.jeesite.modules.air.util.AQGenerator;
import com.thinkgem.jeesite.modules.air.dao.TbAirQualityDao;

/**
 * 空气质量Service
 * @author Frank Wang
 * @version 2017-04-27
 */
@Service
@Transactional(readOnly = true)
public class TbAirQualityService extends CrudService<TbAirQualityDao, TbAirQuality> {

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
		super.save(tbAirQuality);
	}
	
	@Transactional(readOnly = false)
	public void delete(TbAirQuality tbAirQuality) {
		super.delete(tbAirQuality);
	}

    public JMap getCurrentAQ() {
    	JMap create = JMap.create();
    	TbAirQuality currentAQ = AQGenerator.getCurrentAQ();
    	Map<String,Object> map=new HashMap<String,Object>();
    	map.put("temp", currentAQ.getTempHum().getTemp());
    	map.put("hum", currentAQ.getTempHum().getHum());
    	map.put("co2", currentAQ.getCo2().getCo2());
    	map.put("pm25", currentAQ.getPm25().getPm25());
    	create.set(map);
    	return create;
    }
}