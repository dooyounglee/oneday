package com.lj.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lj.dao.MemberDAO;
import com.lj.vo.ClassVO;
import com.lj.vo.JoinAuth;
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
		int result=0;
		result=md.join(m);
		return result;
	}

	@Transactional
	@Override
	public int joinH(MemberVO m) {
		int result=0;
		m.setHost("Y");
		System.out.println(md.join(m));
		
		MemberVO host=getMember(m.getEmail(),m.getPass());
		host.setPhone(m.getPhone());
		result=md.joinH(host);
		return result;
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
	public int leave(MemberVO m) {
		int result=0;
		result=md.leave(m);
		return result;
	}

	@Override
	public ArrayList<ClassVO> getMyClassList(MemberVO mem) {
		return md.getMyClassList(mem);
	}

	@Override
	public void insertAuth(JoinAuth joinauth) {
		md.insertAuth(joinauth);
	}

	@Override
	public int auth(JoinAuth joinauth) {
		int result=md.auth(joinauth);
		return result;
	}

	@Override
	public int isAuth(MemberVO m) {
		int result=md.isAuth(m);
		return result;
	}

	@Override
	public int changePass(MemberVO mem) {
		int result=md.changePass(mem);
		return result;
	}
	
}
