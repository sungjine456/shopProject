package com.person.shop.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.person.shop.domain.User;
import com.person.shop.dto.CreateUserRequestDto;
import com.person.shop.exception.PasswordAndPasswordConfirmDoNotMatchException;
import com.person.shop.pojo.CheckMessage;
import com.person.shop.service.UserService;

@Controller
public class LoginController {
	private static final Logger log = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired private UserService userService;
	
	@GetMapping("/login")
    public String loginView(@RequestParam Optional<String> error, Model model) {
        log.info("loginView, error={}", error);
        
        model.addAttribute("error", error);
        return "view/user/login";
    }
    
    @GetMapping("/join")
    public String joinView(){
    	log.info("joinView");

    	return "view/user/join";
    }
    
    @PostMapping("/join")
    public String join(CreateUserRequestDto userDto, RedirectAttributes ra){
    	log.info("join, createUserRequestDto : {}", userDto);
    	User user = null;
    	try {
    		user = userDto.getUser();
    	} catch(PasswordAndPasswordConfirmDoNotMatchException ppnme){
    		log.error(ppnme.getMessage());
    		ra.addFlashAttribute("message", "비밀번호를 확인해주세요.");
    		return "redirect:/join";
    	}
    	
    	CheckMessage emailCheck = userService.checkForDuplicateEmail(user.getEmail());
    	if(!emailCheck.isCheck()){
    		log.debug("이미 가입된 이메일");
    		ra.addFlashAttribute("message", emailCheck.getMessage());
    		return "redirect:/join";
    	}
    	
    	if(userService.save(user)){
    		return "redirect:/login";
    	}
    	ra.addFlashAttribute("message", "가입에 실패하였습니다.");
    	return "redirect:/join";
    }
    
    @PostMapping("/login/translatePassword")
    public String translatePassword(String email, RedirectAttributes ra){
    	log.info("translatePassword, email : {}", email);
    	String translatePassword = userService.translatePassword(email);
    	ra.addFlashAttribute("message", translatePassword);
    	return "redirect:/login";
    }
    
    @PostMapping("/join/emailCheck")
    @ResponseBody
    public Map<String, String> emailCheck(String email){
    	log.info("emailCheck, email : {}", email);
    	Map<String, String> map = new HashMap<>();
    	CheckMessage emailCheck = userService.checkForDuplicateEmail(email);
		map.put("message", emailCheck.getMessage());
		map.put("bool", String.valueOf(emailCheck.isCheck()));
    	return map;
    }
}
