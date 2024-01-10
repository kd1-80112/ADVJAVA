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

import com.sunbeam.dao.MovieDao;
import com.sunbeam.dao.MovieDaoImpl2;
import com.sunbeam.dao.ReviewDao;
import com.sunbeam.dao.ReviewDaoImpl;
import com.sunbeam.pojo.Movie;
import com.sunbeam.pojo.Reviews;


@WebServlet("/revedit")
public class ReviewEditServlet  extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String rid = req.getParameter("id");
		int id = Integer.parseInt(rid);
		Reviews r=null;
		try(ReviewDao reviewdao=new ReviewDaoImpl())
		{
			 r=reviewdao.findById(id);
			
		}catch(Exception e)
		{
			e.printStackTrace();
			throw new ServletException(e);
		}
		
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Edit Candidate</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h5>Edit Candidate</h5>");
		out.println("<form method='post' action='revedit'>");
		out.printf("Id: <input type='text' name='id' value='%s' readonly>\r\n<br/>", r.getId());
		List<Movie>list = new ArrayList<Movie>();
		try(MovieDao moviedao = new MovieDaoImpl2())
		{
			list= moviedao.findAll();
			
		}catch(Exception e)
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
		out.printf("review: <input type='text' name='review' value='%s'>\r\n<br/>", r.getReview());
		out.printf("Rating: <input type='text' name='rating' value='%s'>\r\n<br/>",r.getRating());
		out.printf("user_id: <input type='text' name='uid' value='%s' readonly>\r\n<br/>",r.getUser_id());
		
		out.println("<input type='submit' value='Update'/>");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
		
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String rid =req.getParameter("id");
		
		int id = Integer.parseInt(rid);
		String moid=req.getParameter("movie");
		int mid=Integer.parseInt(moid);
		String review =req.getParameter("review");
		String rat= req.getParameter("rating");
		int rating = Integer.parseInt(rat);
		String usid= req.getParameter("uid");
		int uid = Integer.parseInt(usid);
		Reviews r= new Reviews(id,mid,review,rating,uid,null);
		System.out.println("Post EditReview"+r);
		int cnt = 0;
		try(ReviewDao reviewdao = new ReviewDaoImpl())
		{
			cnt =reviewdao.update(r);
					
		}catch(Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
		RequestDispatcher rd = req.getRequestDispatcher("reviews");
		rd.forward(req, resp);
		
		
				
	}

}
