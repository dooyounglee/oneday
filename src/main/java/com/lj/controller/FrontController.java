package com.lj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.annotation.JacksonInject.Value;

@Controller
@RequestMapping("/*")
public class FrontController {

	// 메인화면
	@RequestMapping(value= "/")
	public String index(){
		return "index";
	}
	
	
}
