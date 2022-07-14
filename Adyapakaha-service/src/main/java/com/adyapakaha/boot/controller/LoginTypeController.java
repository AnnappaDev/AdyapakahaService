package com.adyapakaha.boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adyapakaha.boot.model.LoginType;
import com.adyapakaha.boot.service.LoginTypeService;

@RestController
@RequestMapping(value = "/loginType")
public class LoginTypeController {

	@Autowired
	private LoginTypeService loginTypeService;

	@PostMapping
	public LoginType creteNewLoginType(@RequestBody LoginType loginType) {
		return loginTypeService.createLoginType(loginType);
	}
	
	@GetMapping 
	public List<LoginType> getAllLoginType() {
		return loginTypeService.getAllLoginType();
	}
}
