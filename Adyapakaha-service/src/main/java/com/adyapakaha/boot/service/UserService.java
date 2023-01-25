package com.adyapakaha.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.adyapakaha.boot.dao.UserDao;
import com.adyapakaha.boot.model.User;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;


	@Autowired
	private PasswordEncoder passwordEncoder;

	public User createNewUser(User user) {
		user.setPassword(getEncodedPassword(user.getPassword()));
		return userDao.save(user);
	}

	public List<User> getAllUsers() {
		return (List<User>) userDao.findAll();
	}

	public User updateUser(Long id, User user) {
		User updateUser = userDao.findById(id).orElseThrow();
		updateUser.setUsername(user.getUsername());
		return userDao.save(user);
	}

	public void deleteUser(Long id) {
		userDao.deleteById(id);
	}

	public User getUserByName(String name) {
		return userDao.getUserByName(name);
	}
	
	private String getEncodedPassword(String name) {
		return passwordEncoder.encode(name);
	}
}
