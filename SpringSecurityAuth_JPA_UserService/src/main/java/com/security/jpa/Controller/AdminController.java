package com.security.jpa.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admins")
public class AdminController {
	
	@GetMapping("/")
	public String getadminApi() {
		return "Admin is access this api";
	}

}
