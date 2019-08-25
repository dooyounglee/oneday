package com.lj.dao;

import java.util.ArrayList;

import com.lj.vo.ClassVO;
import com.lj.vo.JoinAuth;
import com.lj.vo.MemberVO;

public interface MemberDAO {

	public int join(MemberVO m);
	
	public int joinH(MemberVO m);

	public MemberVO getMember(MemberVO m);

	public ArrayList<MemberVO> getMemberList();

	public ArrayList<MemberVO> getHostList();

	public ArrayList<MemberVO> getAllList();

	public int leave(MemberVO m);

	public ArrayList<ClassVO> getMyClassList(MemberVO mem);

	public void insertAuth(JoinAuth joinauth);

	public int auth(JoinAuth joinauth);

	public int isAuth(MemberVO m);

	public int changePass(MemberVO mem);

}
