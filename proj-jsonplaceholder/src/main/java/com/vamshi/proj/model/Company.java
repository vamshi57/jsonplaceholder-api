package com.vamshi.proj.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

@Embeddable
public class Company {
	   @Column(name = "company_name")
	   private String name;
	    private String catchPhrase;
	    private String bs;

}
