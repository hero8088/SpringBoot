package com.example.dao;

import java.util.List;
import java.util.Map;

public interface CodeDao {
	public List<Map<String, Object>> selectCodesAll() throws Exception; 
}
