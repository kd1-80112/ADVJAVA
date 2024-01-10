package com.sunbeam.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunbeam.dao.UserDao;
import com.sunbeam.dao.UserDaoImpl;
import com.sunbeam.pojo.DateUtil;
import com.sunbeam.pojo.User;

@WebServlet("/register")
public class AddUserServlet extends HttpServlet {
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String fname = req.getParameter("fname");
		String lname=req.getParameter("lname");
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		String mobno=req.getParameter("mobno");
		String dob =req.getParameter("dob");
		java.util.Date udate = DateUtil.parse(dob);
		int cnt=0;
		User u = new User(0, fname,lname,email,password,mobno,udate);
		try(UserDao userdao = new UserDaoImpl())
		{
			cnt = userdao.save(u);
			
		}catch(Exception e)
		{
			e.printStackTrace();
			throw new ServletException(e);
		}
		RequestDispatcher rd = req.getRequestDispatcher("index.html");
		rd.forward(req, resp);
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

}
