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

import com.sunbeam.dao.ReviewDao;
import com.sunbeam.dao.ReviewDaoImpl;
import com.sunbeam.pojo.Reviews;
import com.sunbeam.pojo.User;

@WebServlet("/reviews")
public class ReviewsServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("name");
		
	   List<Reviews>list = new ArrayList<Reviews>();
	   System.out.println(list);

		try(ReviewDao reviewdao= new ReviewDaoImpl())
		{
			list = reviewdao.findAll();
					
		}catch(Exception e)
		{
			e.printStackTrace();
			throw new ServletException(e);
		}
		
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Reviews Page</title>");
		out.println("</head>");
		out.println("<body>");
		out.printf("<h1>Hello %s</h1>",user.getFname());
		out.println("<table border=1>");
		out.println("<thead>");
		out.println("<tr>");
		out.println("<th>Id</th>");
		out.println("<th>Movie_ID</th>");
		out.println("<th>Review</th>");
		out.println("<th>Rating</th>");
		out.println("<th>User_ID</th>");
		out.println("<th>Modified</th>");
		out.println("<th>Action</th>");
		out.println("</tr>");
		out.println("</thead>");
		out.println("<tr>");
		out.println("<tbody>");
		for (Reviews r : list) {
			out.println("<tr>");
			out.printf("<td>%s</td><td>%s</td><td>%s</td><td>%s</td><td>%s</td><td>%s</td>",r.getId(),r.getMid(),r.getReview(),r.getRating(),r.getUser_id(),r.getModified());
			out.printf("<td><a href='revedit?id=%s'>Edit</a>     <a href='revdel?id=%s'>Delete</a>       <a href='revshare'>share</a></td>",r.getId(),r.getId());
			out.println("</tr>");
		}
		
		out.println("</tbody>");
		out.println("</table>");
		out.println("<a href='revadd'>Add Review</a> <br>");
		out.println("<a href='logout'>Sign Out</a> <br>");
		
		out.println("</body>");
		out.println("</html>");
		
}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}

}
