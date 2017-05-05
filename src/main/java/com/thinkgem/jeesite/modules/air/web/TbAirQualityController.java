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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.utils.JMap;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.modules.air.entity.TbAirQuality;
import com.thinkgem.jeesite.modules.air.service.TbAirQualityService;

/**
 * 空气质量Controller
 * @author Frank Wang
 * @version 2017-04-27
 */
@Controller
@RequestMapping(value = "${adminPath}/air/tbAirQuality")
public class TbAirQualityController extends BaseController {

	@Autowired
	private TbAirQualityService tbAirQualityService;
	
	@ModelAttribute
	public TbAirQuality get(@RequestParam(required=false) String id) {
		TbAirQuality entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = tbAirQualityService.get(id);
		}
		if (entity == null){
			entity = new TbAirQuality();
		}
		return entity;
	}
	
	@RequiresPermissions("air:tbAirQuality:view")
	@RequestMapping(value = {"list", ""})
	public String list(TbAirQuality tbAirQuality, HttpServletRequest request, HttpServletResponse response, Model model) {
		//Page<TbAirQuality> page = tbAirQualityService.findPage(new Page<TbAirQuality>(request, response), tbAirQuality); 
		//model.addAttribute("page", page);
		return "modules/air/tbAirQuality";
	}

	@RequiresPermissions("air:tbAirQuality:view")
	@RequestMapping(value = "form")
	public String form(TbAirQuality tbAirQuality, Model model) {
		model.addAttribute("tbAirQuality", tbAirQuality);
		return "modules/air/tbAirQualityForm";
	}

	@RequiresPermissions("air:tbAirQuality:edit")
	@RequestMapping(value = "save")
	public String save(TbAirQuality tbAirQuality, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, tbAirQuality)){
			return form(tbAirQuality, model);
		}
		tbAirQualityService.save(tbAirQuality);
		addMessage(redirectAttributes, "保存空气质量成功");
		return "redirect:"+Global.getAdminPath()+"/air/tbAirQuality/?repage";
	}
	
	@RequiresPermissions("air:tbAirQuality:edit")
	@RequestMapping(value = "delete")
	public String delete(TbAirQuality tbAirQuality, RedirectAttributes redirectAttributes) {
		tbAirQualityService.delete(tbAirQuality);
		addMessage(redirectAttributes, "删除空气质量成功");
		return "redirect:"+Global.getAdminPath()+"/air/tbAirQuality/?repage";
	}
	/**
	 * 返回当前空气质量的接口
	 * @return
	 */
	@RequestMapping(value="currentAQ")
	@ResponseBody
	public JMap getCurrentAQ(){
		return tbAirQualityService.getCurrentAQ().setOk();
	}
	
}