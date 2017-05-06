/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.air.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.air.entity.TbCO;
import com.thinkgem.jeesite.modules.air.dao.TbCODao;

/**
 * 一氧化碳Service
 * @author Frank Wang
 * @version 2017-05-06
 */
@Service
@Transactional(readOnly = true)
public class TbCOService extends CrudService<TbCODao, TbCO> {

	public TbCO get(String id) {
		return super.get(id);
	}
	
	public List<TbCO> findList(TbCO tbCO) {
		return super.findList(tbCO);
	}
	
	public Page<TbCO> findPage(Page<TbCO> page, TbCO tbCO) {
		return super.findPage(page, tbCO);
	}
	
	@Transactional(readOnly = false)
	public void save(TbCO tbCO) {
		super.save(tbCO);
	}
	
	@Transactional(readOnly = false)
	public void delete(TbCO tbCO) {
		super.delete(tbCO);
	}
	
}