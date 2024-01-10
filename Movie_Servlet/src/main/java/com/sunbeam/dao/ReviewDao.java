package com.sunbeam.dao;

import java.util.ArrayList;
import java.util.List;

import com.sunbeam.pojo.*;

public interface ReviewDao  extends AutoCloseable {

	public int save(Reviews r) throws Exception;
	 public int update(Reviews r) throws Exception;
	 public List<Reviews> findAll() throws Exception;
	 public List<Reviews> findByUserId(int userId) throws Exception;
	 public Reviews findById(int id) throws Exception;
	 public int deleteById(int reviewId) throws Exception;
	 public ArrayList<Reviews> sharedWithMe(int userId) throws Exception;

}
