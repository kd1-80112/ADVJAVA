package com.sunbeam.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.sunbeam.pojo.Reviews;
import com.sunbeam.pojo.Shared;

public class SharedDaoImpl extends Dao implements SharedDao{
	protected SharedDaoImpl() throws Exception {
		
	}

	public List<Shared> getSharedWithUser(int userId) throws Exception {
		List<Shared> list = new ArrayList<Shared>();
		String query= "select * from shares where user_id=?";
		try(PreparedStatement stm = con.prepareStatement(query))
		{
			stm.setInt(1, userId);
			try(ResultSet rs= stm.executeQuery())
			{
				while(rs.next())
				{
					int review_id =rs.getInt("review_id");
					int user_id=rs.getInt("user_id");
					Shared s= new Shared(review_id,user_id);
					list.add(s);
					
				}
				
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}
}
