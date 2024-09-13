package com.travtronics.ecomerce.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.travtronics.ecomerce.entity.User;
import com.travtronics.ecomerce.repository.UserRepository;
import com.travtronics.ecomerce.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	@Autowired
	PasswordEncoder passwordEncoder;

	@Override
	public User saveUser(User user) {

		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return userRepository.save(user);
	}

	@Override
	public User getUserById(Long id) throws Exception {
		Optional<User> findById = userRepository.findById(id);
		if (findById.isPresent()) {
			return findById.get();
		}
		throw new Exception("Id Not Found :" + id);
	}

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public User updateUserById(Long id, User user) throws Exception {
		if (userRepository.existsById(id)) {
			User existingUser = userRepository.findById(id).orElseThrow(() -> new Exception("Id Not Found :" + id));
			existingUser.setUsername(user.getUsername());
			existingUser.setPassword(user.getPassword());
			existingUser.setRole(user.getRole());
			return userRepository.save(existingUser);
		} else {
			throw new Exception("Id Not Found :" + id);
		}
	}

	@Override
	public User findUserByUsername(String username) {
		User user = userRepository.findUserByUsername(username);

		return user;
	}

	@Override
	public Boolean deleteUserById(Long id) throws Exception
	{
		Optional<User> findById = userRepository.findById(id);
		if(findById.isPresent())
		{
			userRepository.deleteById(id);
		}
		throw new Exception("Id Not Found Exception");
	}

}
