package com.harpreet.rest.webservices.restfulwebservices.user;

import java.util.Date;

public class User {
	
	private Integer id;
	private String name;
	private Date birthDate;

	public User(Integer id, String name, Date birthDate) {
		super();
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
	}

	public final Integer getId() {
		return id;
	}
	public final String getName() {
		return name;
	}
	public final Date getBirthDate() {
		return birthDate;
	}
	public final void setId(Integer id) {
		this.id = id;
	}
	public final void setName(String name) {
		this.name = name;
	}
	public final void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", birthDate=" + birthDate + "]";
	}
	
	
}
