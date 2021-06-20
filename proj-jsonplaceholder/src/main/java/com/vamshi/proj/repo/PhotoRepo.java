package com.vamshi.proj.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vamshi.proj.model.Photo;

@Repository
public interface PhotoRepo extends  JpaRepository<Photo, Long> {
	

}
