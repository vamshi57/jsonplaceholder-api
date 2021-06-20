package com.vamshi.proj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.vamshi.proj.model.Address;
import com.vamshi.proj.model.Album;
import com.vamshi.proj.model.Comment;
import com.vamshi.proj.model.Company;
import com.vamshi.proj.model.Geo;
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

//@Component
public class MyCommandLine implements CommandLineRunner{
	
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
	public void run(String... args) throws Exception {
	//Post ps=postRepo.getById(3l);
// Comment cm=new Comment("dfasd", "dbasbd", "dashdh",ps ,ps.getUser());
	// comtRepo.save(cm);
	//User user=userRepo.getById(5l);
	
//	 Todo todo=new Todo("shdhjs", false,user );
//	 todoRepo.save(todo);
		
		
		
	
		//Album album=new Album("vassad", user);
		
		
	Album album=albumRepo.findById(11l).get();
	
	
	
	Photo photo=new Photo("sasjbdj", "sdvashj", "aavdasbjnkml", album);
	Photo photo1=new Photo("sasjbdjsjkbdkja", "sdvashj", "aavdasbjnkml", album);
	
	
			photoRepo.save(photo);
			photoRepo.save(photo1);
             
	
		
//	 
	 
	 
		
	}

}
