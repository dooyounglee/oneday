package com.lj.service;

import java.util.ArrayList;

import com.lj.vo.BookingVO;
import com.lj.vo.MemberVO;

public interface BookingService {

	public void bookClass(BookingVO book);

	public ArrayList<BookingVO> getMyList(MemberVO mem);

	public void bookCancel(int b_no);

}
