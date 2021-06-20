package com.vamshi.proj.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vamshi.proj.model.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
	

}
