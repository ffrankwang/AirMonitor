/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.air.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.air.entity.TbCO2;
import com.thinkgem.jeesite.modules.air.dao.TbCO2Dao;

/**
 * CO2Service
 * @author Frank Wang
 * @version 2017-04-27
 */
@Service
@Transactional(readOnly = true)
public class TbCO2Service extends CrudService<TbCO2Dao, TbCO2> {

	public TbCO2 get(String id) {
		return super.get(id);
	}
	
	public List<TbCO2> findList(TbCO2 tbCO2) {
		return super.findList(tbCO2);
	}
	
	public Page<TbCO2> findPage(Page<TbCO2> page, TbCO2 tbCO2) {
		return super.findPage(page, tbCO2);
	}
	
	@Transactional(readOnly = false)
	public void save(TbCO2 tbCO2) {
		super.save(tbCO2);
	}
	
	@Transactional(readOnly = false)
	public void delete(TbCO2 tbCO2) {
		super.delete(tbCO2);
	}
	
}