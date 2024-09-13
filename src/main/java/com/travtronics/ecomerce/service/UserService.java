package com.travtronics.ecomerce.service;

import java.util.List;

import com.travtronics.ecomerce.entity.User;

public interface UserService {

	User saveUser(User user);

	User getUserById(Long id) throws Exception;

	List<User> getAllUsers();

	User updateUserById(Long id, User user) throws Exception;

	User findUserByUsername(String username);

	Boolean deleteUserById(Long id) throws Exception;

}
