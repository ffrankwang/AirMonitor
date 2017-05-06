/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.air.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.air.entity.TbTempHum;
import com.thinkgem.jeesite.modules.air.dao.TbTempHumDao;

/**
 * 温湿度Service
 * @author Frank Wang
 * @version 2017-05-06
 */
@Service
@Transactional(readOnly = true)
public class TbTempHumService extends CrudService<TbTempHumDao, TbTempHum> {

	public TbTempHum get(String id) {
		return super.get(id);
	}
	
	public List<TbTempHum> findList(TbTempHum tbTempHum) {
		return super.findList(tbTempHum);
	}
	
	public Page<TbTempHum> findPage(Page<TbTempHum> page, TbTempHum tbTempHum) {
		return super.findPage(page, tbTempHum);
	}
	
	@Transactional(readOnly = false)
	public void save(TbTempHum tbTempHum) {
		super.save(tbTempHum);
	}
	
	@Transactional(readOnly = false)
	public void delete(TbTempHum tbTempHum) {
		super.delete(tbTempHum);
	}
	
}