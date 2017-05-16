/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.air.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 节点信息Entity
 * @author Frank Wang
 * @version 2017-05-15
 */
public class TbNode extends DataEntity<TbNode> {
	
	private static final long serialVersionUID = 1L;
	private String name;		// 节点名称
	private Integer power;		// 节点电量
	
	public TbNode() {
		super();
	}

	public TbNode(String id){
		super(id);
	}

	@Length(min=0, max=64, message="节点名称长度必须介于 0 和 64 之间")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Integer getPower() {
		return power;
	}

	public void setPower(Integer power) {
		this.power = power;
	}
	
}