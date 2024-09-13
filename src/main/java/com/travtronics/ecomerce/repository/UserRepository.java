package com.travtronics.ecomerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.travtronics.ecomerce.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findUserByUsername(String username);

}
