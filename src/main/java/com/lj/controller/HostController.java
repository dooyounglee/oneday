package com.lj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/host")
public class HostController {
	
	// 호스트페이지
	@RequestMapping(value = "/host")
	public String host() {
		return "host/hostPage";
	}
	
	
}
