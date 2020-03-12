package com.security.basic;

import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;

@EnableWebSecurity
public class SecurityConfigration extends WebSecurityConfigurerAdapter {
	
	
	@Bean
	public BCryptPasswordEncoder getEncoder()
	{
		return new BCryptPasswordEncoder();
	}

	 
	// use basic browser form for authentication
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("http://localhost:8080/").permitAll()
		.antMatchers("/users/**").hasRole("USER")
		.antMatchers("/admin/**").hasRole("ADMIN")
		.anyRequest().authenticated().and().httpBasic();

	}

	// provide credintails in memory by code
	
	

	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("vishu").password(getEncoder().encode("12345")).roles("ADMIN")
		.and().withUser("kush").password(getEncoder().encode("12345")).roles("USER");
	}

}
