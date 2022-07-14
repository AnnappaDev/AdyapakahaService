package com.adyapakaha.boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adyapakaha.boot.model.FeesAmount;
import com.adyapakaha.boot.service.FeesAmountService;

@RestController
@RequestMapping(value="/feesamount")
public class FeesAmountController {
	
	@Autowired
	private FeesAmountService feesAmountService;
	
	@GetMapping
	public List<FeesAmount> getAllFessAmount() {
		return feesAmountService.getAllFessAmount(); 
	}
	
	@PostMapping
	public FeesAmount createNewFeesAmount(@RequestBody FeesAmount feesAmount) {
		return feesAmountService.createNewFeesAmount(feesAmount);
	}
	
	@PutMapping({"/{id}"})
	public FeesAmount updateFeesAmount(@RequestBody FeesAmount feesAmount, @PathVariable long id) {
		return feesAmountService.updateFeesAmount(feesAmount, id);
	}
	
	@DeleteMapping({"/{id}"})
	public void deleteFeesAmount(@PathVariable long id) {
		feesAmountService.deleteFeesAmount(id);
	}
}
