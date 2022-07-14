package com.adyapakaha.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adyapakaha.boot.dao.AppInfoDao;
import com.adyapakaha.boot.model.AppInfo;


@Service
public class AppInfoService {

	@Autowired
	private AppInfoDao appInfoDao;

	public AppInfo createNewAppInfo(AppInfo appInfo) {
		return appInfoDao.save(appInfo);
	}
	
	public List<AppInfo> getAllAppInfo () {
		return (List<AppInfo>) appInfoDao.findAll();
	}
}

