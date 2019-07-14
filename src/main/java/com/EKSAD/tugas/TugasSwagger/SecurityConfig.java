package com.EKSAD.tugas.TugasSwagger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.EKSAD.tugas.TugasSwagger.service.UserService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfiguration {

	@Autowired
	private UserService userService;
	
	@Override
 	protected void configure(HttpSecurity http) throws Exception {
 		http.httpBasic()	
 			.and().csrf().disable()	
 			.authorizeRequests()	
 				.antMatchers("/admin/**").hasAuthority("ADMIN")
 				.antMatchers("/user/**").hasAnyAuthority("ADMIN", "USER")
 				.and().formLogin().permitAll();
	}

 	@Override
 	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
/* 	
 		String admin = "admin";	
 		String adminPassword = encoder().encode("123123");	
 		
 		String user = "bolobolo";
 		String userPassword = encoder().encode("mama");	
 		
 		auth.inMemoryAuthentication()
 			.withUser(admin).password(adminPassword).roles("ADMIN", "USER");
 		
 		auth.inMemoryAuthentication()
			.withUser(user).password(userPassword).roles( "USER");
			
 		
 		auth.userDetailsService(userService).passwordEncoder(encoder());
*/
 	}

 	@Bean
 	public BCryptPasswordEncoder encoder() {
 		
 		return new BCryptPasswordEncoder();
 	}
}
