package com.suraj.eazybank.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ProjectSecurityConfig {

	
	@SuppressWarnings("removal")
	@Bean
	SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests().requestMatchers("/myAccount", "/myBalance", "/myLoans", "/myCards")
		.authenticated()
	    .requestMatchers("/notices", "/contact")
	    .permitAll()
	    .and()
	    .formLogin()
	    .and()
	    .httpBasic();
		return http.build();

	}
	 
	/*
	 * @Bean public SecurityFilterChain filterChain(HttpSecurity http) throws
	 * Exception { http.authorizeHttpRequests(authorize ->
	 * authorize.anyRequest().authenticated()).formLogin(withDefaults())
	 * .httpBasic(withDefaults()); return http.build(); }
	 */
}
