package com.pos.controller;

import com.pos.dto.User;
import com.pos.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private UserService  userService;

	@RequestMapping({"/", "/home"})
	public String adminHome(Model model) {
		model.addAttribute("adminClickHome", true);
		model.addAttribute("title", "Admin Home");
		return "adminPanel";
	}

	@RequestMapping("/addUser")
	public String addNewUser(Model model) {
		model.addAttribute("user", new User());
		model.addAttribute("adminClickAddUser", true);
		model.addAttribute("title", "Add User");
		return "adminPanel";
	}

	@RequestMapping(value = "/addAddress", method = RequestMethod.POST)
	public String addAddressPost(Model model, @ModelAttribute("user") User user) {
		model.addAttribute("adminClickAddAddress", true);
		model.addAttribute("user", user);
		model.addAttribute("title", "Add User");
		return "adminPanel";
	}


	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public String addUserPost(@ModelAttribute("user") User user) {
		System.out.println(user.getId());
		boolean isAdded = userService.addUser(user);
		String message = "";
		if (isAdded) {
			message = "New user added successfully";
		}else {
			message = "User added failed";
		}

		return "redirect:/admin/addUser?message="+message;

	}


}
