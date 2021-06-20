package com.vamshi.proj.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class ResAlbum {
	
	
	private Long userId;
	@NonNull
	private Long id;
	@NonNull
	private String title;
	
	
//	
//	{
//	    "userId": 1,
//	    "id": 1,
//	    "title": "quidem molestiae enim"
//	  },


}
