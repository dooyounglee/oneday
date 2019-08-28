package com.lj.dao;

import java.util.ArrayList;

import com.lj.vo.BookingVO;
import com.lj.vo.MemberVO;

public interface BookingDAO {

	public void bookClass(BookingVO book);

	public ArrayList<BookingVO> getMyList(MemberVO mem);

	public void minusPossible(BookingVO book);

	public void bookCancel(int b_no);

	public BookingVO getBooking(int b_no);

	public void plusPossible(BookingVO book);

}
