package com.person.shop.controller;

import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.person.shop.dto.CreateUserRequestDto;
import com.person.shop.exception.PasswordAndPasswordConfirmDoNotMatchException;
import com.person.shop.service.UserService;

@Controller
public class UserController {
	private static final Logger log = LoggerFactory.getLogger(UserController.class);
	
	@Autowired private UserService userService;

	@RequestMapping("/")
	public String mainView(){
		return "index";
	}
	
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginView(@RequestParam Optional<String> error, HttpSession session, Model model) {
        log.info("loginView, error={}", error);
        model.addAttribute("error", error);
        String message = (String)session.getAttribute("message");
    	if(StringUtils.isNotEmpty(message)){
    		model.addAttribute("message", message);
    		session.removeAttribute("message");
    	}
        return "view/user/login";
    }
    
    @RequestMapping(value="/join", method=RequestMethod.GET)
    public String joinView(HttpSession session, Model model){
    	log.info("joinView");
    	String message = (String)session.getAttribute("message");
    	if(StringUtils.isNotEmpty(message)){
    		model.addAttribute("message", message);
    		session.removeAttribute("message");
    	}
    	return "view/user/join";
    }
    
    @RequestMapping(value="/join", method=RequestMethod.POST)
    public String join(CreateUserRequestDto userDto, HttpSession session){
    	log.info("join");
    	if(userService.checkForDuplicateEmail(userDto.getEmail())){
    		log.debug("이미 가입된 이메일");
    		session.setAttribute("message", "이미 가입된 이메일입니다.");
    		return "redirect:/join";
    	}
    	try {
    		userService.save(userDto.getUser());
    	} catch(PasswordAndPasswordConfirmDoNotMatchException ppnme){
    		log.error(ppnme.getMessage());
    		session.setAttribute("message", "비밀번호를 확인해주세요.");
    		return "redirect:/join";
    	}
    	
    	return "redirect:/login";
    }
    
    @RequestMapping("/translatePassword")
    public String translatePassword(String email, HttpSession session){
    	log.info("translatePassword");
    	String translatePassword = userService.translatePassword(email);
    	session.setAttribute("message", translatePassword);
    	return "redirect:/login";
    }
}
