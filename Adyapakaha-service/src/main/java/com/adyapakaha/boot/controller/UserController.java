package com.adyapakaha.boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adyapakaha.boot.model.User;
import com.adyapakaha.boot.service.UserService;

@RestController
@RequestMapping(value="/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping
	public User createNewUser(@RequestBody User user) {
		return userService.createNewUser(user);
	}
	
	@GetMapping
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}
	
	@GetMapping({"/{name}"})
	public User getUserByName(@PathVariable String name) {
		return userService.getUserByName(name);
	}
	
	@PutMapping({"/{id}"})
	public User createUpdateUser(@RequestBody User user, @PathVariable long id) {
		return userService.updateUser(id, user);
	}
	
	@DeleteMapping({"/{id}"})
	public void deleteUser(@PathVariable long id) {
		 userService.deleteUser(id);
	}
}
