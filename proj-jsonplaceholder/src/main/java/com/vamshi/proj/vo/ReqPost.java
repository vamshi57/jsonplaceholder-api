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
public class ReqPost {

	private Long userId;
	@NonNull
	private Long id;
	@NonNull
	private String title;
	@NonNull
	private String body;
	
}
