package com.vamshi.proj.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@RequiredArgsConstructor
@Table(name = "users")
public class User {
	
	@Id
	@Column(name="user_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
   
	@NonNull
    private String name;
  @NonNull
    private String username;
    @NonNull
    private String email;
 
   @Embedded()
  @NonNull
     private Address address;
   @NonNull
    private String phone;
 @NonNull
    private String website;
 
   @Embedded()
   @NonNull
   private Company company;
   
    
    @OneToMany(mappedBy = "user",
    		cascade = CascadeType.ALL,
    		orphanRemoval = true)
	private List<Post> posts =new ArrayList<Post>();
    
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Comment> comments =new ArrayList<Comment>();
    
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Album> albums=new ArrayList<Album>();


	@OneToMany(mappedBy = "user",  cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Todo> todos=new ArrayList<Todo>();
	
	
	
     
}
