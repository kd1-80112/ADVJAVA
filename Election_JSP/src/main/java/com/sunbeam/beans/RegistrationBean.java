package com.sunbeam.beans;

import java.sql.Date;

import com.sunbeam.daos.UserDao;
import com.sunbeam.daos.UserDaoImpl;
import com.sunbeam.pojos.User;

public class RegistrationBean {
	private String firstName;
	private String lastName;
    private String email;
    private String password;
    private String birth;
    private String role;
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
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public boolean getStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}

	public void saveuser()
	{
		try(UserDao userdao=new UserDaoImpl()) {
			Date dob = Date.valueOf(birth);
			User u=new User(0,firstName,lastName,email,password,dob,0,role);
			int count=userdao.save(u);
			System.out.println(u);
			if(count!=0)
			{
				this.setStatus(true);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	}
