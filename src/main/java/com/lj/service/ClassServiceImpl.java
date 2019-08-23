package com.lj.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lj.dao.ClassDAO;

import lombok.AllArgsConstructor;
import lombok.Setter;

@Service
@AllArgsConstructor
public class ClassServiceImpl implements ClassService {

	@Setter(onMethod_ = @Autowired)
	private ClassDAO dao;
	
	
	
	
}
