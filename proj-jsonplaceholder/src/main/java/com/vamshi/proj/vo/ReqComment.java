package com.vamshi.proj.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class ReqComment {
	
	private Long postId;
	@NonNull
	private Long id;
	@NonNull
	private String name;
	@NonNull
	private String body;
	
	
	
	

//	  {
//	    "postId": 1,
//	    "id": 1,
//	    "name": "id labore ex et quam laborum",
//	    "email": "Eliseo@gardner.biz",
//	    "body": "laudantium enim quasi est quidem magnam voluptate ipsam eos\ntempora quo necessitatibus\ndolor quam autem quasi\nreiciendis et nam sapiente accusantium"
//	  },
}
