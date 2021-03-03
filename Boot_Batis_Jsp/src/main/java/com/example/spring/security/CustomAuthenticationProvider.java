package com.example.spring.security;

import javax.annotation.Resource;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.dto.Account;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CustomAuthenticationProvider implements AuthenticationProvider {
	@Resource(name = "userDetailsService")
	private UserDetailsService userDetailsService;
	@NonNull
	private BCryptPasswordEncoder passwordEncoder;
	
	public CustomAuthenticationProvider(BCryptPasswordEncoder passwordEncoder) {
		super();
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		UsernamePasswordAuthenticationToken token = (UsernamePasswordAuthenticationToken) authentication;
		String userEmail = token.getName();
		String userPw = (String)token.getCredentials();
		
		Account account = (Account) userDetailsService.loadUserByUsername(userEmail);
		
		if(!passwordEncoder.matches(userPw, account.getPassword())) {
			throw new BadCredentialsException(account.getEmail() + " Invalid password");
		}
		
		return new UsernamePasswordAuthenticationToken(account, userPw, account.getAuthorities() );
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

}
