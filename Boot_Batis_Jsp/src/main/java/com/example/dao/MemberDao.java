package com.example.dao;

import java.util.Map;

import com.example.dto.Account;

public interface MemberDao {
	public Account findByEmail(String email) throws Exception;
}
