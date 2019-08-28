package com.lj.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lj.service.BookingService;
import com.lj.service.ClassService;
import com.lj.service.MemberService;
import com.lj.vo.BookingVO;
import com.lj.vo.MemberVO;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/book")
@AllArgsConstructor
public class BookingController {

	private MemberService mService;
	private ClassService cService;
	private BookingService bService;
	
	//예약
	@GetMapping("/booking/{c_no}")
	public String book(@PathVariable("c_no") int class_no, HttpServletRequest req,  Model model) {
		model.addAttribute("classinfo", cService.get(class_no));
		HttpSession session = req.getSession();
		MemberVO m=(MemberVO)session.getAttribute("mem");
		BookingVO book=new BookingVO();
		book.setM_no(m.getM_no());
		book.setClass_no(class_no);
		
		//예약........여기서 안하고 결제하면 해야 하나?
		bService.bookClass(book);
		
		model.addAttribute("message", "예약이 완료 되었습니다.");
		return "/book/purchase";
	}
	
	//예약취소
	@GetMapping("/cancel/{b_no}")
	public String cancel(@PathVariable("b_no") int b_no, Model model) {
		bService.bookCancel(b_no);
		
		model.addAttribute("message", "예약이 취소되었습니다.");
		return "redirect:/member/mypage";
	}
}
