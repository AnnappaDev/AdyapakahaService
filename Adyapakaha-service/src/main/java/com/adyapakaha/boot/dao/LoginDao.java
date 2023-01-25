package com.adyapakaha.boot.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

//@Repository
//public interface LoginDao extends CrudRepository<UserDetails, Long> {
//
//	@Query(value="SELECT * from User usr where usr.username=?1", nativeQuery = true)
//	User processLogin(String userName);
//
//}
