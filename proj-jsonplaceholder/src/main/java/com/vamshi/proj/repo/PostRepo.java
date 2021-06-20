package com.vamshi.proj.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vamshi.proj.model.Post;


@Repository
public interface PostRepo  extends JpaRepository<Post, Long>{
	

	
	
}
