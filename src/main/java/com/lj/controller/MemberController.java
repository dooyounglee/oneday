package com.lj.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lj.service.MemberService;
import com.lj.vo.MemberVO;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/member")
@AllArgsConstructor
public class MemberController {

	private MemberService mService;
	
	@GetMapping("/login")
	public String login(Model model) {
		model.addAttribute("mlist", mService.getMemberList());
		model.addAttribute("hlist", mService.getHostList());
		model.addAttribute("list", mService.getAllList());
		return "member/login";
	}
	
	@PostMapping("/login")
	public String login(MemberVO m,HttpServletRequest req, Model model) {
		log.info("login버튼 눌렀다."+m);
		HttpSession session = req.getSession();
		MemberVO mem=mService.getMember(m.getEmail(), m.getPass());
		if(mem!=null) {
			session.setAttribute("mem", mem);
			return "index";
		}else {
			model.addAttribute("error", "아이디, 비번을 확인하세요.");
			return "member/login";
		}
	}
	
	@GetMapping("/join")
	public String join(Model model) {
		model.addAttribute("mlist", mService.getMemberList());
		model.addAttribute("hlist", mService.getHostList());
		return "member/join";
	}
	
	@PostMapping("/join")
	public String join(MemberVO m) {
		log.info(m);
		m.setHost("N");
		int result=mService.join(m);
		return "index";
	}
	
	@GetMapping("/joinH")
	public String joinH(Model model) {
		model.addAttribute("mlist", mService.getMemberList());
		model.addAttribute("hlist", mService.getHostList());
		return "member/joinH";
	}
	
	@PostMapping("/joinH")
	public String joinH(MemberVO m) {
		log.info("controller "+m);
		mService.joinH(m);
		return "index";
	}
	
	@GetMapping("/mypage")
	public String mypage() {
		return "member/mypage";
	}
	
	@GetMapping("/logout")
	public String logout(HttpServletRequest req) {
		HttpSession session = req.getSession();
		session.invalidate();
		return "index";
	}
	
	@GetMapping("/update")
	public String update() {
		return "member/mypage_update";
	}
	
	@PostMapping("/update")
	public String update(MemberVO m) {
		log.info("..........update");
		return "member/mypage";
	}
	
	@GetMapping("/leave")
	public String leave(MemberVO m, HttpServletRequest req) {
		log.info(".......controller leave "+m);
		mService.leave(m);
		//성공하면 해야 하는데
		HttpSession session = req.getSession();
		session.invalidate();
		return "index";
	}
}
