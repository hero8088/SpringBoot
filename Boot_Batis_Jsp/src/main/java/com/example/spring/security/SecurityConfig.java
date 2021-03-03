package com.example.spring.security;

import javax.servlet.Filter;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFilter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import lombok.AllArgsConstructor;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	private UserDetailsService userDetailsService;

	
	@Override
	//정적자원에 대해서는 SEcurity설정을 적용하지 않음.
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().requestMatchers(PathRequest.toStaticResources().atCommonLocations());
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests()
			//페이지 권한 설정
				.antMatchers("/").permitAll()  //root는 로그인 필요 없음
				.antMatchers("/datatable").hasRole("USER") 
				.antMatchers("/toast").hasRole("ADMIN")  //ADMIN권한 이 있어야 함
				.anyRequest().authenticated()  //나머지요청에 대해서는 로그인 필요
			.and() //로그인설정
				.formLogin()
				.successForwardUrl("/index")
				.failureForwardUrl("/index")
				.permitAll()
			.and()
				.addFilterBefore(customAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
		/*
				.loginPage("/user/login")
				.defaultSuccessUrl("user/login/result")
				.permitAll()
			.and() //로그아웃 설정
				.logout()
				.logoutRequestMatcher(new AntPathRequestMatcher("/user/logout"))
				.logoutSuccessUrl("/user/logout/result")
				.invalidateHttpSession(true)
			.and() //403 예외처리 핸들링
				.exceptionHandling().accessDeniedPage("user/denied");
		*/
	}
	
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public CustomAuthenticationFilter customAuthenticationFilter() throws Exception {
		CustomAuthenticationFilter customAuthenticationFilter = new CustomAuthenticationFilter(authenticationManager());
		customAuthenticationFilter.setFilterProcessesUrl("/user/login");
		customAuthenticationFilter.setAuthenticationSuccessHandler(customLoginSuccessHandler());
		customAuthenticationFilter.afterPropertiesSet();
		return customAuthenticationFilter;
	}
	
	@Bean
	public CustomLoginSuccessHandler customLoginSuccessHandler() {
		return new CustomLoginSuccessHandler();
	}
	
	@Bean
	public CustomAuthenticationProvider customAuthenticationProvider() {
		return new CustomAuthenticationProvider(bCryptPasswordEncoder());
	}

	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		 // DB없이 초기 테스트 용 데이터
		/*
		String password = passwordEncoder().encode("1111");
		auth.inMemoryAuthentication().withUser("user").password(password).roles("USER");
		auth.inMemoryAuthentication().withUser("admin").password(password).roles("ADMIN");
		*/
		auth.authenticationProvider(customAuthenticationProvider());
	}
}
