package com.travtronics.ecomerce;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Optional;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.travtronics.ecomerce.appconstants.EcommerceConstants;
import com.travtronics.ecomerce.entity.Role;
import com.travtronics.ecomerce.entity.User;
import com.travtronics.ecomerce.globalexceptionhandle.IdNotFoundException;
import com.travtronics.ecomerce.repository.UserRepository;
import com.travtronics.ecomerce.serviceimpl.UserServiceImpl;

@SpringBootTest
class UserServiceImplTest {

	@Mock
	UserRepository userRepository;

	@Mock
	private PasswordEncoder passwordEncoder;

	@InjectMocks
	UserServiceImpl userServiceImpl;

	@Test
	@Order(1)
	void test_saveUser() {
		Long id1 = 1L;
		User user1 = new User();
		user1.setId(id1);
		user1.setUsername("john");
		user1.setPassword("john@123");
		user1.setRole(Role.USER);

		// Mock Password
		String encodedPassword = "john@123";
		when(passwordEncoder.encode("john@123")).thenReturn(encodedPassword);

		// Set Expected Password
		user1.setPassword(encodedPassword);

		// Mock repository save method
		when(userRepository.save(user1)).thenReturn(user1);

		// Act
		User savedUser = userServiceImpl.saveUser(user1);

		assertEquals(user1.getUsername(), savedUser.getUsername());
		assertEquals(encodedPassword, savedUser.getPassword()); // Ensure password is encoded
		assertEquals(user1.getRole(), savedUser.getRole());

		// Verify that the repository save method was called
		verify(userRepository, times(1)).save(user1);
	}

	@Test
	@Order(2)
	void test_getUserById() {
		Long id2 = 2L;
		User user2 = new User();
		user2.setId(id2);
		user2.setUsername("Admin");
		user2.setPassword("admin@111");
		user2.setRole(Role.ADMIN);

		when(userRepository.findById(id2)).thenReturn(Optional.of(user2));

		assertEquals(id2, userServiceImpl.getUserById(id2).getId());

	}

	@Test
	@Order(3)
	void test_getUserById_NotFound() {
		Long id2 = 2L;
		User user2 = new User();
		user2.setId(id2);
		user2.setUsername("Admin");
		user2.setPassword("admin@111");
		user2.setRole(Role.ADMIN);

		when(userRepository.findById(id2)).thenReturn(Optional.empty());

		IdNotFoundException exceptionMessage = assertThrows(IdNotFoundException.class,
				() -> userServiceImpl.getUserById(id2));

		assertEquals(EcommerceConstants.USER_ID_NOT_FOUND + id2, exceptionMessage.getMessage());

		verify(userRepository).findById(id2);
	}

	@Test
	@Order(4)
	void test_getAllUsers() {

		ArrayList<User> userList = new ArrayList<>();

		Long id1 = 1L;
		User user1 = new User();
		user1.setId(id1);
		user1.setUsername("john");
		user1.setPassword("john@123");
		user1.setRole(Role.USER);

		Long id2 = 2L;
		User user2 = new User();
		user2.setId(id2);
		user2.setUsername("Admin");
		user2.setPassword("admin@111");
		user2.setRole(Role.ADMIN);

		userList.add(user1);
		userList.add(user2);

		when(userRepository.findAll()).thenReturn(userList);

		assertEquals(2, userServiceImpl.getAllUsers().size());

	}

	@Test
	@Order(5)
	void test_updateUserById() {

		Long euid = 1L; // Existing user ID
		User existingUser = new User();
		existingUser.setId(euid);
		existingUser.setUsername("john");
		existingUser.setPassword("john@123");
		existingUser.setRole(Role.USER);

		// Data for update
		User updateUser = new User();
		updateUser.setId(euid); // Same ID as the existing user
		updateUser.setUsername("john_updated");
		updateUser.setPassword("newpassword@123");
		updateUser.setRole(Role.ADMIN);

		// Mocking repository methods
		when(userRepository.existsById(euid)).thenReturn(true);
		when(userRepository.findById(euid)).thenReturn(Optional.of(existingUser));
		when(userRepository.save(existingUser)).thenReturn(existingUser);

		// Act
		User updatedUser = userServiceImpl.updateUserById(euid, updateUser);

		// Assert: Verify that the user was updated correctly
		assertEquals("john_updated", updatedUser.getUsername());
		assertEquals("newpassword@123", updatedUser.getPassword());
		assertEquals(Role.ADMIN, updatedUser.getRole());

		// Verify interactions with the repository
		verify(userRepository, times(1)).existsById(euid);
		verify(userRepository, times(1)).findById(euid);
		verify(userRepository, times(1)).save(existingUser);
	}

	@Test
	@Order(6)
	void test_updateUserById_NotFound() {
		Long euid = 1L; // Existing user ID
		User existingUser = new User();
		existingUser.setId(euid);
		existingUser.setUsername("john");
		existingUser.setPassword("john@123");
		existingUser.setRole(Role.USER);

		// Data for update
		User updateUser = new User();
		updateUser.setId(euid); // Same ID as the existing user
		updateUser.setUsername("john_updated");
		updateUser.setPassword("newpassword@123");
		updateUser.setRole(Role.ADMIN);

		// Mocking repository methods
		when(userRepository.existsById(euid)).thenReturn(true);
		when(userRepository.findById(euid)).thenReturn(Optional.empty());
		IdNotFoundException exceptionMessage = assertThrows(IdNotFoundException.class,
				() -> userServiceImpl.getUserById(euid));

		assertEquals(EcommerceConstants.USER_ID_NOT_FOUND + euid, exceptionMessage.getMessage());
	}

	@Test
	@Order(7)
	void test_findUserByUsername() {
		Long id1 = 1L;
		String username = "john";
		User user1 = new User();
		user1.setId(id1);
		user1.setUsername(username);
		user1.setPassword("john@123");
		user1.setRole(Role.USER);

		when(userRepository.findUserByUsername(username)).thenReturn(user1);
		assertEquals(username, userServiceImpl.findUserByUsername(username).getUsername());

	}

//	@Test
//	@Order(8)
//	void test_deleteUserById() {
//		Long id1 = 1L;
//		User user1 = new User();
//		user1.setId(id1);
//		user1.setUsername("john");
//		user1.setPassword("john@123");
//		user1.setRole(Role.USER);
//
//		// Mock the findById to return the user
//		when(userRepository.findById(id1)).thenReturn(Optional.of(user1)); // Ensure this line is correct
//
//		// Act
//		Boolean result = userServiceImpl.deleteUserById(id1);
//
//		// Assert
//		assertTrue(result);
//
//		verify(userRepository, times(1)).deleteById(id1);
//	}

	@Test
	@Order(9)
	void test_deleteUserById_NotFoun() {
		Long id1 = 1L;
		User user1 = new User();
		user1.setId(id1);
		user1.setUsername("john");
		user1.setPassword("john@123");
		user1.setRole(Role.USER);

		// Mock the findById to return the user
		when(userRepository.findById(id1)).thenReturn(Optional.empty());

		IdNotFoundException exceptionMessage = assertThrows(IdNotFoundException.class,
				() -> userServiceImpl.deleteUserById(id1));
		assertEquals(EcommerceConstants.USER_ID_NOT_FOUND + id1, exceptionMessage.getMessage());
	}
}
