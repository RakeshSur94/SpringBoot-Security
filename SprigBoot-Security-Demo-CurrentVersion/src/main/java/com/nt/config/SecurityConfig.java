package com.nt.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableMethodSecurity
public class SecurityConfig {
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public UserDetailsService userDetailsService() {
	
		/*
		UserDetails normalUser= User.withUsername("rakesh")
				                                   .password(passwordEncoder().encode("1234"))
				                                   .roles("MECH")
				                                   .build();
		UserDetails adminUser=User.withUsername("rakehs1")
				                                 .password(passwordEncoder().encode("password"))
				                                 .roles("OPT")
				                                 .build();
				                               
		return  new InMemoryUserDetailsManager(normalUser,adminUser);
		  */
		
		//use data base
		return new CustomUserDeatilsService();
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity security) throws Exception {
		security.csrf().disable()
		             .authorizeHttpRequests()
				/*
				  .requestMatchers("/emp-api/mech") .hasRole("MECH")
				  .requestMatchers("/emp-api/opt") .hasRole("OPT")
				  .requestMatchers("/emp-api/mech")
				 .permitAll()
		            */ 
		             .anyRequest()
		             .authenticated()
		             .and()
		             .formLogin();
		
		return security.build();
	
	}

}
