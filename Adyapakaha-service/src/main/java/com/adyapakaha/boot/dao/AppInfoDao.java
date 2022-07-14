package com.adyapakaha.boot.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.adyapakaha.boot.model.AppInfo;

@Repository
public interface AppInfoDao extends CrudRepository<AppInfo, Long>{

}
