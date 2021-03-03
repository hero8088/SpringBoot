package com.example.spring.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.dao.MemberDao;
import com.example.dto.Account;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service("userDetailsService")
public class CustomUserDetailsService implements UserDetailsService {
	@Autowired
	private MemberDao memberDao;
	/*
	public Long joinUser(Account account) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		account.setPassword(passwordEncoder.encode(account.getPassword()));
		return 1L;
	}
	*/
	@Override
	public Account loadUserByUsername(String email) throws UsernameNotFoundException {
		Account account = new Account();
		
		try {
			account = memberDao.findByEmail(email);
			if (account == null) {
				throw new UsernameNotFoundException("UsernameNotFoundException");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return account;
	}

}
