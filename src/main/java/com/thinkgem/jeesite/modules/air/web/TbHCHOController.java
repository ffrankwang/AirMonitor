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
import com.thinkgem.jeesite.modules.air.entity.TbHCHO;
import com.thinkgem.jeesite.modules.air.service.TbHCHOService;

/**
 * 甲醛Controller
 * @author Frank Wang
 * @version 2017-05-06
 */
@Controller
@RequestMapping(value = "${adminPath}/air/tbHCHO")
public class TbHCHOController extends BaseController {

	@Autowired
	private TbHCHOService tbHCHOService;
	
	@ModelAttribute
	public TbHCHO get(@RequestParam(required=false) String id) {
		TbHCHO entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = tbHCHOService.get(id);
		}
		if (entity == null){
			entity = new TbHCHO();
		}
		return entity;
	}
	
	@RequiresPermissions("air:tbHCHO:view")
	@RequestMapping(value = {"list", ""})
	public String list(TbHCHO tbHCHO, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<TbHCHO> page = tbHCHOService.findPage(new Page<TbHCHO>(request, response), tbHCHO); 
		model.addAttribute("page", page);
		return "modules/air/tbHCHOList";
	}
	@RequiresPermissions("air:tbHCHO:view")
	@RequestMapping(value = {"listDel"})
	public String listDel(TbHCHO tbHCHO, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<TbHCHO> page = tbHCHOService.findPage(new Page<TbHCHO>(request, response), tbHCHO); 
		model.addAttribute("page", page);
		return "modules/air/tbHCHOList2";
	}

	@RequiresPermissions("air:tbHCHO:view")
	@RequestMapping(value = "form")
	public String form(TbHCHO tbHCHO, Model model) {
		model.addAttribute("tbHCHO", tbHCHO);
		return "modules/air/tbHCHOForm";
	}

	@RequiresPermissions("air:tbHCHO:edit")
	@RequestMapping(value = "save")
	public String save(TbHCHO tbHCHO, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, tbHCHO)){
			return form(tbHCHO, model);
		}
		tbHCHOService.save(tbHCHO);
		addMessage(redirectAttributes, "保存甲醛成功");
		return "redirect:"+Global.getAdminPath()+"/air/tbHCHO/?repage";
	}
	
	@RequiresPermissions("air:tbHCHO:edit")
	@RequestMapping(value = "delete")
	public String delete(TbHCHO tbHCHO, RedirectAttributes redirectAttributes) {
		tbHCHOService.delete(tbHCHO);
		addMessage(redirectAttributes, "删除甲醛成功");
		return "redirect:"+Global.getAdminPath()+"/air/tbHCHO/?repage";
	}

}