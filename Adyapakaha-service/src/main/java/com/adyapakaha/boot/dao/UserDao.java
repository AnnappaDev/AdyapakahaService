package com.adyapakaha.boot.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.adyapakaha.boot.model.User;

@Repository
public interface UserDao extends CrudRepository<User, Long>{

	@Query(value="SELECT * from User usr where usr.username=?1", nativeQuery = true)
	public User getUserByName(String name);

	
}