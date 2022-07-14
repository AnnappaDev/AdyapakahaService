package com.adyapakaha.boot.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.adyapakaha.boot.model.LoginType;

@Repository
public interface LoginTypeDao extends CrudRepository<LoginType, Long>{

}