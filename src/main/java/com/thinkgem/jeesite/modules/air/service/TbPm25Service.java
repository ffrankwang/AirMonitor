/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.air.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.air.entity.TbPm25;
import com.thinkgem.jeesite.modules.air.dao.TbPm25Dao;

/**
 * PM2.5Service
 * @author Frank Wang
 * @version 2017-04-27
 */
@Service
@Transactional(readOnly = true)
public class TbPm25Service extends CrudService<TbPm25Dao, TbPm25> {

	public TbPm25 get(String id) {
		return super.get(id);
	}
	
	public List<TbPm25> findList(TbPm25 tbPm25) {
		return super.findList(tbPm25);
	}
	
	public Page<TbPm25> findPage(Page<TbPm25> page, TbPm25 tbPm25) {
		return super.findPage(page, tbPm25);
	}
	
	@Transactional(readOnly = false)
	public void save(TbPm25 tbPm25) {
		super.save(tbPm25);
	}
	
	@Transactional(readOnly = false)
	public void delete(TbPm25 tbPm25) {
		super.delete(tbPm25);
	}
	
}