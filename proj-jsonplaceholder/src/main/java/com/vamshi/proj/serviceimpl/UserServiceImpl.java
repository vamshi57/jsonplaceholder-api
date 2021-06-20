package com.vamshi.proj.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vamshi.proj.exception.ResourceNotFoundException;
import com.vamshi.proj.model.Album;
import com.vamshi.proj.model.Photo;
import com.vamshi.proj.model.Post;
import com.vamshi.proj.model.Todo;
import com.vamshi.proj.model.User;
import com.vamshi.proj.repo.AlbumRepo;
import com.vamshi.proj.repo.CommentRepo;
import com.vamshi.proj.repo.PhotoRepo;
import com.vamshi.proj.repo.PostRepo;
import com.vamshi.proj.repo.TodoRepo;
import com.vamshi.proj.repo.UserRepo;
import com.vamshi.proj.service.UserService;
import com.vamshi.proj.vo.ResAlbum;
import com.vamshi.proj.vo.ResPhoto;
import com.vamshi.proj.vo.ResPost;
import com.vamshi.proj.vo.ResTodo;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private PostRepo postRepo;
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private PostRepo PostRepo;
	
	@Autowired
	private CommentRepo comtRepo;
	
	
	@Autowired
	private AlbumRepo albumRepo;
	
	@Autowired
	private PhotoRepo photoRepo;
	
	@Autowired
	private TodoRepo todoRepo;
	
	
	
	@Override
	public List<ResPost> getPostsByUserId(Long userId) {
		User user =userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User", "UserId", userId));
		List<Post> listPost=user.getPosts();
		List<ResPost> listRePost=new ArrayList<ResPost>();
		
		for(Post post:listPost) {
			if (post.getId()!=null){
				ResPost resPost=new ResPost();
				resPost.setId(post.getId());
				resPost.setTitle(post.getTitle());
				resPost.setBody(post.getBody());
				resPost.setUserId(post.getUser().getUserId());
				listRePost.add(resPost);
			}
		}
		return listRePost;
	}
	
	@Override
	public List<ResAlbum> getAlbumsByUserId(Long userId) {
		User user =userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User", "UserId", userId));
		List<Album> listAlbums=user.getAlbums();
		List<ResAlbum> listReAlbums=new ArrayList<ResAlbum>();
		
		for(Album album:listAlbums) {
			if (album.getId()!=null){
				ResAlbum resAlbum=new ResAlbum();
				resAlbum.setId(album.getId());
				resAlbum.setTitle(album.getTitle());
				resAlbum.setUserId(album.getUser().getUserId());
				listReAlbums.add(resAlbum);
			}
		}
		return listReAlbums;
	}
	
	@Override
	public List<ResPhoto> getPhotosByAlbumId(Long albumId) {
		Album album=albumRepo.findById(albumId).orElseThrow(()->new ResourceNotFoundException("Album", "AlbumId", albumId));
		List<Photo> listPhotos=album.getPhoto();
		List<ResPhoto> listResPhotos=new ArrayList<ResPhoto>();
		for (Photo photo:listPhotos) {
			if(photo.getId()!=null) {
				ResPhoto resPhoto=new ResPhoto();
				resPhoto.setAlbumId(photo.getAlbum().getId());
				resPhoto.setId(photo.getId());
				resPhoto.setThumbnailUrl(photo.getThumbnailUrl());
				resPhoto.setTitle(photo.getTitle());
				resPhoto.setUrl(photo.getUrl());
				
				listResPhotos.add(resPhoto);
				
			}
		}
		
		return listResPhotos;
	}
	
	@Override
	public List<ResTodo> getTodoByUserId(Long userId) {
		User user =userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User", "UserId", userId));
	   List<Todo> listTodos=user.getTodos();
	   List<ResTodo> listResTodos=new ArrayList<ResTodo>();
	   
	   for (Todo todo : listTodos) { 
		   if(todo.getId()!=null) {
			   ResTodo resTodo=new ResTodo(todo.getUser().getUserId(),
					   todo.getId(),
					   todo.getTitle(),
					   todo.getCompleted());
			   listResTodos.add(resTodo);   
		   }
	      }
	   
	
	
		
		
		return listResTodos;
	}
	
	
	

}
