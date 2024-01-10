package com.sunbeam.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.sunbeam.pojo.Reviews;
import com.sunbeam.pojo.Shared;

public interface SharedDao extends AutoCloseable{
	public List<Shared> getSharedWithUser(int userId) throws Exception;

}
