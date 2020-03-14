package com.security.jpa.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.security.jpa.Dao.AuthenticationRepo;
import com.security.jpa.Entity.AuthenticationModel;

@RestController
@RequestMapping("/Authentications")
public class AuthenticationController {
	
	
	@Autowired
	AuthenticationRepo authenticationRepo;
	
	
	@PostMapping("/")
	public String saveUser(@RequestBody AuthenticationModel auth) {
		try {
			authenticationRepo.save(auth);
			return "Saved";
		}catch (Exception e) {
			e.printStackTrace();
			return "not saved";
		}
		
	}
	
	@GetMapping("/")
	public Iterable<AuthenticationModel> getAllUser(){
		return authenticationRepo.findAll();
	}
	
	@GetMapping("/{email}")
	public AuthenticationModel getbyEmail(@PathVariable String email) {
		
		Optional<AuthenticationModel> opt =authenticationRepo.findByEmail(email);
		
		if(opt.isPresent()) {
			return opt.get();
		}else {
			return null;
		}
	}

}
