package com.sunbeam.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.sunbeam.pojo.DateUtil;
import com.sunbeam.pojo.DbUtil;
import com.sunbeam.pojo.Movie;

public interface MovieDao extends AutoCloseable {
	public List<Movie> findAll() throws Exception;
	 public Movie findById(int id) throws Exception;
	
}


