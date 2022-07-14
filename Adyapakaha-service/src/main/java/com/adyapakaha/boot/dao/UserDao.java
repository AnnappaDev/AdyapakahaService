package com.adyapakaha.boot.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.adyapakaha.boot.model.User;

@Repository
public interface UserDao extends CrudRepository<User, Long>{

	
}