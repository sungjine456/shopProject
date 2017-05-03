package com.person.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
	@RequestMapping("")
	public String mainView(){
		return "index";
	}
	
	@RequestMapping("/login")
	public String loginView(){
		return "view/user/login";
	}
}
