/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.air.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.air.entity.TbNode;
import com.thinkgem.jeesite.modules.air.dao.TbNodeDao;

/**
 * 节点信息Service
 * @author Frank Wang
 * @version 2017-05-15
 */
@Service
@Transactional(readOnly = true)
public class TbNodeService extends CrudService<TbNodeDao, TbNode> {

	public TbNode get(String id) {
		return super.get(id);
	}
	
	public List<TbNode> findList(TbNode tbNode) {
		return super.findList(tbNode);
	}
	
	public Page<TbNode> findPage(Page<TbNode> page, TbNode tbNode) {
		return super.findPage(page, tbNode);
	}
	
	@Transactional(readOnly = false)
	public void save(TbNode tbNode) {
		super.save(tbNode);
	}
	
	@Transactional(readOnly = false)
	public void delete(TbNode tbNode) {
		super.delete(tbNode);
	}
	
}