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
import com.thinkgem.jeesite.modules.air.entity.TbTempHum;
import com.thinkgem.jeesite.modules.air.service.TbTempHumService;

/**
 * 温湿度Controller
 * @author Frank Wang
 * @version 2017-05-05
 */
@Controller
@RequestMapping(value = "${adminPath}/air/tbTempHum")
public class TbTempHumController extends BaseController {

	@Autowired
	private TbTempHumService tbTempHumService;
	
	@ModelAttribute
	public TbTempHum get(@RequestParam(required=false) String id) {
		TbTempHum entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = tbTempHumService.get(id);
		}
		if (entity == null){
			entity = new TbTempHum();
		}
		return entity;
	}
	
	@RequiresPermissions("air:tbTempHum:view")
	@RequestMapping(value = {"list", ""})
	public String list(TbTempHum tbTempHum, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<TbTempHum> page = tbTempHumService.findPage(new Page<TbTempHum>(request, response), tbTempHum); 
		model.addAttribute("page", page);
		return "modules/air/tbTempHumList";
	}

	@RequiresPermissions("air:tbTempHum:view")
	@RequestMapping(value = "form")
	public String form(TbTempHum tbTempHum, Model model) {
		model.addAttribute("tbTempHum", tbTempHum);
		return "modules/air/tbTempHumForm";
	}

	@RequiresPermissions("air:tbTempHum:edit")
	@RequestMapping(value = "save")
	public String save(TbTempHum tbTempHum, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, tbTempHum)){
			return form(tbTempHum, model);
		}
		tbTempHumService.save(tbTempHum);
		addMessage(redirectAttributes, "保存温湿度成功");
		return "redirect:"+Global.getAdminPath()+"/air/tbTempHum/?repage";
	}
	
	@RequiresPermissions("air:tbTempHum:edit")
	@RequestMapping(value = "delete")
	public String delete(TbTempHum tbTempHum, RedirectAttributes redirectAttributes) {
		tbTempHumService.delete(tbTempHum);
		addMessage(redirectAttributes, "删除温湿度成功");
		return "redirect:"+Global.getAdminPath()+"/air/tbTempHum/?repage";
	}

}