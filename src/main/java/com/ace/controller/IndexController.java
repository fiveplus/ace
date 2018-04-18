package com.ace.controller;


import com.ace.util.RequestType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;


@Controller
@RequestMapping("/")
public class IndexController {
	
	@RequestMapping("/")
	public String index(Model model){
		return "index";
	}

	@RequestMapping("/test.json")
	public @ResponseBody Map<String,Object> test(RequestType type, Model model){
		Map<String,Object> returnMap = new HashMap<String,Object>();
		System.out.println("type: " + type);
		System.out.println("is GET?: " + type.equals(RequestType.GET));
		returnMap.put("type",type);
		return returnMap;
	}
	
}
