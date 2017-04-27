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
import com.thinkgem.jeesite.modules.air.entity.TbPm25;
import com.thinkgem.jeesite.modules.air.service.TbPm25Service;

/**
 * PM2.5Controller
 * @author Frank Wang
 * @version 2017-04-27
 */
@Controller
@RequestMapping(value = "${adminPath}/air/tbPm25")
public class TbPm25Controller extends BaseController {

	@Autowired
	private TbPm25Service tbPm25Service;
	
	@ModelAttribute
	public TbPm25 get(@RequestParam(required=false) String id) {
		TbPm25 entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = tbPm25Service.get(id);
		}
		if (entity == null){
			entity = new TbPm25();
		}
		return entity;
	}
	
	@RequiresPermissions("air:tbPm25:view")
	@RequestMapping(value = {"list", ""})
	public String list(TbPm25 tbPm25, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<TbPm25> page = tbPm25Service.findPage(new Page<TbPm25>(request, response), tbPm25); 
		model.addAttribute("page", page);
		return "modules/air/tbPm25List";
	}

	@RequiresPermissions("air:tbPm25:view")
	@RequestMapping(value = "form")
	public String form(TbPm25 tbPm25, Model model) {
		model.addAttribute("tbPm25", tbPm25);
		return "modules/air/tbPm25Form";
	}

	@RequiresPermissions("air:tbPm25:edit")
	@RequestMapping(value = "save")
	public String save(TbPm25 tbPm25, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, tbPm25)){
			return form(tbPm25, model);
		}
		tbPm25Service.save(tbPm25);
		addMessage(redirectAttributes, "保存PM2.5成功");
		return "redirect:"+Global.getAdminPath()+"/air/tbPm25/?repage";
	}
	
	@RequiresPermissions("air:tbPm25:edit")
	@RequestMapping(value = "delete")
	public String delete(TbPm25 tbPm25, RedirectAttributes redirectAttributes) {
		tbPm25Service.delete(tbPm25);
		addMessage(redirectAttributes, "删除PM2.5成功");
		return "redirect:"+Global.getAdminPath()+"/air/tbPm25/?repage";
	}

}