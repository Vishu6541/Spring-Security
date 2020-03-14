package com.security.jpa.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.security.jpa.Dao.AuthenticationRepo;
import com.security.jpa.Entity.AuthenticationModel;

@Component
public class AuthenticateService implements UserDetailsService {

	@Autowired
	AuthenticationRepo authenticationRepo;

	@Autowired
	BCryptPasswordEncoder BCryptPasswordEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Optional<AuthenticationModel> opt = authenticationRepo.findByEmail(username);
		if (opt.isPresent()) {
			AuthenticationModel authenticationModel = opt.get();
			System.out.println("User is try to login =>" + authenticationModel.getName());
			UserDetails userDetails = org.springframework.security.core.userdetails.User.builder()
					.username(authenticationModel.getName()).password(BCryptPasswordEncoder.encode(authenticationModel.getPassword()))
					.roles(authenticationModel.getRole()).build();

			return userDetails;
		} else {
			throw (new UsernameNotFoundException("No user found for username " + username));
		}

	}

}
