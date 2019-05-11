package com.harpreet.rest.webservices.restfulwebservices.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
	private static List<User> users = new ArrayList<>();
	private static List<Post> posts = new ArrayList<>();
	private static int usersCount = 3;
	private static int postsCount = 3;
	
	static {
		users.add(new User(1, "Adam", new Date()));
		users.add(new User(2, "Eve", new Date()));
		users.add(new User(3, "Jack", new Date()));
		posts.add(new Post(1, "happy", "sdfasdfadfas", 1));
		posts.add(new Post(2, "this sucks", "sdfasdfadfas", 1));
		posts.add(new Post(3, "I'm awesome", "sdfasdfadfas", 2));
		
	}
	
	 public List<User> findAll() {
		 return users;
	 }
	 
	 public User save(User user) {
		 if(user.getId() == null) {
			 user.setId(++usersCount);
		 }
		 users.add(user);
		 return user;
	 }
	 
	 public User findOne(int id) {
		 for (User user : users) {
			if(user.getId()==id) {
				return user;
			}
		}
		 return null;
	 }
	 
	 public User delteById(int id) {
		 Iterator<User> iterator = users.iterator();
		 while (iterator.hasNext()) {
			 User user = iterator.next();
			if(user.getId()==id) {
				iterator.remove();
				return user;
			}
		}
		 return null;
	 }

	public List<Post> findAllPosts(int userId) {
		List<Post> tempPosts = new ArrayList<Post>();
		for (Post post : posts) {
			if(post.getUserId()==userId) {
				tempPosts.add(post);
			}
		}
		 return tempPosts;
	}

	public Post findPost(int userId, int post_id) {
		// TODO Auto-generated method stub
		for (Post post : posts) {
			if(post.getUserId()==userId && post.getId() == post_id) {
				return post;
			}
	}
		return null;
}

	public Post savePost(Post post, int userId) {
		if(post.getId() == null) {
			 post.setId(++postsCount);
			 post.setUserId(userId);
		 }
		 posts.add(post);
		 return post;
	}
}
