package com.vamshi.proj.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vamshi.proj.model.Todo;


@Repository
public interface TodoRepo extends JpaRepository<Todo, Long> {
  
	  
	
}
