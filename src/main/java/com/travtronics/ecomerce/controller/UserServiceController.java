package com.travtronics.ecomerce.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.travtronics.ecomerce.entity.User;
import com.travtronics.ecomerce.serviceimpl.UserServiceImpl;

@RestController
public class UserServiceController {

	UserServiceImpl userServiceImpl;

	public UserServiceController(UserServiceImpl userServiceImpl) {
		super();
		this.userServiceImpl = userServiceImpl;
	}

	@PostMapping("/newUser")
	public ResponseEntity<User> saveUser(@RequestBody User user) {
		User saveUser = userServiceImpl.saveUser(user);
		return new ResponseEntity<>(saveUser, HttpStatus.CREATED);
	}

	@GetMapping("getUser/{id}")
	public ResponseEntity<User> getUserById(@PathVariable Long id) throws Exception {
		User userById = userServiceImpl.getUserById(id);
		return new ResponseEntity<>(userById, HttpStatus.FOUND);
	}

	@GetMapping("/allUsers")
	public ResponseEntity<List<User>> getAllUsers() {
		List<User> allUsers = userServiceImpl.getAllUsers();
		return new ResponseEntity<>(allUsers, HttpStatus.FOUND);
	}

	@PutMapping("/updateUser/{id}")
	public ResponseEntity<User> updateUserById(@PathVariable Long id, @RequestBody User user) throws Exception {
		User updateUserById = userServiceImpl.updateUserById(id, user);
		return new ResponseEntity<>(updateUserById, HttpStatus.ACCEPTED);
	}

	@GetMapping("/userByName")
	public ResponseEntity<User> findUserByUsername(@RequestParam(value = "username") String username) {
		User user = userServiceImpl.findUserByUsername(username);

		return new ResponseEntity<>(user, HttpStatus.FOUND);

	}

	@DeleteMapping("/deleteUser/{id}")
	public ResponseEntity<Boolean> deleteUserById(@PathVariable Long id) throws Exception {
		Boolean deleteUserById = userServiceImpl.deleteUserById(id);
		return new ResponseEntity<>(deleteUserById, HttpStatus.OK);

	}

}

//if (user != null) {
//return new ResponseEntity<>(user, HttpStatus.OK);
//} else {
//return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//}
