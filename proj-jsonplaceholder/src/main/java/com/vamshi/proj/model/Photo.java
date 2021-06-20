package com.vamshi.proj.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@Entity
@Table(name = "photos")
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Photo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NonNull
	private String title;
	@NonNull
	private String url;
	@NonNull
	private String thumbnailUrl;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "album_id")
	@NonNull
	private Album album;
}
