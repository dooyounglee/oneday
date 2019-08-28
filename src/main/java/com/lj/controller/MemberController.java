package com.lj.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lj.service.BookingService;
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
	private BookingService bService;
	private JavaMailSenderImpl mailSender;
	
	//로그인페이지로
	@GetMapping("/login")
	public String login(Model model) {
		model.addAttribute("mlist", mService.getMemberList());
		model.addAttribute("hlist", mService.getHostList());
		model.addAttribute("list", mService.getAllList());
		return "/member/login";
	}
	
	//로그인
	@PostMapping("/login")
	public String login(MemberVO m,HttpServletRequest req, Model model) {
		log.info("login버튼 눌렀다."+m);
		HttpSession session = req.getSession();
		MemberVO mem=mService.getMember(m.getEmail(), m.getPass());
		int isAuth=mService.isAuth(m);//joinauth테이블에 있는지?
		if(mem!=null && isAuth==0) {
			session.setAttribute("mem", mem);
			return "redirect:/";
		}else if(isAuth>0){
			model.addAttribute("message", "서비스를 이용하시려면 메일 인증을 해주세요.");
			return "/member/login";
		}else {
			model.addAttribute("message", "아이디, 비번을 확인하세요.");
			return "/member/login";
		}
	}
	
	//일반회원가입 페이지로
	@GetMapping("/join")
	public String join(Model model) {
//		MessageDigest md=MessageDigest.getInstance("SHA-512");
//		byte[] bytes="a".getBytes(Charset.forName("UTF-8"));
//		md.update(bytes);
//		System.out.println(Base64.getEncoder().encodeToString(md.digest()));
		
		model.addAttribute("mlist", mService.getMemberList());
		model.addAttribute("hlist", mService.getHostList());
		return "/member/join";
	}
	
	//일반 회원가입
	@PostMapping("/join")
	public String join(MemberVO m,HttpServletRequest req) {
		m.setHost("N");
//		MessageDigest md=MessageDigest.getInstance("SHA-512");
//		byte[] bytes="a".getBytes(Charset.forName("UTF-8"));
//		md.update(bytes);
//		System.out.println(Base64.getEncoder().encodeToString(md.digest()));
		
		String randomCode=randomCode(50);
		//인증메일보내기
		MimeMessage msg = mailSender.createMimeMessage();
        try {
			msg.setSubject("테스트메일");
			msg.setText("http://"+req.getServerName()+":"+req.getServerPort()+"/member/auth?email="+m.getEmail()+"&code="+randomCode);
			msg.setFrom(new InternetAddress(mailSender.getUsername()));
		    msg.setRecipient(RecipientType.TO , new InternetAddress(m.getEmail()));
        } catch (MessagingException e) {
			e.printStackTrace();
		}
        mailSender.send(msg);
		System.out.println("http://"+req.getServerName()+":"+req.getServerPort()+"/member/auth?email="+m.getEmail()+"&code="+randomCode);
        
		int result=mService.join(m);
		if(result>0) {
			JoinAuth joinauth=new JoinAuth();
			joinauth.setEmail(m.getEmail());
			joinauth.setCode(randomCode);
			mService.insertAuth(joinauth);
		}
		return "redirect:/";
	}
	
	//호스트가입 페이지로
	@GetMapping("/joinH")
	public String joinH(Model model) {
		model.addAttribute("mlist", mService.getMemberList());
		model.addAttribute("hlist", mService.getHostList());
		return "/member/joinH";
	}
	
	//호스트가입
	@PostMapping("/joinH")
	public String joinH(MemberVO m) {
		log.info("controller "+m);
		int result=mService.joinH(m);
		return "redirect:/";
	}
	
	//마이페이지
	@GetMapping("/mypage")
	public String mypage(Model model,HttpServletRequest req) {
		HttpSession session = req.getSession();
		MemberVO mem=(MemberVO)session.getAttribute("mem");
		model.addAttribute("classlist", mService.getMyClassList(mem));
		model.addAttribute("books", bService.getMyList(mem));
		return "/member/mypage";
	}
	
	//로그아웃
	@GetMapping("/logout")
	public String logout(HttpServletRequest req) {
		HttpSession session = req.getSession();
		session.invalidate();
		return "redirect:/";
	}
	
	//내정보 수정 페이지로
	@GetMapping("/update")
	public String update() {
		return "/member/mypage_update";
	}
	
	//내정보 수정
//	@PostMapping("/update")
//	public String update(MemberVO m) {
//		log.info("..........update");
//		return "member/mypage";
//	}
	
	//탈퇴해버리기
	@GetMapping("/leave")
	public String leave(MemberVO m, HttpServletRequest req) {
		log.info(".......controller leave "+m);
		//인증 안하고 도망갈수도 있어서 joinauth테이블도 지워주기//fk를 만들어두면 편할듯?
		int result=mService.leave(m);
		if(result>0) {
			HttpSession session = req.getSession();
			session.invalidate();
			return "redirect:/";
		}
		return "redirect:/";
	}
	
	//유저가 인증메일에 url누르면
	@GetMapping("auth")
	public String auth(JoinAuth joinauth,Model model) {
		int result=mService.auth(joinauth);
		model.addAttribute("message", "메일 인증에 성공했습니다. 로그인 후 서비스 이용가능합니다.");
		return "redirect:/";
		
	}
	
	//비번 모른다면
	@PostMapping("findpass")
	public void findPass(HttpServletRequest req,HttpServletResponse res) {
		try {
			PrintWriter out;
			out = res.getWriter();
			String email=req.getParameter("email");
			String randomCode=randomCode(10);
			MemberVO mem=new MemberVO();
			mem.setEmail(email);
			mem.setPass(randomCode);
			int result=mService.changePass(mem);
			if(result>0) {
				//이메일 안내
				MimeMessage msg = mailSender.createMimeMessage();
		        try {
					msg.setSubject("[oneday]임시비밀번호");
					msg.setText("임시비밀번호는 ["+randomCode+"] 입니다. 퍼뜩 로그인 후 수정하세요.");
					msg.setFrom(new InternetAddress(mailSender.getUsername()));
				    msg.setRecipient(RecipientType.TO , new InternetAddress(email));
		        } catch (MessagingException e) {
					e.printStackTrace();
				}
		        mailSender.send(msg);
		        out.print("success");
			}else {
				out.print("fail");//메일이 없거나.. 암튼 실패
			}
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	
	//비번수정
	@PostMapping("changepass")
	public String changePass(MemberVO m,HttpServletRequest req,Model model) {
		String newpass=req.getParameter("newpass");
		MemberVO mem=mService.getMember(m.getEmail(), m.getPass());
		mem.setPass(newpass);
		int result=mService.changePass(mem);
		if(result>0) {
			MemberVO m1=new MemberVO();
			m1.setEmail(mem.getEmail());
			m1.setPass(mem.getPass());
			m1=mService.getMember(m1.getEmail(), m1.getPass());
			HttpSession session=req.getSession();
			session.setAttribute("mem", m1);
			model.addAttribute("message", "성공적으로 비번을 바꿨습니다.");
		}
		return "/member/mypage";
	}
	
	//랜덤코드 생성
	public String randomCode(int len) {
		String code="";
		int num = 0;
		while (true) {
			num = (int)Math.floor(Math.random()*75) + 48;
			if ((num >= 48 && num <= 57) || (num >= 65 && num <= 90) || (num >= 97 && num <= 122)) {
				code+=(char)num;
			}
			if(code.length()>len)break;
		}
		return code;
	}
}
