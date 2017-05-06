/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.air.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.modules.air.entity.TbCO2;
import com.thinkgem.jeesite.modules.air.service.TbCO2Service;

/**
 * 二氧化碳Controller
 * @author Frank Wang
 * @version 2017-05-06
 */
@Controller
@RequestMapping(value = "${adminPath}/air/tbCO2")
public class TbCO2Controller extends BaseController {

	@Autowired
	private TbCO2Service tbCO2Service;
	
	@ModelAttribute
	public TbCO2 get(@RequestParam(required=false) String id) {
		TbCO2 entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = tbCO2Service.get(id);
		}
		if (entity == null){
			entity = new TbCO2();
		}
		return entity;
	}
	
	@RequiresPermissions("air:tbCO2:view")
	@RequestMapping(value = {"list", ""})
	public String list(TbCO2 tbCO2, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<TbCO2> page = tbCO2Service.findPage(new Page<TbCO2>(request, response), tbCO2); 
		model.addAttribute("page", page);
		return "modules/air/tbCO2List";
	}

	@RequiresPermissions("air:tbCO2:view")
	@RequestMapping(value = "form")
	public String form(TbCO2 tbCO2, Model model) {
		model.addAttribute("tbCO2", tbCO2);
		return "modules/air/tbCO2Form";
	}

	@RequiresPermissions("air:tbCO2:edit")
	@RequestMapping(value = "save")
	public String save(TbCO2 tbCO2, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, tbCO2)){
			return form(tbCO2, model);
		}
		tbCO2Service.save(tbCO2);
		addMessage(redirectAttributes, "保存二氧化碳成功");
		return "redirect:"+Global.getAdminPath()+"/air/tbCO2/?repage";
	}
	
	@RequiresPermissions("air:tbCO2:edit")
	@RequestMapping(value = "delete")
	public String delete(TbCO2 tbCO2, RedirectAttributes redirectAttributes) {
		tbCO2Service.delete(tbCO2);
		addMessage(redirectAttributes, "删除二氧化碳成功");
		return "redirect:"+Global.getAdminPath()+"/air/tbCO2/?repage";
	}

}