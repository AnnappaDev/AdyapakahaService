package com.adyapakaha.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adyapakaha.boot.dao.FeesTenureDao;
import com.adyapakaha.boot.model.FeesTenure;

@Service
public class FeesTenureService {

	@Autowired
	private FeesTenureDao feesTenureDao;

	public List<FeesTenure> getAllFeesTenure() {
		return (List<FeesTenure>) feesTenureDao.findAll();
	}
}
