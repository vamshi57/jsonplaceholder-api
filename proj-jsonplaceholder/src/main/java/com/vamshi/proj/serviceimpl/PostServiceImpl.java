package com.vamshi.proj.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.vamshi.proj.exception.ResourceNotFoundException;
import com.vamshi.proj.model.Comment;
import com.vamshi.proj.model.Post;
import com.vamshi.proj.repo.CommentRepo;
import com.vamshi.proj.repo.PostRepo;
import com.vamshi.proj.repo.UserRepo;
import com.vamshi.proj.service.PostService;
import com.vamshi.proj.vo.ReqPost;
import com.vamshi.proj.vo.ResComment;
import com.vamshi.proj.vo.ResPost;

@Service
public class PostServiceImpl implements PostService{

	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private PostRepo postRepo;
	
	@Autowired
	private CommentRepo comRepo;
	
	@Override
	public List<ResPost> getAllPost(){
		
		List<Post> posts = postRepo.findAll();
		
		List<ResPost> listResPost=new ArrayList<ResPost>();
		
		for (Post post: posts) {
			ResPost resPost=new ResPost();
				resPost.setId(post.getId());
			    resPost.setTitle(post.body);
			    resPost.setBody(post.getBody());
			    if(post.getUser()!=null) {
			    	 resPost.setUserId(post.getUser().getUserId());	
			    }
			   
			    listResPost.add(resPost);
		    }
		
		return listResPost;
	}
	
	@Override
	public ResPost createPost(ReqPost post) {
	userRepo.findById(post.getUserId()).orElseThrow(
				()->new ResourceNotFoundException("user", "id", post.getUserId()));
	
		Post postInsert=new Post(post.getTitle(), post.getBody());
		postInsert.setUser(userRepo.getById(post.getUserId()));
		
		Post postgot=postRepo.save(postInsert);
		
		
		return new ResPost(postgot.getUser().getUserId(), postgot.id, postgot.getTitle(), postgot.getBody());
		
			
	}
	
	@Override
	public ResPost getByPostId(Long id) {
	 Post post=	postRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("post", "id", id));
	          userRepo.findById(post.getUser().getUserId()).orElseThrow(
	        		  ()->new ResourceNotFoundException("user", "id", post.getUser().getUserId()));
	 ResPost resPost=new ResPost(post.getUser().getUserId(), post.getId(), post.getTitle(), post.getBody());
		
		return resPost;
	}
	
	@Override
	public List<ResComment> getCommentsByPostId(Long postId) {
		Post post=postRepo.findById(postId).orElseThrow(()->new ResourceNotFoundException("post", "id", postId));
		  if(post.getComments()==null) {
			  throw new ResourceNotFoundException("comment", "id", post.getId());
		  }
				  
		  List<Comment> listComt=comRepo.findByPostId(postId);
		  List<ResComment> reslist=new ArrayList<ResComment>();
		 
		  for (Comment comment : listComt) {
			  ResComment res=new ResComment(
					  (comment.getPost()!=null)?comment.getPost().getId():null, 
							  comment.getId(), comment.getName(), comment.getBody());
			    reslist.add(res);
		  }
		 
		return reslist;
	}
	
	@Override
	public Boolean deletePostById(Long postId) {
		boolean result=false;
			try {
	           postRepo.deleteById(postId);
	           result=true;
			}catch (EmptyResultDataAccessException eRData) {
				result=false;
			}
		return result;
	}
	
	@Override
	public ResPost updatePost(Long postId, ReqPost reqpost) {
        Post post=postRepo.findById(postId).orElseThrow(
        		()->new ResourceNotFoundException("post", "id", postId));
         ResPost resPost;
             try {
            	  post.setBody(reqpost.getBody());
         		 post.setTitle(reqpost.getTitle());
         		post=postRepo.save(post);
         		  resPost=new ResPost(post.getUser().getUserId(),post.getId(), post.getTitle(),post.getBody());
         		 
             }catch (NullPointerException ex) {
            	 throw new ResourceNotFoundException("post", "id", postId);
			}
		return resPost;
	}
	
	
	
	
	
	
	
}
