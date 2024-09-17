package com.travtronics.ecomerce.service;

import java.util.List;

import com.travtronics.ecomerce.entity.User;
import com.travtronics.ecomerce.globalexceptionhandle.IdNotFoundException;

public interface UserService {

	User saveUser(User user);

	User getUserById(Long id) throws IdNotFoundException;

	List<User> getAllUsers();

	User updateUserById(Long id, User user) throws IdNotFoundException;

	User findUserByUsername(String username);

	Boolean deleteUserById(Long id) throws IdNotFoundException;

}
