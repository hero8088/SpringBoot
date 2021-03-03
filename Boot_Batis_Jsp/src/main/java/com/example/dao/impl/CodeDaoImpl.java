package com.example.dao.impl;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.dao.CodeDao;

@Repository
public class CodeDaoImpl implements CodeDao {
	 @Autowired
	 SqlSessionTemplate sTemp;
	 
	 public List<Map<String, Object>> selectCodesAll() throws Exception {
		 return sTemp.selectList("MyMap.selectCodesAll");
	 }
	 
	 /*
	 public Map<String, Object> selectTest() throws Exception {
		 Map<String, Object> retMap = new HashMap<>();
		 retMap.put("retData", mapper.selectList());
		 
		 return retMap;
	 }
	*/

}
