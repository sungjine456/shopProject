package com.person.shop.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.person.shop.domain.DetailUser;
import com.person.shop.domain.User;
import com.person.shop.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	private static final Logger log = LoggerFactory.getLogger(UserController.class);
	
	@Autowired private UserService userService;

	@GetMapping("")
	public String mainView(Model model, HttpSession session){
		log.info("mainView");
		User user = getUserInSecuritySession();
		
		model.addAttribute("user", user);
		return "index";
	}
	
	private User getUserInSecuritySession(){
		SecurityContext securityContext = SecurityContextHolder.getContext();
	    Authentication authentication = securityContext.getAuthentication();
	    if (authentication != null) {
	        return authentication.getPrincipal() instanceof DetailUser
	        		? ((DetailUser)authentication.getPrincipal()).getUser()
	        		: null;
	    }
	    return null;
	}
}
