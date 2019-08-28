package com.lj.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lj.dao.BookingDAO;
import com.lj.vo.BookingVO;
import com.lj.vo.MemberVO;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@AllArgsConstructor
public class BookingServiceImpl implements BookingService {

	@Setter(onMethod_=@Autowired)
	private BookingDAO bd;
	
	@Transactional
	@Override
	public void bookClass(BookingVO book) {
		bd.bookClass(book);
		
		bd.minusPossible(book);
		//0일땐 -1될텐데 이걸 막아야 해
	}

	@Override
	public ArrayList<BookingVO> getMyList(MemberVO mem) {
		return bd.getMyList(mem);
	}

	@Override
	public void bookCancel(int b_no) {
		BookingVO book=bd.getBooking(b_no);
		bd.plusPossible(book);
		
		bd.bookCancel(b_no);
	}


}
