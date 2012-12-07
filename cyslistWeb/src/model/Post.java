package model;

import java.util.Date;

/**
 * 
 * @author James Sampica
 * The internal class for Post that gets saved to the database
 */
public class Post implements Comparable<Post>{
	
	private long postId;
	private String content;
	private String topic;
	private Date date;
	private String title;
	private String postKey;
	private String email;
	private String imageExt;
	private boolean isFlag;
	
	/**
	 * class constructor
	 */
	public Post(){
		
	}
	
	/**
	 * 
	 * @return hibernate objectid
	 */
	public long getPostId(){
		return postId;
	}
	
	/**
	 * 
	 * @param postId hibernate objectid
	 */
	public void setPostId(long postId){
		this.postId = postId;
	}
	
	/**
	 * 
	 * @return post content
	 */
	public String getContent(){
		return content;
	}
	
	/**
	 * 
	 * @param content post content
	 */
	public void setContent(String content){
		this.content = content;
	}
	
	/**
	 * 
	 * @return post topic
	 */
	public String getTopic(){
		return topic;
	}
	
	/**
	 * 
	 * @param topic post topic
	 */
	public void setTopic(String topic){
		this.topic = topic;
	}
	
	/**
	 * 
	 * @return post date
	 */
	public Date getDate(){
		return date;
	}
	
	/**
	 * 
	 * @param date post date
	 */
	public void setDate(Date date){
		this.date = date;
	}
	
	/**
	 * 
	 * @return post title
	 */
	public String getTitle(){
		return title;
	}
	
	/**
	 * 
	 * @param title post title
	 */
	public void setTitle(String title){
		this.title = title;
	}
	
	/**
	 * 
	 * @return key that represents this post
	 */
	public String getPostKey(){
		return postKey;
	}
	
	/**
	 * 
	 * @param postKey key that represents this post
	 */
	public void setPostKey(String postKey){
		this.postKey = postKey;
	}
	
	/**
	 * 
	 * @return post email
	 */
	public String getEmail(){
		return email;
	}
	
	/**
	 * 
	 * @param email post email
	 */
	public void setEmail(String email){
		this.email = email;
	}
	
	public String getImageExt(){
		return imageExt;
	}
	
	public void setImageExt(String imageExt){
		this.imageExt = imageExt;
	}
	
	public boolean getIsFlag() {
		return isFlag;
	}

	public void setIsFlag(boolean isFlag) {
		this.isFlag = isFlag;
	}

	@Override
	public int compareTo(Post arg0) {
		if(arg0.date.after(date)){
			return 1;
		}
		else if(arg0.date.before(date)){
			return -1;
		}
		return 0;
	}
}
