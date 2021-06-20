package com.vamshi.proj.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vamshi.proj.model.Comment;
import com.vamshi.proj.model.Post;
import com.vamshi.proj.model.User;
import com.vamshi.proj.repo.PostRepo;
import com.vamshi.proj.repo.UserRepo;
import com.vamshi.proj.service.PostService;
import com.vamshi.proj.vo.ReqPost;
import com.vamshi.proj.vo.ResComment;
import com.vamshi.proj.vo.ResPost;

import net.bytebuddy.description.modifier.MethodArguments;

@RestController
@RequestMapping("/")
public class PostController {
	
	@Autowired
	private PostService postService;
	//posts getAll
	@RequestMapping(value = "posts" ,method = RequestMethod.GET,produces = "application/json")
	public ResponseEntity<?> getAllPost(){
		
		return ResponseEntity.ok(postService.getAllPost());		
	}
	//posts /POST
	@RequestMapping(value = "posts" ,method = RequestMethod.POST,produces = "application/json")
	public ResponseEntity<?> createPost(@RequestBody ReqPost reqPost) {
		
		return ResponseEntity.ok(postService.createPost(reqPost));
	}
	//posts/1
	@RequestMapping(value = "posts/{id}",method = RequestMethod.GET,produces = "application/json")
	public ResponseEntity<?> getPostById(@PathVariable("id") Long id) {
		
		
		return ResponseEntity.ok(postService.getByPostId(id));
	}
	//posts/1/comments
	@RequestMapping(value = "posts/{id}/comments",method = RequestMethod.GET,produces = "application/json")
	public ResponseEntity<?> getCommentsByPostId(@PathVariable("id") Long id){
		List<ResComment> listrescom=postService.getCommentsByPostId(id);
		return ResponseEntity.ok(listrescom);
	}
	
    ///comments?postId=102
	@RequestMapping(value = "/comments",method = RequestMethod.GET,produces = "application/json")
	public ResponseEntity<?> getCommentsByPostIdReqParam(@RequestParam("postId") Long id){
		List<ResComment> listrescom=postService.getCommentsByPostId(id);
		return ResponseEntity.ok(listrescom);
	}
     //posts/1 -DELETE
	@RequestMapping(value = "/posts/{id}",method = RequestMethod.DELETE,produces = "application/json")
	public ResponseEntity<?> deletePostById(@PathVariable("id") Long id){
	
		return ResponseEntity.ok(postService.deletePostById(id)?"successfull deleted":"resource not found");
	}
	//posts/1 -PUT,PAT
	@RequestMapping(value = "/posts/{id}",method = {RequestMethod.PUT,RequestMethod.PATCH},produces = "application/json")
	public ResponseEntity<?> updatePost(@PathVariable("id") Long id,@RequestBody ReqPost reqPost){
		return ResponseEntity.accepted().body(postService.updatePost(id, reqPost));
	}
	
	
	
}
