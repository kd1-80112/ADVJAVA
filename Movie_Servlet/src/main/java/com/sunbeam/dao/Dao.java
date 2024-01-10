package com.sunbeam.dao;

import java.sql.Connection;
import java.util.ArrayList;

import com.sunbeam.pojo.DbUtil;
import com.sunbeam.pojo.Reviews;

public class Dao implements AutoCloseable  {
	
protected Connection con;
	
	protected Dao() throws Exception {
		con = DbUtil.getConnection();
	}

	@Override
	public void close() throws Exception {
			try {
				if(con!=null)
					con.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
	}

	
}
