package com.masai.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class MySecurityConfiguration {
	
	@Bean
	public SecurityFilterChain securityConfig(HttpSecurity http) throws Exception{
		
		http.authorizeHttpRequests(
				(auth) -> auth.antMatchers("/students").hasAuthority("student")
				.antMatchers("/courses").permitAll()
		).httpBasic();
		
		return http.build();
	}
	
	@Bean
	public PasswordEncoder encodePassword() {
		//return NoOpPasswordEncoder.getInstance(); //Not recommended
		return new BCryptPasswordEncoder();
	}
}
