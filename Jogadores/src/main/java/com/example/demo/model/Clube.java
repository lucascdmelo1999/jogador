package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Clube {
	
	@Id @GeneratedValue
	private Integer id;
	@NotBlank
	private String nomedoclub;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNomedoclub() {
		return nomedoclub;
	}
	public void setNomedoclub(String nomedoclub) {
		this.nomedoclub = nomedoclub;
	}

	
}