package com.vamshi.proj.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.NonFinal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class ResPost {

	private Long userId;
	@NonNull
	private Long id;
	@NonNull
	private String title;
	@NonNull
	private String body;
	
	
	
//    "userId": 1,
//    "id": 1,
//    "title": "sunt aut facere repellat provident occaecati excepturi optio reprehenderit",
//    "body": "quia et suscipit\nsu;
}
