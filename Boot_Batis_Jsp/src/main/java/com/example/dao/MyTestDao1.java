package com.example.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.example.common.SqlTemplet;

@Repository
public class MyTestDao1 {
	 @Autowired
	 SqlSessionTemplate sTemp;
	 
	 public String firstSql() throws Exception {
		 return sTemp.selectOne("MyMap.select01");
	 }
	 
	 /*
	 public Map<String, Object> selectTest() throws Exception {
		 Map<String, Object> retMap = new HashMap<>();
		 retMap.put("retData", mapper.selectList());
		 
		 return retMap;
	 }
	*/

}