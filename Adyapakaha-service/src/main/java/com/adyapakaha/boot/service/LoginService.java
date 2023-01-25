package com.adyapakaha.boot.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.adyapakaha.boot.dao.UserDao;


@Service
public class LoginService implements UserDetailsService{
	
   @Autowired
	private UserDao userDao;
	
//	@Override
//    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
//    	System.out.println("inside load user by name");
        //Logic to get the user form the Database
//    	User u = loginDao.processLogin(userName);
//        return new User(u.getUsername(),u.getPassword(),new ArrayList<>());
//        return new User("admin","password",new ArrayList<>());
//    }
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		com.adyapakaha.boot.model.User user = userDao.getUserByName(username);
		if (user!= null) {
			return new org.springframework.security.core.userdetails.User
					(user.getUsername(),user.getPassword(), new ArrayList<>());
					
		} else {
			throw new UsernameNotFoundException("User name is not valid");
		}
	}
}
