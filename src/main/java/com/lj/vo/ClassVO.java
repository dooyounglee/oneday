package com.lj.vo;

import lombok.Data;

@Data
public class ClassVO {

	private int class_no;  //FK
	private int m_no;      //FK - host테이블
	private String title;
	private String title_img; 
	private String content;
	private int price;
	private String address;
	private String address_detail;
	private String class_day;  // 
	private String class_time; // 두개를 합쳐서 ==> class_date컬럼에 넣기
	private int maxperson;
	private String reg_date;
	private int possible;
	
}
