package com.vamshi.proj.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.vamshi.proj.model.Comment;
import com.vamshi.proj.vo.ReqPost;
import com.vamshi.proj.vo.ResComment;
import com.vamshi.proj.vo.ResPost;

@Service
public interface PostService {
	
	
   List<ResPost> getAllPost();
   ResPost createPost(ReqPost post);
   ResPost getByPostId(Long id);
   List<ResComment> getCommentsByPostId(Long id);
   Boolean deletePostById(Long postId);
   ResPost updatePost(Long postId,ReqPost reqpost);
   
	

}
