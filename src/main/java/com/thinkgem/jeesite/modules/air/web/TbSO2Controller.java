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
import com.thinkgem.jeesite.modules.air.entity.TbSO2;
import com.thinkgem.jeesite.modules.air.service.TbSO2Service;

/**
 * 二氧化硫Controller
 * @author Frank Wang
 * @version 2017-05-05
 */
@Controller
@RequestMapping(value = "${adminPath}/air/tbSO2")
public class TbSO2Controller extends BaseController {

	@Autowired
	private TbSO2Service tbSO2Service;
	
	@ModelAttribute
	public TbSO2 get(@RequestParam(required=false) String id) {
		TbSO2 entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = tbSO2Service.get(id);
		}
		if (entity == null){
			entity = new TbSO2();
		}
		return entity;
	}
	
	@RequiresPermissions("air:tbSO2:view")
	@RequestMapping(value = {"list", ""})
	public String list(TbSO2 tbSO2, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<TbSO2> page = tbSO2Service.findPage(new Page<TbSO2>(request, response), tbSO2); 
		model.addAttribute("page", page);
		return "modules/air/tbSO2List";
	}

	@RequiresPermissions("air:tbSO2:view")
	@RequestMapping(value = "form")
	public String form(TbSO2 tbSO2, Model model) {
		model.addAttribute("tbSO2", tbSO2);
		return "modules/air/tbSO2Form";
	}

	@RequiresPermissions("air:tbSO2:edit")
	@RequestMapping(value = "save")
	public String save(TbSO2 tbSO2, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, tbSO2)){
			return form(tbSO2, model);
		}
		tbSO2Service.save(tbSO2);
		addMessage(redirectAttributes, "保存二氧化硫成功");
		return "redirect:"+Global.getAdminPath()+"/air/tbSO2/?repage";
	}
	
	@RequiresPermissions("air:tbSO2:edit")
	@RequestMapping(value = "delete")
	public String delete(TbSO2 tbSO2, RedirectAttributes redirectAttributes) {
		tbSO2Service.delete(tbSO2);
		addMessage(redirectAttributes, "删除二氧化硫成功");
		return "redirect:"+Global.getAdminPath()+"/air/tbSO2/?repage";
	}

}