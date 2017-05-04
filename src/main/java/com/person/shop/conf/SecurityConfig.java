package com.person.shop.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
    private UserDetailsService userDetailsService;
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
				.antMatchers("/admin/**").hasRole("ADMIN")
				.antMatchers("/**").permitAll()
				.anyRequest().authenticated()
				.and()
			.formLogin()
				.loginPage("/login")
				.failureUrl("/login?error")
				.usernameParameter("email")
				.defaultSuccessUrl("/admin")
				.permitAll()
				.and()
			.csrf().disable()
			.headers().frameOptions().disable();
	}

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/static/**");
    }
    
    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
        	.userDetailsService(userDetailsService)
        	.passwordEncoder(new BCryptPasswordEncoder());
    }
}
