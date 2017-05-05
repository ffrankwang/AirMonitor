/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.air.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.air.entity.TbHCHO;
import com.thinkgem.jeesite.modules.air.dao.TbHCHODao;

/**
 * 甲醛Service
 * @author Frank Wang
 * @version 2017-05-05
 */
@Service
@Transactional(readOnly = true)
public class TbHCHOService extends CrudService<TbHCHODao, TbHCHO> {

	public TbHCHO get(String id) {
		return super.get(id);
	}
	
	public List<TbHCHO> findList(TbHCHO tbHCHO) {
		return super.findList(tbHCHO);
	}
	
	public Page<TbHCHO> findPage(Page<TbHCHO> page, TbHCHO tbHCHO) {
		return super.findPage(page, tbHCHO);
	}
	
	@Transactional(readOnly = false)
	public void save(TbHCHO tbHCHO) {
		super.save(tbHCHO);
	}
	
	@Transactional(readOnly = false)
	public void delete(TbHCHO tbHCHO) {
		super.delete(tbHCHO);
	}
	
}