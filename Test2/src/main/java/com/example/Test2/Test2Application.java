package com.example.Test2;

import com.example.Test2.service.MyAuthProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableJdbcRepositories("com.example.Test2.repository")
@SpringBootApplication
public class Test2Application extends WebSecurityConfigurerAdapter {

	@Autowired
	private MyAuthProvider myAuthProvider;

	public static void main(String[] args) {
		SpringApplication.run(Test2Application.class, args);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
				.cors().disable()
				.formLogin()
				.loginPage("/login").permitAll()
				.and()
				.logout().permitAll().logoutUrl("/logout")
				.and().authenticationProvider(myAuthProvider)
				.authorizeRequests().anyRequest().authenticated();
	}

	@Bean
	public PasswordEncoder passwordEncoder(){
		return  new BCryptPasswordEncoder();
	}
}
