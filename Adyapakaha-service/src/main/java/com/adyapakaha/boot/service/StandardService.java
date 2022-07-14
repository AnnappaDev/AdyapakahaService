package com.adyapakaha.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adyapakaha.boot.dao.StandardDao;
import com.adyapakaha.boot.model.Standard;

@Service
public class StandardService {

	@Autowired
	private StandardDao standardDao;

	public List<Standard> getAllStandards() {
		return (List<Standard>) standardDao.findAll();
	}
}
