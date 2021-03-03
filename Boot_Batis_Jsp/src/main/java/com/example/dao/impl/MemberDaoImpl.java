package com.example.dao.impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.dao.MemberDao;
import com.example.dto.Account;

@Repository
public class MemberDaoImpl implements MemberDao {
	 @Autowired
	 SqlSessionTemplate sTemp;
	@Override
	public Account findByEmail(String email)  throws Exception {
		return sTemp.selectOne("Members.findByEmail", email);
	}

}
