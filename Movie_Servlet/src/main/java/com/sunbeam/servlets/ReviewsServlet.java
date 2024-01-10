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
		PrintWriter out = resp.getWriter();
		HttpSession session = req.getSession();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Reviews Page</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<a href='reviews?type=all'>all reviews</a>\r\n");
		out.println("<a href='reviews?type=my'>my reviews</a>\r\n");
		out.println("<a href='reviews?type=shared'>sharedreviews</a>\r\n");
		out.println("</body>");
		out.println("<html>");
		String type=req.getParameter("type");
		System.out.println(type);
		List<Reviews> list = new ArrayList<Reviews>();
		try(ReviewDao dao = new ReviewDaoImpl()) {
			if(type.equals("all"))
			{
				list = dao.findAll();
				
				
				out.println("<html>");
				out.println("<head>");
				out.println("<title>Reviews Page</title>");
				out.println("</head>");
				out.println("<body>");
				out.printf("<h1>Hello</h1>");
				out.println("<table border=1>");
				out.println("<thead>");
				out.println("<tr>");
				out.println("<th>Id</th>");
				out.println("<th>Movie_ID</th>");
				out.println("<th>Review</th>");
				out.println("<th>Rating</th>");
				out.println("<th>User_ID</th>");
				out.println("<th>Modified</th>");
				out.println("</tr>");
			
				for (Reviews reviews : list) {
					out.println("<tr>");
					out.printf("<td>%s</td>",reviews.getId());
					out.printf("<td>%s</td>",reviews.getMid());
					out.printf("<td>%s</td>",reviews.getReview());
					out.printf("<td>%s</td>",reviews.getRating());
					out.printf("<td>%s</td>",reviews.getUser_id());
					out.printf("<td>%s</td>",reviews.getModified());
					out.println("</tr>");
				}
				
				out.println("</table>");
				out.println("</body>");
				out.println("</html>");
				
				
			}
			
			else if(type.equals("my"))
			{
				User user=(User)session.getAttribute("name");
				int id=user.getId();
				System.out.println(id);
				list=dao.findByUserId(id);
				out.println("<html>");
				out.println("<head>");
				out.println("<title>Reviews Page</title>");
				out.println("</head>");
				out.println("<body>");
				out.printf("<h1>Hello</h1>");
				out.println("<table border=1>");
				out.println("<thead>");
				out.println("<tr>");
				out.println("<th>Id</th>");
				out.println("<th>Movie_ID</th>");
				out.println("<th>Review</th>");
				out.println("<th>Rating</th>");
				out.println("<th>User_ID</th>");
				out.println("<th>Modified</th>");
				out.println("</tr>");
			
				for (Reviews reviews : list) {
					out.println("<tr>");
					out.printf("<td>%s</td>",reviews.getId());
					out.printf("<td>%s</td>",reviews.getMid());
					out.printf("<td>%s</td>",reviews.getReview());
					out.printf("<td>%s</td>",reviews.getRating());
					out.printf("<td>%s</td>",reviews.getUser_id());
					out.printf("<td>%s</td>",reviews.getModified());
					out.println("</tr>");
				}
				
				out.println("</table>");
				out.println("</body>");
				out.println("</html>");
				
		    }
			else if(type.equals("shared"))
			{
				User user=(User)session.getAttribute("name");
				int id=user.getId();
				System.out.println(id);
				list=dao.sharedWithMe(id);
				System.out.println(list);
				out.println("<html>");
				out.println("<head>");
				out.println("<title>Reviews Page</title>");
				out.println("</head>");
				out.println("<body>");
				out.printf("<h1>Hello</h1>");
				out.println("<table border=1>");
				out.println("<thead>");
				out.println("<tr>");
				out.println("<th>Id</th>");
				out.println("<th>Movie_ID</th>");
				out.println("<th>Review</th>");
				out.println("<th>Rating</th>");
				out.println("<th>User_ID</th>");
				out.println("<th>Modified</th>");
				out.println("</tr>");
			
				for (Reviews reviews : list) {
					out.println("<tr>");
					out.printf("<td>%s</td>",reviews.getId());
					out.printf("<td>%s</td>",reviews.getMid());
					out.printf("<td>%s</td>",reviews.getReview());
					out.printf("<td>%s</td>",reviews.getRating());
					out.printf("<td>%s</td>",reviews.getUser_id());
					out.printf("<td>%s</td>",reviews.getModified());
					out.println("</tr>");
				}
				
				out.println("</table>");
				out.println("</body>");
				out.println("</html>");
				
		    }
			   
				
		} catch (Exception e) {
			e.printStackTrace();
		}
			
		out.println("<a href='addreview'>Add Review</a>");
		out.println("<a href='logout'>Log out</a>");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}


}
