package com.lj.service;

import java.util.ArrayList;

import com.lj.vo.MemberVO;

public interface MemberService {

	public int join(MemberVO m);
	
	public void joinH(MemberVO m);
	
	public MemberVO getMember(String email,String pass);

	public ArrayList<MemberVO> getMemberList();
	
	public ArrayList<MemberVO> getHostList();

	public ArrayList<MemberVO> getAllList();

	public void leave(MemberVO m);
}
