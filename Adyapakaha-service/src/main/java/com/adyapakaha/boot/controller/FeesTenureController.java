package com.adyapakaha.boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adyapakaha.boot.model.FeesTenure;
import com.adyapakaha.boot.service.FeesTenureService;

@RestController
@RequestMapping(value = "/feestenure")
public class FeesTenureController {

	@Autowired
	private FeesTenureService feesTenureService;

	@GetMapping
	public List<FeesTenure> getAllFeesTenure() {
		return (List<FeesTenure>) feesTenureService.getAllFeesTenure();
	}

}
