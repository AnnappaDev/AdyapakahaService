package com.adyapakaha.boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adyapakaha.boot.model.Standard;
import com.adyapakaha.boot.service.StandardService;

@RestController
@RequestMapping(value = "/standard")
public class StandardController {

	@Autowired
	private StandardService standardService;

	@GetMapping
	public List<Standard> getAllStandards() {
		return standardService.getAllStandards();
	}

}
