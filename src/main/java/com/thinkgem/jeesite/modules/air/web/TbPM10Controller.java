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
import com.thinkgem.jeesite.modules.air.entity.TbPM10;
import com.thinkgem.jeesite.modules.air.service.TbPM10Service;

/**
 * PM10Controller
 * @author Frank Wang
 * @version 2017-05-05
 */
@Controller
@RequestMapping(value = "${adminPath}/air/tbPM10")
public class TbPM10Controller extends BaseController {

	@Autowired
	private TbPM10Service tbPM10Service;
	
	@ModelAttribute
	public TbPM10 get(@RequestParam(required=false) String id) {
		TbPM10 entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = tbPM10Service.get(id);
		}
		if (entity == null){
			entity = new TbPM10();
		}
		return entity;
	}
	
	@RequiresPermissions("air:tbPM10:view")
	@RequestMapping(value = {"list", ""})
	public String list(TbPM10 tbPM10, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<TbPM10> page = tbPM10Service.findPage(new Page<TbPM10>(request, response), tbPM10); 
		model.addAttribute("page", page);
		return "modules/air/tbPM10List";
	}

	@RequiresPermissions("air:tbPM10:view")
	@RequestMapping(value = "form")
	public String form(TbPM10 tbPM10, Model model) {
		model.addAttribute("tbPM10", tbPM10);
		return "modules/air/tbPM10Form";
	}

	@RequiresPermissions("air:tbPM10:edit")
	@RequestMapping(value = "save")
	public String save(TbPM10 tbPM10, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, tbPM10)){
			return form(tbPM10, model);
		}
		tbPM10Service.save(tbPM10);
		addMessage(redirectAttributes, "保存PM10成功");
		return "redirect:"+Global.getAdminPath()+"/air/tbPM10/?repage";
	}
	
	@RequiresPermissions("air:tbPM10:edit")
	@RequestMapping(value = "delete")
	public String delete(TbPM10 tbPM10, RedirectAttributes redirectAttributes) {
		tbPM10Service.delete(tbPM10);
		addMessage(redirectAttributes, "删除PM10成功");
		return "redirect:"+Global.getAdminPath()+"/air/tbPM10/?repage";
	}

}