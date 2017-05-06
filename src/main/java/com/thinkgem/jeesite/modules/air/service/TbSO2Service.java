/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.air.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.air.entity.TbSO2;
import com.thinkgem.jeesite.modules.air.dao.TbSO2Dao;

/**
 * 二氧化硫Service
 * @author Frank Wang
 * @version 2017-05-06
 */
@Service
@Transactional(readOnly = true)
public class TbSO2Service extends CrudService<TbSO2Dao, TbSO2> {

	public TbSO2 get(String id) {
		return super.get(id);
	}
	
	public List<TbSO2> findList(TbSO2 tbSO2) {
		return super.findList(tbSO2);
	}
	
	public Page<TbSO2> findPage(Page<TbSO2> page, TbSO2 tbSO2) {
		return super.findPage(page, tbSO2);
	}
	
	@Transactional(readOnly = false)
	public void save(TbSO2 tbSO2) {
		super.save(tbSO2);
	}
	
	@Transactional(readOnly = false)
	public void delete(TbSO2 tbSO2) {
		super.delete(tbSO2);
	}
	
}