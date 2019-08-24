package com.lj.controller;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lj.service.MemberService;
import com.lj.vo.JoinAuth;
import com.lj.vo.MemberVO;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/member")
@AllArgsConstructor
public class MemberController {

	private MemberService mService;
	private JavaMailSenderImpl mailSender;
	
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
		int isAuth=mService.isAuth(m);//joinauth테이블에 있는지?
		if(mem!=null && isAuth==0) {
			session.setAttribute("mem", mem);
			return "index";
		}else if(isAuth>0){
			model.addAttribute("error", "서비스를 이용하시려면 메일 인증을 해주세요.");
			return "member/login";
		}else {
			model.addAttribute("error", "아이디, 비번을 확인하세요.");
			return "member/login";
		}
	}
	
	@GetMapping("/join")
	public String join(Model model) {
//		MessageDigest md=MessageDigest.getInstance("SHA-512");
//		byte[] bytes="a".getBytes(Charset.forName("UTF-8"));
//		md.update(bytes);
//		System.out.println(Base64.getEncoder().encodeToString(md.digest()));
		
		model.addAttribute("mlist", mService.getMemberList());
		model.addAttribute("hlist", mService.getHostList());
		return "member/join";
	}
	
	@PostMapping("/join")
	public String join(MemberVO m) {
		m.setHost("N");
//		MessageDigest md=MessageDigest.getInstance("SHA-512");
//		byte[] bytes="a".getBytes(Charset.forName("UTF-8"));
//		md.update(bytes);
//		System.out.println(Base64.getEncoder().encodeToString(md.digest()));
		
		String randomCode=randomCode();
		//인증메일보내기
/*		MimeMessage msg = mailSender.createMimeMessage();
        try {
			msg.setSubject("테스트메일");
			msg.setText("http://localhost:8080/member/auth?email=gostbaduckin@naver.com&code="+randomCode);
			msg.setFrom(new InternetAddress(mailSender.getUsername()));
		    msg.setRecipient(RecipientType.TO , new InternetAddress("gostbaduckin@naver.com"));
        } catch (MessagingException e) {
			e.printStackTrace();
		}
        mailSender.send(msg);*/
		System.out.println("http://localhost:8080/member/auth?email="+m.getEmail()+"&code="+randomCode);
        
		int result=mService.join(m);
		if(result>0) {
			JoinAuth joinauth=new JoinAuth();
			joinauth.setEmail(m.getEmail());
			joinauth.setCode(randomCode);
			mService.insertAuth(joinauth);
		}
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
		int result=mService.joinH(m);
		return "index";
	}
	
	@GetMapping("/mypage")
	public String mypage(Model model,HttpServletRequest req) {
		HttpSession session = req.getSession();
		MemberVO mem=(MemberVO)session.getAttribute("mem");
		model.addAttribute("classlist", mService.getMyClassList(mem));
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
		//인증 안하고 도망갈수도 있어서 joinauth테이블도 지워주기//fk를 만들어두면 편할듯?
		int result=mService.leave(m);
		if(result>0) {
			HttpSession session = req.getSession();
			session.invalidate();
			return "index";
		}
		return "index";
	}
	
	@GetMapping("auth")
	public String auth(JoinAuth joinauth,Model model) {
		int result=mService.auth(joinauth);
		model.addAttribute("message", "메일 인증에 성공했습니다. 로그인 후 서비스 이용가능합니다.");
		return "index";
		
	}
	
	public String randomCode() {
		String code="";
		int num = 0;
		while (true) {
			num = (int)Math.floor(Math.random()*75) + 48;
			if ((num >= 48 && num <= 57) || (num >= 65 && num <= 90) || (num >= 97 && num <= 122)) {
				code+=(char)num;
			}
			if(code.length()>50)break;
		}
		return code;
	}
}
