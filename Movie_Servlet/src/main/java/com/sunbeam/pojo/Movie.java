package com.sunbeam.pojo;

import java.util.Date;

public class Movie {
	private  int id ;
	private String title;
	private java.util.Date releaseDate;

	
	public Movie(int id, String title, Date releaseDate) {
		super();
		this.id = id;
		this.title = title;
		this.releaseDate = releaseDate;
	}


	public Movie() {
		// TODO Auto-generated constructor stub
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public java.util.Date getReleaseDate() {
		return releaseDate;
	}


	public void setReleaseDate(java.util.Date releaseDate) {
		this.releaseDate = releaseDate;
	}


	@Override
	public String toString() {
		return "Movie [id=" + id + ", title=" + title + ", releaseDate=" + releaseDate + "]";
	}

	
	
	
}
