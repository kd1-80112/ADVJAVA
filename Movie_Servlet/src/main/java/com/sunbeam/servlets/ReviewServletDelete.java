package com.sunbeam.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunbeam.dao.ReviewDao;
import com.sunbeam.dao.ReviewDaoImpl;

@WebServlet("/revdel")
public class ReviewServletDelete extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String rid= req.getParameter("id");
		int id = Integer.parseInt(rid);
		int cnt =0;
		try(ReviewDao reviewdao = new ReviewDaoImpl())
		{
			cnt = reviewdao.deleteById(id);
			
		}catch(Exception e)
		{
			e.printStackTrace();
			throw new ServletException(e);
		}
		RequestDispatcher rd= req.getRequestDispatcher("reviews");
		rd.forward(req, resp);
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
