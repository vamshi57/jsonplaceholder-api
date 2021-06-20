package com.vamshi.proj.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReqTodo {
	
	
	private Long userId;
	private Long id;
	private String title;
	private Boolean completed;
	
	
//	
//
//	  {
//	    "userId": 1,
//	    "id": 1,
//	    "title": "delectus aut autem",
//	    "completed": false
//	  },

}
