package com.security.controller;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/auth")
public class HomeController {
	
	@RequestMapping("/")
	public String home()
	{
		SecurityContext ctx =SecurityContextHolder.getContext();
		String name = ctx.getAuthentication().getName();
		Collection<Object> role = (Collection<Object>) ctx.getAuthentication().getAuthorities();
		System.out.println("============================================================================");
		System.out.println(role);
		System.out.println(name);
		return "index";
	}
	
	@RequestMapping(value="/about")
	public String about() throws Exception
	{
		
		return "about";
	}
	@RequestMapping(value="/contact")
	public String contact() throws Exception
	{
		
		return "contact";
	}
}
