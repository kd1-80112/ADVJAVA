package com.sunbeam.beans;

import com.sunbeam.dao.UserDao;
import com.sunbeam.dao.UserDaoImpl;
import com.sunbeam.pojo.User;

public class LoginBean {
	private String email;
	private String password;
	private boolean status;
	public LoginBean() {
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
	public boolean getStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public void authenticate() {
		try(UserDao userDao = new UserDaoImpl()) {
			User user = userDao.findByEmail(email);
			if(user != null && user.getPassword().equals(password))
				status = true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}
}
