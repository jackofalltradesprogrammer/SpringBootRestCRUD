package com.harpreet.rest.webservices.restfulwebservices.user;

public class Post {
	
	private Integer id;
	private String title;
	private String body;
	private Integer userId;
	public Post(Integer id, String title, String body, Integer userId) {
		super();
		this.id = id;
		this.title = title;
		this.body = body;
		this.userId = userId;
	}
	public final Integer getId() {
		return id;
	}
	public final void setId(Integer id) {
		this.id = id;
	}
	public final String getTitle() {
		return title;
	}
	public final void setTitle(String title) {
		this.title = title;
	}
	public final String getBody() {
		return body;
	}
	public final void setBody(String body) {
		this.body = body;
	}
	public final Integer getUserId() {
		return userId;
	}
	public final void setUserId(Integer userId) {
		this.userId = userId;
	}
	
}
