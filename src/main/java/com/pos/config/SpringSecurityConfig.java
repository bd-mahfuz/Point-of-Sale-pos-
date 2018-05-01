package com.pos.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.sql.DataSource;

@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	AccessDeniedHandler accessDeniedHandler;

	@Autowired
	BCryptPasswordEncoder passwordEncoder;

	@Autowired
	@Qualifier("dataSource")
	private DataSource dataSource;

	private String usernameQuery = "select user_name, password, enable " +
			"from user_details where user_name=?";
	private String authorizeQuery = "select user_name, role from user_details where user_name=?";
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
			.authorizeRequests()
			.antMatchers("/","/login","/css/**","/images/**","/js/**").permitAll()
			.antMatchers("/admin/**").hasAuthority("ADMIN")
			.antMatchers("/user/**").hasAuthority("USER")
			.and()
            .formLogin()
            .loginPage("/login")
            .defaultSuccessUrl("/author")
            .permitAll()
            .and()
            .logout()
            .permitAll()
            .and()
            .exceptionHandling().accessDeniedHandler(accessDeniedHandler);
	}
	
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
//		auth.inMemoryAuthentication()
//			.withUser("user").password("123").roles("USER")
//			.and()
//			.withUser("admin").password("admin").roles("ADMIN");

		auth.jdbcAuthentication()
				.usersByUsernameQuery(usernameQuery)
				.authoritiesByUsernameQuery(authorizeQuery)
				.dataSource(dataSource)
				.passwordEncoder(passwordEncoder);
	}
	
	@Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
           .antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**","/webjars/**");
    }
	
	
}
