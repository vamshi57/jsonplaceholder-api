package com.vamshi.proj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vamshi.proj.service.PostService;
import com.vamshi.proj.service.UserService;

@RestController
@RequestMapping(value = "/")
public class UserController {
	@Autowired
	private PostService postService;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "users/{userId}/posts" ,method = RequestMethod.GET,produces = "application/json")
	public ResponseEntity<?> getAllPostsOfUser(@PathVariable("userId") Long userId){
		return ResponseEntity.ok(userService.getPostsByUserId(userId));		
	}
	
	
	@RequestMapping(value = "users/{userId}/albums" ,method = RequestMethod.GET,produces = "application/json")
	public ResponseEntity<?> getAllAlbumsOfUser(@PathVariable("userId") Long userId){
		
		return ResponseEntity.ok(userService.getAlbumsByUserId(userId));		
	}
	
	@RequestMapping(value = "albums/{albumId}/photos" ,method = RequestMethod.GET,produces = "application/json")
	public ResponseEntity<?> getAllPhotosOfAlbums(@PathVariable("albumId") Long albumId){
		
		return ResponseEntity.ok(userService.getPhotosByAlbumId(albumId));		
	}
	
	@RequestMapping(value = "users/{userId}/todos" ,method = RequestMethod.GET,produces = "application/json")
	public ResponseEntity<?> getAllTodosOfUsers(@PathVariable("userId") Long userId){
		
		
		return ResponseEntity.ok(userService.getTodoByUserId(userId));		
	}
	
	
	
	

}
