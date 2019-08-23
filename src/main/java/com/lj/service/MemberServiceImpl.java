package com.lj.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lj.dao.MemberDAO;
import com.lj.vo.MemberVO;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@AllArgsConstructor
public class MemberServiceImpl implements MemberService {

	@Setter(onMethod_ = @Autowired)
	private MemberDAO md;
	
	@Override
	public int join(MemberVO m) {
		return md.join(m);
		
	}

	@Transactional
	@Override
	public void joinH(MemberVO m) {
		m.setHost("Y");
		md.join(m);
		
		MemberVO host=getMember(m.getEmail(),m.getPass());
		host.setPhone(m.getPhone());
		md.joinH(host);
	}

	@Override
	public MemberVO getMember(String email, String pass) {
		MemberVO mem=new MemberVO();
		mem.setEmail(email);
		mem.setPass(pass);
		MemberVO m=md.getMember(mem);
		return m;
	}

	@Override
	public ArrayList<MemberVO> getMemberList() {
		return md.getMemberList();
	}

	@Override
	public ArrayList<MemberVO> getHostList() {
		return md.getHostList();
	}

	@Override
	public ArrayList<MemberVO> getAllList() {
		return md.getAllList();
	}

	@Override
	public void leave(MemberVO m) {
		log.info(m);
		md.leave(m);
	}



	
}
