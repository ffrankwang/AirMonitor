package com.thinkgem.jeesite.modules.sys.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.common.collect.Lists;
import com.thinkgem.jeesite.modules.sys.entity.Office;
import com.thinkgem.jeesite.modules.sys.entity.Role;
import com.thinkgem.jeesite.modules.sys.entity.User;
import com.thinkgem.jeesite.modules.sys.service.SystemService;
import com.thinkgem.jeesite.modules.sys.utils.UserUtils;

@Controller
public class RegisterController {
	@Autowired
	private SystemService systemService;

	@RequestMapping(value = "register", method = RequestMethod.GET)
	public String register(User user, Model model) {
		// model.addAttribute("user", user);
		return "modules/sys/register";
	}

	@RequestMapping(value = "register/save", method = RequestMethod.POST)
	public String save(User user, Model model, RedirectAttributes redirectAttributes) {
		user.setOffice(new Office());
		user.setCompany(new Office());
		List<Role> roleList=Lists.newArrayList();

		//roleList.add(e);
		user.setRoleList(roleList);
		systemService.saveUser(user);
		return "modules/sys/regSuccess";
	}
}
