package com.person.shop.controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {
	private static final Logger log = LoggerFactory.getLogger(UserController.class);

	@RequestMapping("/")
	public String mainView(){
		return "index";
	}
	
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginView(@RequestParam Optional<String> error, Model model) {
        log.debug("loginView, error={}", error);
        model.addAttribute("error", error);
        
        return "view/user/login";
    }
}
