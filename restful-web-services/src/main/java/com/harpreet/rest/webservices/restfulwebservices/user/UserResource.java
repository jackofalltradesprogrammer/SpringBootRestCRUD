package com.harpreet.rest.webservices.restfulwebservices.user;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserResource {

	@Autowired
	private UserDaoService service;

	// GET /users
	// retrieve all Users
	@GetMapping("/users")
	public List<User> retrieveAllUsers() {
		return service.findAll();
	}

	// retrieve User with it
	@GetMapping("/users/{id}")
	public User retrieveUser(@PathVariable int id) {
		User user = service.findOne(id);
		if(user == null) 
			throw new UserNotFoundException("id - " + id);
		return user;
	}

	// input - details of user
	// output - CREATE & Return the created URI
	@PostMapping("/users")
	public ResponseEntity<Object> createUser(@RequestBody User user) {
		// @RequestBody tries to map whatever is coming in request to User
		User savedUser = service.save(user);
		// CREATED - Return the status code with URI
		// /users/{id}    savedUser.getId()
		// to get current URI use ServletUriComponentsBuilder
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@GetMapping("/users/{userId}/posts")
	public List<Post> retrievePosts(@PathVariable int userId) {
		List<Post> posts = service.findAllPosts(userId);
		return posts;
	}
	
	@GetMapping("/users/{id}/posts/{post_id}")
	public Post retrieveUser(@PathVariable("id") int userId, @PathVariable int post_id) {
		Post post = service.findPost(userId, post_id);
		
		return post;
	}
	
	@PostMapping("/users/{id}/posts")
	public ResponseEntity<Object> createPost(@RequestBody Post post, @PathVariable ("id") int userId) {
		// @RequestBody tries to map whatever is coming in request to User
		Post savedPost = service.savePost(post, userId);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("users/{"+savedPost.getUserId()+"}").buildAndExpand(savedPost.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	
	
}
