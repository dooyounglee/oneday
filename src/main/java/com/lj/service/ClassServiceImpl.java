package com.lj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lj.dao.ClassDAO;
import com.lj.vo.ClassVO;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@AllArgsConstructor
public class ClassServiceImpl implements ClassService{

	@Setter(onMethod_ = @Autowired)
	private ClassDAO dao;
	
	// 클래스 추가 --> 호스트 m_no도 가지고 가야함..
	@Override
	public void addClass(ClassVO vo) {

		log.info("add Class.....service" + vo);
		dao.addClass(vo);
	}
	
	@Override
	public List<ClassVO> getList() {
		
		log.info("getList......service");
		
		return dao.getList();
	}
	
	@Override
	public ClassVO get(int cno) {

		log.info("get....service");
		
		return dao.get(cno);
	}
	
	@Override
	public List<ClassVO> getMyList(int mno) {

		log.info("getMyList....service");
		return dao.getMyList(mno);
	}
	
	@Override
	public boolean updateClass(ClassVO vo) {
		
		log.info("updateClass........service");
		
		//정상적으로 수정삭제 이루어질때 1이 반환되므로 == 1로 비교한다
		return dao.updateClass(vo) == 1;
	}
	
}
