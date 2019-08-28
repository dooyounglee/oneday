package com.lj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lj.service.ClassService;

import lombok.Setter;

@Controller
@RequestMapping("/*")
public class FrontController {

	@Setter(onMethod_=@Autowired)
	private ClassService cService;
	
	// 메인화면
	@RequestMapping(value= "/")
	public String index(Model model){
		model.addAttribute("clist", cService.getList());
		return "index";
	}
	
	
}
