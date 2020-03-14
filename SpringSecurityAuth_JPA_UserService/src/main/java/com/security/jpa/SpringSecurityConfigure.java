package com.security.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.security.jpa.Service.AuthenticateService;

@EnableWebSecurity
public class SpringSecurityConfigure extends WebSecurityConfigurerAdapter {
	
	@Autowired
	AuthenticateService authenticateService;
	
	@Bean
	public BCryptPasswordEncoder getEncoder()
	{
		return new BCryptPasswordEncoder();
	}
	
	protected void configure(HttpSecurity http) throws Exception {
		http.
		csrf().disable().
		authorizeRequests()
			.antMatchers("/Authentications/**").permitAll()
			.antMatchers("/admins/**").hasRole("Admin")
			.antMatchers("/users/**").hasRole("User")
			.anyRequest().authenticated()
			.and()
			.httpBasic();
	}

	//To cofigure the Authentication mechanism i.e. database, ldap, in-memory etc.
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(authenticateService)
			.passwordEncoder(getEncoder());
					
	}
	
	

}
