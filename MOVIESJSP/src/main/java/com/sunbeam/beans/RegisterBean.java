package com.sunbeam.beans;



import java.util.Date;

import com.sunbeam.dao.UserDao;
import com.sunbeam.dao.UserDaoImpl;
import com.sunbeam.pojo.DateUtil;
import com.sunbeam.pojo.User;

public class RegisterBean {
	
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String mobno;
	private String dob;
	private boolean status;
	

	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMobno() {
		return mobno;
	}
	public void setMobno(String mobno) {
		this.mobno = mobno;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public boolean getStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	public void saveuser()
	{
		try(UserDao userDao = new UserDaoImpl()) {
			Date date=DateUtil.parse(dob);
			User u=new User(0, firstName, lastName, email, password, mobno, date);
			System.out.println(u);
			int count = userDao.save(u);
			if(count != 0)
				setStatus(true);
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}

}