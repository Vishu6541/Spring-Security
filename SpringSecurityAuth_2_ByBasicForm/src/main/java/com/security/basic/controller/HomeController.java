package com.security.basic.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/browser")
public class HomeController {
	static Logger logger;
	static {
		logger =LoggerFactory.getLogger(HomeController.class);
	}
	
	@RequestMapping("/")
	public String Loginuser() {
		logger.trace("=====================first controller is Access===============================");
		return "index";
	}

}
