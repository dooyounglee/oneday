package com.lj.dao;

import java.util.ArrayList;

import com.lj.vo.MemberVO;

public interface MemberDAO {

	public int join(MemberVO m);
	
	public void joinH(MemberVO m);

	public MemberVO getMember(MemberVO m);

	public ArrayList<MemberVO> getMemberList();

	public ArrayList<MemberVO> getHostList();

	public ArrayList<MemberVO> getAllList();

	public void leave(MemberVO m);

}
