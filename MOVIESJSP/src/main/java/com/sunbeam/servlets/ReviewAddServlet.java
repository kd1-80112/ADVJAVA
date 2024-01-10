package com.sunbeam.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sunbeam.dao.MovieDao;
import com.sunbeam.dao.MovieDaoImpl;
import com.sunbeam.dao.ReviewDao;
import com.sunbeam.dao.ReviewDaoImpl;
import com.sunbeam.pojo.Movie;
import com.sunbeam.pojo.Reviews;
import com.sunbeam.pojo.User;


@WebServlet("/revadd")
public class ReviewAddServlet  extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		System.out.println("hello");
		User u =(User) session.getAttribute("name");
		System.out.println(u);
		String mid = req.getParameter("movie");
		int id = Integer.parseInt(mid);
		System.out.println(id);
		String rat= req.getParameter("rating");
		int rating = Integer.parseInt(rat);
		System.out.println(rating);
		String  review = req.getParameter("review");
		System.out.println(review);
		System.out.println("User_id"+u.getId());
		int cnt=0;
		Reviews r = new Reviews(0,id, review,rating,u.getId(), null);
		try(ReviewDao reviewdao= new ReviewDaoImpl())
		{
			cnt=reviewdao.save(r);
			RequestDispatcher rd= req.getRequestDispatcher("reviews");
			rd.forward(req, resp);
			
		}catch(Exception e)
		{
			e.printStackTrace();
			throw new ServletException(e);
		}
		
		
		
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Movie> list = new ArrayList<Movie>();
		PrintWriter out = resp.getWriter();
		resp.setContentType("text/html");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Add Review</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<form  method='post' action='revadd'>");
		try(MovieDao moviedao = new MovieDaoImpl())
		{
			list=moviedao.findAll();
			System.out.println(list);
			
		}catch (Exception e)
		
		{
			e.printStackTrace();
			throw new ServletException(e);
		}
		out.println("Movie:");
		out.println("<select name='movie'>");
		for(Movie m :list )
		{
			out.printf("<option value='%s'>%s</option>",m.getId(),m.getTitle());
		}
		out.println("<select>");
		out.println("<br><br>");
		out.println("Rating : <input type='number' name='rating'> <br><br>");
		out.println("Review : <input type='text' name='review' ><br><br>");
		out.println("<input type='submit' value='Save'><br><br>");

		
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");	
		

	
	}
	

}
