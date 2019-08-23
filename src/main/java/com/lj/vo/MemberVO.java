package com.lj.vo;

import lombok.Data;

@Data
public class MemberVO {

	private int m_no;
	private String email;
	private String pass;
	private String phone;
	private String host="N";
}
