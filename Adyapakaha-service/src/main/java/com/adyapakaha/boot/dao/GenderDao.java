package com.adyapakaha.boot.dao;

import org.springframework.data.repository.CrudRepository;

import com.adyapakaha.boot.model.Gender;

public interface GenderDao extends CrudRepository<Gender, Long>{

	
}