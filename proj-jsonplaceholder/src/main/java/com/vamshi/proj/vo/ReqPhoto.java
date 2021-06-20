package com.vamshi.proj.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class ReqPhoto {
	
	private Long albumId;
	@NonNull
	private Long id;
	@NonNull
	private String title;
	@NonNull
	private String url;
	@NonNull
	private String thumbnailUrl;
	

	
//
//	
//	"albumId": 1,
//    "id": 1,
//    "title": "accusamus beatae ad facilis cum similique qui sunt",
//    "url": "https://via.placeholder.com/600/92c952",
//    "thumbnailUrl": "https://via.placeholder.com/150/92c952"
}
