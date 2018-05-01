package com.pos.controller;

import com.pos.dto.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@RequestMapping({"/", "/home"})
	public String adminHome(Model model) {
		model.addAttribute("adminClickHome", true);
		return "adminPanel";
	}

	@RequestMapping("/addUser")
	public String addNewUser(Model model) {
		model.addAttribute("user", new User());
		model.addAttribute("adminClickAddUser", true);
		return "adminPanel";
	}

	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public String addNewUserPost(Model model) {
		model.addAttribute("user", new User());
		model.addAttribute("adminClickAddUser", true);
		return "adminPanel";
	}


}
