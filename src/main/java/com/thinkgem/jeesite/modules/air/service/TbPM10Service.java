/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.air.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.air.entity.TbPM10;
import com.thinkgem.jeesite.modules.air.dao.TbPM10Dao;

/**
 * PM10Service
 * @author Frank Wang
 * @version 2017-05-05
 */
@Service
@Transactional(readOnly = true)
public class TbPM10Service extends CrudService<TbPM10Dao, TbPM10> {

	public TbPM10 get(String id) {
		return super.get(id);
	}
	
	public List<TbPM10> findList(TbPM10 tbPM10) {
		return super.findList(tbPM10);
	}
	
	public Page<TbPM10> findPage(Page<TbPM10> page, TbPM10 tbPM10) {
		return super.findPage(page, tbPM10);
	}
	
	@Transactional(readOnly = false)
	public void save(TbPM10 tbPM10) {
		super.save(tbPM10);
	}
	
	@Transactional(readOnly = false)
	public void delete(TbPM10 tbPM10) {
		super.delete(tbPM10);
	}
	
}