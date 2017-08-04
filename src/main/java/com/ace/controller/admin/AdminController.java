package com.ace.controller.admin;



import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/admin")
public class AdminController extends BaseController{
	
	@RequestMapping("/")
	public String index(HttpServletRequest request,Model model){
		return INDEX;
	}
	
	@RequestMapping("/login")
	public String login(Model model){
		return LOGIN;
	}
}
