package com.adyapakaha.boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adyapakaha.boot.model.AppInfo;
import com.adyapakaha.boot.service.AppInfoService;

@RestController
@RequestMapping(value = "/appInfo")
public class AppInfoController {
	
	@Autowired
	private AppInfoService appInfoService;
	
	@GetMapping
	public List<AppInfo> getAllAppInfo() {
		return appInfoService.getAllAppInfo();
	}
	
	@PostMapping
	public AppInfo createAppInfo(@RequestBody AppInfo appInfo) {
		return appInfoService.createNewAppInfo(appInfo);
	}
}
