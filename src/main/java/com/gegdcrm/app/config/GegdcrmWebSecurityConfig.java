package com.gegdcrm.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class GegdcrmWebSecurityConfig extends WebSecurityConfigurerAdapter {

//
//	@Autowired
//	@Qualifier("userDetailsServiceImpl")
//	private UserDetailsService userDetailsService;

//	@Bean
//	public UserDetailsService userDetailsService() {
//	    return super.userDetailsService();
//	}
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//http.authorizeRequests().antMatchers("/resources/**", "/registration").permitAll().anyRequest().authenticated()
		//		.and().formLogin().loginPage("/login").permitAll().and().logout().permitAll().and().csrf().disable();
				//.anyRequest().hasRole("ADMIN").and().csrf().disable();
		
		http.authorizeRequests().antMatchers("/resources/**", "/registration","/customer/**","/menu/**","/bidder/**","/job/**").permitAll().anyRequest().authenticated()
		.and().formLogin().loginPage("/login").permitAll().and().csrf().disable();
	}

//	@Autowired
//	protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//		auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
//	}

}
