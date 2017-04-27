/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.air.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.air.entity.TbAirQuality;
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

    public TbAirQuality getCurrentAQ() {
		TbAirQuality AQ=new TbAirQuality();
		//AQ.setCo2();
		return null;
    }
}