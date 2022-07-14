package com.adyapakaha.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adyapakaha.boot.dao.LoginTypeDao;
import com.adyapakaha.boot.model.LoginType;

@Service
public class LoginTypeService {

	@Autowired
	private LoginTypeDao loginTypeDao;

	public LoginType createLoginType(LoginType loginType) {
		return loginTypeDao.save(loginType);
	}
	
	public List<LoginType> getAllLoginType() {
		return (List<LoginType>) loginTypeDao.findAll();
	}
}
