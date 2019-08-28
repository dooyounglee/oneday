package com.lj.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.lj.service.ClassService;
import com.lj.vo.ClassVO;
import com.lj.vo.MemberVO;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Controller
@RequestMapping("/class")
@AllArgsConstructor
public class ClassController {


	private ClassService service;
	
	
	// 클래스 등록 페이지 - 호스트만 이용가능
	@GetMapping("/addClass") 
	public void addClass() {
		
	}
	
	// 클래스 등록 처리
	@PostMapping("/addClass")
	public String addClass(ClassVO vo, RedirectAttributes rttr, HttpServletRequest req) {

		log.info("addClass ....... controller");
		
		HttpSession session = req.getSession();
		MemberVO mem = (MemberVO)session.getAttribute("mem");
		vo.setM_no(mem.getM_no());
		service.addClass(vo);
		
		rttr.addFlashAttribute("result", vo.getClass_no());
		
		return "redirect:/class/classList";
	}
	
	// 클래스 리스트 보여주기
	@RequestMapping("/classList")
	public void classList(Model model) {
		
		log.info("list.....controller");
		
		model.addAttribute("list", service.getList());
	}
	
	
	// 한 클래스 보기
	@RequestMapping("/classInfo")
	public void classInfo(Model model, @RequestParam("cno") int cno, HttpServletRequest req) {
	
		log.info("classInfo.........conteroller");
		
		model.addAttribute("c", service.get(cno));
		
		// 해당 글쓴이는 '수정'버튼 보여주려고 mno보내기
		HttpSession session = req.getSession();
		MemberVO mem = (MemberVO)session.getAttribute("mem");
		model.addAttribute("mno", mem.getM_no());
		
		
	}
	
	
}//class end
