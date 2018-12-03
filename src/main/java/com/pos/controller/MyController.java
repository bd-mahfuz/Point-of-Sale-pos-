package com.pos.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {

	@RequestMapping(value={"/", "/login"})
	public String login(Model model) {
		model.addAttribute("userClickAbout", true);
		return "login";
	}
	
	
	@RequestMapping(value="/author")
	public String checkAuthor(Model model) {
		ModelAndView mv ;
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String role = auth.getAuthorities().toString();
		//mv.addObject(attributeName, attributeValue)
		System.out.println("Role ="+role);
		if(auth.isAuthenticated()) {
			if(role.equals("[ADMIN]")) {
				model.addAttribute("role", role);
				return "redirect:admin/";
			} 
			else if(role.equals("[USER]")) {
//				mv= new ModelAndView("index");
//				mv.addObject("role", role);
//				return mv;
				return "redirect:user/home";
			}
//			else {
//				
//				mv= new ModelAndView("welcome");
//				mv.addObject("role", role+" from welcome page");
//				return mv;
//			}
			
		}
		
//		return new ModelAndView("login");
		return "redirect: /login";
	}
	
	@GetMapping("/403")
    public String error403() {
        return "/error/403";
    }
	
	
	
}
