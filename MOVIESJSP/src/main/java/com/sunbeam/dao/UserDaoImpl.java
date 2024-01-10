package com.sunbeam.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.sunbeam.pojo.DateUtil;
import com.sunbeam.pojo.User;

public class UserDaoImpl  extends Dao implements UserDao{

	public UserDaoImpl() throws Exception {
	}

	@Override
	public int save(User u) throws Exception {
		int count=0;
		String query= "insert into users values (default,?,?,?,?,?,?)";
		try(PreparedStatement stmt= con.prepareStatement(query)){
			stmt.setString(1, u.getFname());
			stmt.setString(2, u.getLname());
			stmt.setString(3, u.getEmail());
			stmt.setString(6, u.getPassword());
			stmt.setString(4, u.getMobno());
			java.sql.Date sdate= DateUtil.utilToSqlDate(u.getDob());
			stmt.setDate(5, sdate);
			 count = stmt.executeUpdate();
			 return count ;
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return count ;
	}

	@Override
	public int update(User u) throws Exception {
		int count =0;
     
		String query= "update  users  set  f_name=? , l_name=?,email=?,password=?,mobile=?,dob=? where id =? ";
		try(PreparedStatement stmt= con.prepareStatement(query)){
			stmt.setString(1, u.getFname());
			stmt.setString(2, u.getLname());
			stmt.setString(3, u.getEmail());
			stmt.setString(4, u.getPassword());
			stmt.setString(5, u.getMobno());
			java.sql.Date sdate= DateUtil.utilToSqlDate(u.getDob());
			stmt.setDate(6, sdate);
			stmt.setInt(7, u.getId());
			
			 count = stmt.executeUpdate();
			 return count ;
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return count ;
	}

	@Override
	public int updatePassword(int userId, String newPassword) throws Exception {
		
		int count =0;
	     
		String query= "update  users  set  password=? where id =? ";
		try(PreparedStatement stmt= con.prepareStatement(query)){
			stmt.setString(1, newPassword);
			stmt.setInt(2,userId);
			System.out.println(stmt);
			
			 count = stmt.executeUpdate();
			 return count ;
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return count ;
	}

	@Override
	public User findByEmail(String email) throws Exception {
		User u =null;
		String query = "select * from users where email=?";
		try(PreparedStatement stmt= con.prepareStatement(query))
		{
			stmt.setString(1, email);
			try(ResultSet rs = stmt.executeQuery()){
				while (rs.next())
				{
					int id = rs.getInt("id");
					String fname = rs.getString("first_name");
					String lname = rs.getString("last_name");
					String nemail= rs.getString("email");
					String password = rs.getString("password");
					String mobno = rs.getString("mobile");
					java.sql.Date sdate= rs.getDate("birth");
					java.util.Date udate= DateUtil.sqlToUtilDate(sdate);
					u = new User(id,fname,lname,nemail,password,mobno, udate);
					
				}
				
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		return u;
	}

	@Override
	public List<User> findAll() throws Exception {
		List <User>list = new ArrayList<User>();
		String query = "select * from users";
		try(PreparedStatement stmt= con.prepareStatement(query))
		{
			try(ResultSet rs = stmt.executeQuery()){
				while (rs.next())
				{
					int id = rs.getInt("id");
					String fname = rs.getString("f_name");
					String lname = rs.getString("l_name");
					String nemail= rs.getString("email");
					String password = rs.getString("password");
					String mobno = rs.getString("mobile");
					java.sql.Date sdate= rs.getDate("dob");
					java.util.Date udate= DateUtil.sqlToUtilDate(sdate);
					 User u = new User(id,fname,lname,nemail,password,mobno, udate);
					 list.add(u);
					
				}
				
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return list;
	}

}
