package com.example.mongodbdemo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Document("information")
@ApiModel(description="Information of a person")
public class Information {
	
	@Id
	@ApiModelProperty(notes="distinct id of the person")
	private String id;
	@Field(name="customerName")
	@Indexed(unique=true)
	@ApiModelProperty(notes="name of the person")
	private String name;
	@ApiModelProperty(notes="mobile number of the person")
	private long mobile;
	@ApiModelProperty(notes="email id of the person")
	private String email;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	

}
