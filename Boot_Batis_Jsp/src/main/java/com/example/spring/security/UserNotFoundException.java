package com.example.spring.security;

public class UserNotFoundException extends RuntimeException {
	
	public UserNotFoundException(String userEmail) {
		super(userEmail + "NotFoundException");
	}
}
