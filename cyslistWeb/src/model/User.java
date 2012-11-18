package model;

import java.util.HashSet;

public class User {
	long userId;
	String name;
	String password;
	int rating;
	HashSet<Post> posts;
	
	public User(){
		posts = new HashSet<Post>();
	}
	
	public long getUserId(){
		return userId;
	}
	public void setUserId(long userId){
		this.userId = userId;
	}
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name = name;
	}
	public String getPassword(){
		return password;
	}
	public void setPassword(String password){
		this.password = password;
	}
	public int getRating(){
		return rating;
	}
	public void setRating(int rating){
		this.rating = rating;
	}
	public HashSet<Post> getPosts(){
		return posts;
	}
	public void setPosts(HashSet<Post> posts){
		this.posts = posts;
	}
}
