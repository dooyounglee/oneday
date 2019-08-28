package com.lj.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.lj.service.ClassService;
import com.lj.vo.ClassVO;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Controller
@RequestMapping("/host")
@AllArgsConstructor
public class HostController {
	
	private ClassService service;
	
	// 호스트페이지
	@RequestMapping(value = "/host")
	public String host() {
		return "host/hostPage";
	}
	
	@RequestMapping(value ="/myClass")
	public String myClass(@RequestParam("mno") int mno, Model model) {
		// 내가 등록한 클래스페에지에 url로 클래스번호 보냈는데
		// 이것보다 그냥 뒷단에서 세션만들어서 뒤에서 처리하는게 나을지...고민
		
		log.info("myClassList... Controller");
		service.getMyList(mno);
		
		model.addAttribute("mno", mno);
		model.addAttribute("list", service.getMyList(mno));
		return "host/myClassList";
	}
	
	// 수정페이지 보여주기
	@GetMapping(value = "/updateClass")
	public void updateClass(@RequestParam("cno") int cno, Model model) {
		
		model.addAttribute("c", service.get(cno));
		log.info("updateClass ....... controller");
	}
	
	// 수정페이지 처리
	@PostMapping(value = "/updateClass")
	public String updateClass(ClassVO vo, RedirectAttributes rttr) {
		
		log.info("updateClassPro ....... controller");
		
		service.updateClass(vo);
		
		// host/myClass 로 보내면 현재 m_no가 없다고 에러나서 메인으로 돌림
		return "redirect:/class/classInfo?cno="+vo.getClass_no();
	}
	
	 
}
