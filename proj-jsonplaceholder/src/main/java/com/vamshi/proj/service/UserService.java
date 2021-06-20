package com.vamshi.proj.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.vamshi.proj.vo.ResAlbum;
import com.vamshi.proj.vo.ResPhoto;
import com.vamshi.proj.vo.ResPost;
import com.vamshi.proj.vo.ResTodo;

@Service
public interface UserService {
       
	List<ResPost> getPostsByUserId(Long userId);
	List<ResAlbum> getAlbumsByUserId(Long userId);
	List<ResPhoto> getPhotosByAlbumId(Long albumId);
	List<ResTodo> getTodoByUserId(Long userId);
	
	
	
	
}
