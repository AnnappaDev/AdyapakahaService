package com.adyapakaha.boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adyapakaha.boot.model.Gender;
import com.adyapakaha.boot.service.GenderService;

@RestController
@RequestMapping(value="/gender")
public class GenderController {
	
	@Autowired
	private GenderService genderService;

	@GetMapping
	public List<Gender> getAllGender() {
		return genderService.getAllGender();
	}

}
