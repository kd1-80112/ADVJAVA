package com.sunbeam.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.sunbeam.pojo.DateUtil;
import com.sunbeam.pojo.Reviews;

public class ReviewDaoImpl extends Dao implements ReviewDao {

	public ReviewDaoImpl()  throws Exception {
		
	}

	@Override
	public int save(Reviews r) throws Exception {
		int cnt=0;
		String query = "insert into reviews values (default,?,?,?,?,now())";
		try(PreparedStatement stm = con.prepareStatement(query))
		{
			stm.setInt(1, r.getMid());
			stm.setString(2, r.getReview());
			stm.setInt(3,r.getRating());
			stm.setInt(4, r.getUser_id());
			cnt = stm.executeUpdate();			
			
		}catch(Exception e)
		{
			e.printStackTrace();
			
		}
		return cnt;
	}

	@Override
	public int update(Reviews r) throws Exception {
		
		int count =0;
	     
		String query= "update  reviews  set  movie_id=? , review=?,rating=?,user_id=?,modified=now() where id =? ";
		try(PreparedStatement stmt= con.prepareStatement(query)){
			stmt.setInt(1, r.getMid());
			stmt.setString(2, r.getReview());
			stmt.setInt(3, r.getRating());
			stmt.setInt(4, r.getUser_id());
		
			stmt.setInt(5, r.getId());
			
			 count = stmt.executeUpdate();
			 return count ;
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return count ;
	}

	@Override
	public List<Reviews> findAll() throws Exception {
		

		List<Reviews> list= new ArrayList<Reviews>();
		String query = "select * from reviews";
		try(PreparedStatement stmt = con.prepareStatement(query))
		{
			try(ResultSet rs=stmt.executeQuery())
			{
				while(rs.next())
					{		
					int id =rs.getInt("id");
					int movie_id= rs.getInt("movie_id");
					String review = rs.getString("review");
					int rating = rs.getInt("rating");
					int user_id=rs.getInt("user_id");
					java.sql.Timestamp mod= rs.getTimestamp("modified");
					Reviews r= new Reviews(id,movie_id,review,rating,user_id,mod);
					list.add(r);
				}
			}
		}
		
		
		return list ;
	}

	@Override
	public List<Reviews> findByUserId(int userId) throws Exception {
		
		
		List<Reviews> list = new ArrayList<Reviews>();
		String query= "select * from reviews where user_id=?";
		try(PreparedStatement stm = con.prepareStatement(query))
		{
			stm.setInt(1, userId);
			try(ResultSet rs= stm.executeQuery())
			{
				while(rs.next())
				{
					int id =rs.getInt("id");
					int movie_id= rs.getInt("movie_id");
					String review = rs.getString("review");
					int rating = rs.getInt("rating");
					int user_id=rs.getInt("user_id");
					java.sql.Timestamp mod= rs.getTimestamp("modified");
					Reviews r= new Reviews(id,movie_id,review,rating,user_id,mod);
					list.add(r);
					
				}
				
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Reviews> getSharedWithUser(int userId) throws Exception {

		return null;
	}

	@Override
	public Reviews findById(int id) throws Exception {
		
		Reviews r=null;
		
		String query= "select * from reviews where id=?";
		try(PreparedStatement stm = con.prepareStatement(query))
		{
			stm.setInt(1, id);
			try(ResultSet rs= stm.executeQuery())
			{
				while(rs.next())
				{
					int Id =rs.getInt("id");
					int movie_id= rs.getInt("movie_id");
					String review = rs.getString("review");
					int rating = rs.getInt("rating");
					int user_id=rs.getInt("user_id");
					java.sql.Timestamp mod= rs.getTimestamp("modified");
					 r= new Reviews(Id,movie_id,review,rating,user_id,mod);
					
				}
				
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return r;
		
	}

	@Override
	public int deleteById(int reviewId) throws Exception {
		
		int count =0;
	     
		String query= "delete from reviews where id=?";
		try(PreparedStatement stmt= con.prepareStatement(query)){
			stmt.setInt(1, reviewId);
			
			 count = stmt.executeUpdate();
			 return count ;
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return count ;
		
	}

	@Override
	public int shareReview(int reviewId, int userId) throws Exception {
		
		return 0;
	}

}
