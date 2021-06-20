package com.vamshi.proj.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vamshi.proj.model.Album;

@Repository
public interface AlbumRepo extends JpaRepository<Album, Long>{

	
}
