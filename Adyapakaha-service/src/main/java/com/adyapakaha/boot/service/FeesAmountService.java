package com.adyapakaha.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adyapakaha.boot.dao.FeesAmountDao;
import com.adyapakaha.boot.model.FeesAmount;
import com.adyapakaha.boot.model.Student;

@Service
public class FeesAmountService {

	@Autowired
	private FeesAmountDao feesAmountDao;
	
	public List<FeesAmount> getAllFessAmount() {
		return (List<FeesAmount>) feesAmountDao.findAll();
	}
	
	public FeesAmount createNewFeesAmount(FeesAmount feesAmount) {
		return feesAmountDao.save(feesAmount);
	}

	public FeesAmount updateFeesAmount(FeesAmount feesAmount, long id) {
		FeesAmount updatedfeesAmount = feesAmountDao.findById(id).orElseThrow();
		updatedfeesAmount.setAmount(feesAmount.getAmount());
		updatedfeesAmount.setStandard(feesAmount.getStandard());
		return feesAmountDao.save(updatedfeesAmount);
	}
	
	public void deleteFeesAmount(long id) {
		feesAmountDao.deleteById(id);
	}
}
