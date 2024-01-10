package com.sunbeam.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sunbeam.dao.*;
import com.sunbeam.dao.UserDaoImpl;
import com.sunbeam.pojo.*;


@WebServlet("/login")
public class LoginServlet  extends HttpServlet{
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email=req.getParameter("email");
		String password= req.getParameter("password");
		System.out.println(email +" "+password );
		
		try(UserDao userdao= new UserDaoImpl())
		{
			User u = userdao.findByEmail(email);
			System.out.println(u+"    Found");
			
			if(u !=null && u.getPassword().equals(password))
			{
				
				HttpSession session = req.getSession();
				session.setAttribute("name",u);
				resp.sendRedirect("reviews"); 
				
				
			}else {
				resp.setContentType("text/html");
				PrintWriter out = resp.getWriter();
				out.println("<html>");
				out.println("<head>");
				out.println("<title>Login Failed</title>");
				out.println("</head>");
				out.println("<body>");
				out.println("<h5>Invalid email or password</h5>");
				out.println("<a href='index.html'>Login Again</a>");
				out.println("</body>");
				out.println("</html>");	
			}
			
		}catch(Exception e)
		{
			e.printStackTrace();
			throw new ServletException(e);
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		doPost(req, resp);
	}
	

}
