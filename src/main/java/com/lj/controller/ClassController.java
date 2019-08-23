package com.lj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lj.service.ClassService;

import lombok.Setter;

@Controller
@RequestMapping("/class")
public class ClassController {

//	
//	@Setter(onMethod_ = @Autowired)
//	private ClassService service;
	
	
	// 클래스 등록 페이지 - 호스트만 이용가능
	@RequestMapping(value ="/addClass")
	public String addClass() {
		
		// 세션에서 호스트 값 확인
		
		return "class/addClass";
	}
}
