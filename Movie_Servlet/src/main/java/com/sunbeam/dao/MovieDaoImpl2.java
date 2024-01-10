package com.sunbeam.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.sunbeam.pojo.DateUtil;
import com.sunbeam.pojo.DbUtil;
import com.sunbeam.pojo.Movie;

public class MovieDaoImpl2 extends Dao implements MovieDao 
{
	public MovieDaoImpl2() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public List<Movie> findAll() throws Exception
	{
		List<Movie> list = new ArrayList<Movie>();
		String query= "select * from movies";
		try(PreparedStatement stmt = con.prepareStatement(query))
		{
			try(ResultSet rs=stmt.executeQuery())
			{
				while(rs.next())
				{
					int id = rs.getInt("id");
					String title = rs.getString("title");
					java.sql.Date sDate=rs.getDate("rel_date");
					System.out.println(sDate);
					java.util.Date udate = DateUtil.sqlToUtilDate(sDate);
					System.out.println(udate);
					Movie m = new Movie(id,title,udate);
					list.add(m);
				}
			}//rs.close
			
		}//stmt.close
				
		
		
		return list;
		
	}
	 public Movie findById(int id) throws Exception
	 {
		 Movie m= null ;
		 
		 String query = "select * from movies where id=?";
		 try(PreparedStatement stmt = con.prepareStatement(query)){
			 stmt.setInt(1, id);
			 try(ResultSet rs = stmt.executeQuery())
			 {
				 while (rs.next())
				 {
					 int mid = rs.getInt("id");
					 String title = rs.getString("title");
					 java.sql.Date sdate = rs.getDate("release_date");
					 java.util.Date udate= DateUtil.sqlToUtilDate(sdate);
					 m = new Movie(mid,title,udate);
				 }
			 }
		 }
		 
		 
		 
		 return  m ;
	 }
		
	}
	

