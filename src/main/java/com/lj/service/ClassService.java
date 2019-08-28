package com.lj.service;

import java.util.List;

import com.lj.vo.ClassVO;

public interface ClassService {

	public void addClass(ClassVO vo);
	
	public List<ClassVO> getList();
	
	public ClassVO get(int cno);
	
	public List<ClassVO> getMyList(int mno);
	
	public boolean updateClass(ClassVO vo);
	
}
