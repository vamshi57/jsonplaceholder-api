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
public class ResComment {
	
	private Long postId;
	@NonNull
	private Long id;
	@NonNull
	private String name;
	@NonNull
	private String body;
	
	
	
	
}