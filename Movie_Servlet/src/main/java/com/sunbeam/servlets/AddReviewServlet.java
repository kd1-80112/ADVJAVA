package com.sunbeam.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sunbeam.dao.MovieDao;
import com.sunbeam.dao.MovieDaoImpl2;
import com.sunbeam.pojo.Movie;
import com.sunbeam.pojo.User;
@WebServlet("/addreview")
public class AddReviewServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();

		HttpSession session=req.getSession();
		User user=(User)session.getAttribute("name");
	    System.out.println(user);
	    System.out.println(user.getId());
	    List<Movie> list = new ArrayList<Movie>();
	    
	    try(MovieDao moviesdao=new MovieDaoImpl2())
	    	{
	    	   list=moviesdao.findAll();
	    	   System.out.println(list);
	    	   out.println(list);
	    		out.println("<html>");
	          out.println("<head>");
	          out.println("<title>Add movie review</title>");
	          out.println("</head>");
	          out.println("<body>");
	          out.println("<form>");
	         out.println("<select name='movies'>");
	         out.println("</body>");
	         out.println("</html>");
	    	
	    	} catch (Exception e) {
					e.printStackTrace();
				}
	    
//	   	out.println("<html>");
//        out.println("<head>");
//        out.println("<title>Add movie review</title>");
//        out.println("</head>");
//        out.println("<body>");
//        out.println("<h2>Select a Fruit:</h2>");
//        out.println("<form>");
//        out.println("<select name='movies'>");
//        
//        
//        out.printf("<option value=''>Apple</option>");
//        out.println("<option value='orange'>Orange</option>");
//        out.println("<option value='banana'>Banana</option>");
//        out.println("<option value='grape'>Grape</option>");
//        
//        out.println("</select>");
//        out.println("<br><br>");
//        out.println("<input type='submit' value='Submit'>");
//        out.println("</form>");
//        out.println("</body>");
//        out.println("</html>");
	    
	}
	}
	