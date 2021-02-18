package com.example.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.dao.MyTestDao1;

@RestController
	public class HelloWorld {
	@Autowired
	MyTestDao1 svc1;

	@RequestMapping("/")
	public @ResponseBody ModelAndView root_test() throws Exception {
		ModelAndView mov = new ModelAndView();
		
		mov.addObject("result", svc1.firstSql());
		mov.setViewName("index");
		return mov;
	}
	
	@RequestMapping("/demo")
	public String demo_test() throws Exception {
		return svc1.firstSql();
	}
}
