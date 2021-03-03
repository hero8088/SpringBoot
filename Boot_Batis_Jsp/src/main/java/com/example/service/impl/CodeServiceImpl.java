package com.example.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.CodeDao;
import com.example.service.CodeService;
@Service
public class CodeServiceImpl implements CodeService {
	@Autowired
	private CodeDao codeDao;
	@Override
	public List<Map<String, Object>> selectAllCodes() throws Exception {
		return codeDao.selectCodesAll();
	}

}
