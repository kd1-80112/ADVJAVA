package com.sunbeam.pojo;

import java.sql.Timestamp;

public class Reviews {
	private int id ;
	private int mid;
	private  String review;
	private int rating ;
	private int user_id;
	private java.sql.Timestamp modified;
	
	public Reviews() {
		// TODO Auto-generated constructor stub
	}

	public Reviews(int id, int mid, String review, int rating, int user_id, Timestamp modified) {
		super();
		this.id = id;
		this.mid = mid;
		this.review = review;
		this.rating = rating;
		this.user_id = user_id;
		this.modified = modified;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMid() {
		return mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public java.sql.Timestamp getModified() {
		return modified;
	}

	public void setModified(java.sql.Timestamp modified) {
		this.modified = modified;
	}

	@Override
	public String toString() {
		return "Reviews [id=" + id + ", mid=" + mid + ", review=" + review + ", rating=" + rating + ", user_id="
				+ user_id + ", modified=" + modified + "]";
	}
	
	
}
