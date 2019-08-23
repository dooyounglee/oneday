package com.lj.vo;

public class ClassVO {

	private int class_no;  //FK
	private int m_no;      //FK - host테이블
	private String title;
	private String main_img;
	private String content;
	private int price;
	private String address;
	private String class_day;  // 
	private String class_time; // 두개를 합쳐서 ==> class_date컬럼에 넣기
	private int maxperson;
	private String reg_date;
	
	public ClassVO() {
		// TODO Auto-generated constructor stub
	}
	
	public ClassVO(int class_no, int m_no, String title, String main_img, String content, int price, String address,
			String class_day, String class_time, int maxperson, String reg_date) {
		super();
		this.class_no = class_no;
		this.m_no = m_no;
		this.title = title;
		this.main_img = main_img;
		this.content = content;
		this.price = price;
		this.address = address;
		this.class_day = class_day;
		this.class_time = class_time;
		this.maxperson = maxperson;
		this.reg_date = reg_date;
	}

	public int getClass_no() {
		return class_no;
	}

	public void setClass_no(int class_no) {
		this.class_no = class_no;
	}

	public int getM_no() {
		return m_no;
	}

	public void setM_no(int m_no) {
		this.m_no = m_no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMain_img() {
		return main_img;
	}

	public void setMain_img(String main_img) {
		this.main_img = main_img;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getClass_day() {
		return class_day;
	}

	public void setClass_day(String class_day) {
		this.class_day = class_day;
	}

	public String getClass_time() {
		return class_time;
	}

	public void setClass_time(String class_time) {
		this.class_time = class_time;
	}

	public int getMaxperson() {
		return maxperson;
	}

	public void setMaxperson(int maxperson) {
		this.maxperson = maxperson;
	}

	public String getReg_date() {
		return reg_date;
	}

	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}

	@Override
	public String toString() {
		return "ClassVO [class_no=" + class_no + ", m_no=" + m_no + ", title=" + title + ", main_img=" + main_img
				+ ", content=" + content + ", price=" + price + ", address=" + address + ", class_day=" + class_day
				+ ", class_time=" + class_time + ", maxperson=" + maxperson + ", reg_date=" + reg_date + "]";
	}
	
	
	
	
}
