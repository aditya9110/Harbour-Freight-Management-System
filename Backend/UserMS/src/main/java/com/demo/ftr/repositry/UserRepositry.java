package com.demo.ftr.repositry;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.ftr.entity.User;

@Repository
public interface UserRepositry extends JpaRepository<User, Integer> {
	Optional<User> findByEmailId(String emailId);
}
