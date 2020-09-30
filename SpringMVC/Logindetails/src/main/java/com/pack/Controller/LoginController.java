package com.pack.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.pack.model.Login;

@Controller
public class LoginController {
	
	@RequestMapping(value="/first", method=RequestMethod.GET)
	public String show() {
		return "static-page";
	}
	
	@RequestMapping(value="/log")
	public String login(ModelMap m) {
		
		Login l=new Login();
		m.addAttribute("login",l);
		return "logindetails";
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String savedata(@Validated @ModelAttribute("login") Login l1,BindingResult br, ModelMap m1){
		
		String res;
		if(br.hasErrors()) {
			res="Login";
		}
		else {
			
		m1.addAttribute("log", l1);
		res= "result";
	}
	return res;
	}
	
}
