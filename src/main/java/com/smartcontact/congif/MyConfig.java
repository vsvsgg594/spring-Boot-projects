package com.smartcontact.congif;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class MyConfig{
	@Bean
	public UserDetailsService userDetailService()
	{
		return new UserDetailServiceImple();
	}
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public DaoAuthenticationProvider daoAuthenticationProvider()
	{
		DaoAuthenticationProvider daoAuthenticationProvicwr=new DaoAuthenticationProvider();
		daoAuthenticationProvicwr.setUserDetailsService(this.userDetailService());
		daoAuthenticationProvicwr.setPasswordEncoder(this.passwordEncoder());
		return daoAuthenticationProvicwr;
	}
	
	
	@Bean
	protected SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception
	{
		http.authorizeRequests().
        requestMatchers("/admin/**").
		hasRole("ADMIN").
		requestMatchers("/user/**").
		hasRole("USER").
		requestMatchers("/**").
		permitAll().and().formLogin().loginPage("/signin").and().csrf().disable();
		http.authenticationProvider(daoAuthenticationProvider());
		return http.build();
		
		
	}
	

}
