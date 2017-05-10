package com.thinkgem.jeesite.modules.sys.web;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.common.collect.Lists;
import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.modules.sys.entity.Office;
import com.thinkgem.jeesite.modules.sys.entity.Role;
import com.thinkgem.jeesite.modules.sys.entity.User;
import com.thinkgem.jeesite.modules.sys.service.SystemService;
import com.thinkgem.jeesite.modules.sys.utils.UserUtils;

@Controller
public class RegisterController extends BaseController{
	@Autowired
	private SystemService systemService;

	@RequestMapping(value = "register", method = RequestMethod.GET)
	public String register(User user, Model model) {
		// model.addAttribute("user", user);
		return "modules/sys/register2";
	}

	@RequestMapping(value = "register/save", method = RequestMethod.POST)
	public String save(User user,HttpServletRequest request, Model model, RedirectAttributes redirectAttributes) {
		User isExistedUser = systemService.getUserByLoginName(user.getLoginName());
		if(null!=isExistedUser){
			addMessage(redirectAttributes, "该用户名已存在，注册失败");
			return "redirect:/register";
		}
		User creater=UserUtils.getByLoginName("thinkgem");
		//设置密码
		user.setPassword(SystemService.entryptPassword(user.getNewPassword()));
		Office office = creater.getOffice();
		user.setOffice(office);
		user.setCompany(office);
		List<Role> roleList=Lists.newArrayList();
		roleList.add(systemService.getRoleByName("普通用户"));
		user.setRoleList(roleList);	

		//roleList.add(e);
		user.setRoleList(roleList);
		
		//相关信息
		user.setCreateBy(creater);
		user.setCreateDate(new Date());
		user.setUpdateBy(creater);
		user.setUpdateDate(new Date());
		user.setDelFlag("0");
		systemService.saveUser(user);
		return "modules/sys/regSuccess";
	}
}
