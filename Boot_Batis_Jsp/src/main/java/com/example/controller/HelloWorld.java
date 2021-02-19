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
	public @ResponseBody ModelAndView index() throws Exception {
		ModelAndView mov = new ModelAndView();
		
		mov.addObject("result", svc1.selectCodesAll());
		mov.setViewName("index");
		return mov;
	}
	
	@RequestMapping("/datatable")
	public @ResponseBody ModelAndView datatable() throws Exception {
		ModelAndView mov = new ModelAndView();
		
		mov.addObject("result", svc1.selectCodesAll());
		mov.setViewName("datatableList");
		return mov;
	}
	
	@RequestMapping("/toast")
	public @ResponseBody ModelAndView toast() throws Exception {
		ModelAndView mov = new ModelAndView();
		
		mov.addObject("result", svc1.selectCodesAll());
		mov.setViewName("toastList");
		return mov;
	}

}
