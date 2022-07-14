package com.adyapakaha.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adyapakaha.boot.dao.GenderDao;
import com.adyapakaha.boot.model.Gender;

@Service
public class GenderService {

	@Autowired
	private GenderDao genderDao;
	public List<Gender> getAllGender() {
		return (List<Gender>) genderDao.findAll(); 
	}
}
