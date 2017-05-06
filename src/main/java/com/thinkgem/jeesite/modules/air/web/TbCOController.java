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
import com.thinkgem.jeesite.modules.air.entity.TbCO;
import com.thinkgem.jeesite.modules.air.service.TbCOService;

/**
 * 一氧化碳Controller
 * @author Frank Wang
 * @version 2017-05-06
 */
@Controller
@RequestMapping(value = "${adminPath}/air/tbCO")
public class TbCOController extends BaseController {

	@Autowired
	private TbCOService tbCOService;
	
	@ModelAttribute
	public TbCO get(@RequestParam(required=false) String id) {
		TbCO entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = tbCOService.get(id);
		}
		if (entity == null){
			entity = new TbCO();
		}
		return entity;
	}
	
	@RequiresPermissions("air:tbCO:view")
	@RequestMapping(value = {"list", ""})
	public String list(TbCO tbCO, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<TbCO> page = tbCOService.findPage(new Page<TbCO>(request, response), tbCO); 
		model.addAttribute("page", page);
		return "modules/air/tbCOList";
	}

	@RequiresPermissions("air:tbCO:view")
	@RequestMapping(value = "form")
	public String form(TbCO tbCO, Model model) {
		model.addAttribute("tbCO", tbCO);
		return "modules/air/tbCOForm";
	}

	@RequiresPermissions("air:tbCO:edit")
	@RequestMapping(value = "save")
	public String save(TbCO tbCO, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, tbCO)){
			return form(tbCO, model);
		}
		tbCOService.save(tbCO);
		addMessage(redirectAttributes, "保存一氧化碳成功");
		return "redirect:"+Global.getAdminPath()+"/air/tbCO/?repage";
	}
	
	@RequiresPermissions("air:tbCO:edit")
	@RequestMapping(value = "delete")
	public String delete(TbCO tbCO, RedirectAttributes redirectAttributes) {
		tbCOService.delete(tbCO);
		addMessage(redirectAttributes, "删除一氧化碳成功");
		return "redirect:"+Global.getAdminPath()+"/air/tbCO/?repage";
	}

}