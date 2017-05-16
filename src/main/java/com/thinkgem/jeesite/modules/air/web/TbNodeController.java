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
import com.thinkgem.jeesite.modules.air.entity.TbNode;
import com.thinkgem.jeesite.modules.air.service.TbNodeService;

/**
 * 节点信息Controller
 * @author Frank Wang
 * @version 2017-05-15
 */
@Controller
@RequestMapping(value = "${adminPath}/air/tbNode")
public class TbNodeController extends BaseController {

	@Autowired
	private TbNodeService tbNodeService;
	
	@ModelAttribute
	public TbNode get(@RequestParam(required=false) String id) {
		TbNode entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = tbNodeService.get(id);
		}
		if (entity == null){
			entity = new TbNode();
		}
		return entity;
	}
	
	@RequiresPermissions("air:tbNode:view")
	@RequestMapping(value = {"list", ""})
	public String list(TbNode tbNode, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<TbNode> page = tbNodeService.findPage(new Page<TbNode>(request, response), tbNode); 
		model.addAttribute("page", page);
		return "modules/air/tbNodeList";
	}

	@RequiresPermissions("air:tbNode:view")
	@RequestMapping(value = "form")
	public String form(TbNode tbNode, Model model) {
		model.addAttribute("tbNode", tbNode);
		return "modules/air/tbNodeForm";
	}

	@RequiresPermissions("air:tbNode:edit")
	@RequestMapping(value = "save")
	public String save(TbNode tbNode, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, tbNode)){
			return form(tbNode, model);
		}
		tbNodeService.save(tbNode);
		addMessage(redirectAttributes, "保存节点信息成功");
		return "redirect:"+Global.getAdminPath()+"/air/tbNode/?repage";
	}
	
	@RequiresPermissions("air:tbNode:edit")
	@RequestMapping(value = "delete")
	public String delete(TbNode tbNode, RedirectAttributes redirectAttributes) {
		tbNodeService.delete(tbNode);
		addMessage(redirectAttributes, "删除节点信息成功");
		return "redirect:"+Global.getAdminPath()+"/air/tbNode/?repage";
	}

}