/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.air.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.air.entity.TbNode;

/**
 * 节点信息DAO接口
 * @author Frank Wang
 * @version 2017-05-15
 */
@MyBatisDao
public interface TbNodeDao extends CrudDao<TbNode> {
	
}