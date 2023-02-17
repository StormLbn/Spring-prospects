package com.example.prospects.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.example.prospects.security.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Autowired
	private CustomUserDetailsService UserDetailsService;
	
	@Bean
	protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.csrf().disable()
		.authorizeHttpRequests((authorize) -> authorize
				.requestMatchers("/").permitAll()
				.requestMatchers("/index").permitAll()
				.requestMatchers("/clientList").authenticated()
				.requestMatchers("/addClient").authenticated())
		.formLogin(form -> form
				.loginPage("/index")
				.loginProcessingUrl("/login")
				.defaultSuccessUrl("/clientList", true)
				.failureUrl("/index?error=true")
				.permitAll())
		.logout(logout -> logout
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
				.permitAll());
	
		return http.build();
	}
	
//	@Autowired
//	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//		auth.userDetailsService(UserDetailsService).passwordEncoder(passwordEncoder());
//	}
	
//	@Bean
//	protected void filterChain(AuthenticationManagerBuilder authManagerBuilder) throws Exception {
//		authManagerBuilder.userDetailsService(customUserDetailsService).passwordEncoder(bCryptPassEncoder());
//	}

	@Bean
	public static PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
//	@Bean
//	public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
//		return authenticationConfiguration.getAuthenticationManager();
//	}
	
}
