/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.air.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.air.entity.TbAirQuality;

/**
 * 空气质量DAO接口
 * @author Frank Wang
 * @version 2017-04-27
 */
@MyBatisDao
public interface TbAirQualityDao extends CrudDao<TbAirQuality> {
	
}