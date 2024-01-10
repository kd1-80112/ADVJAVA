package com.sunbeam.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;
import com.sunbeam.daos.UserDao;
import com.sunbeam.daos.UserDaoImpl;

@WebServlet("/vote")
public class VoteServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
	String candId = req.getParameter("candidate");
	int cId = Integer.parseInt(candId);
	try(CandidateDao candDao = new CandidateDaoImpl()) {
		int cnt = candDao.incrementVote(cId);
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Voting Done</title>");
		out.println("</head>");
		out.println("<body>");
		if(cnt == 1) {
			try(UserDao userDao = new UserDaoImpl()) {
				if(cnt == 1)
					out.println("<h5>Your vote registered successfully.</h5>");
			}
		}
		if(cnt == 0)
			out.println("<h5>Some error occurred. Try again.</h5>");
		out.println("<a href='logout'>Sign Out</a>");
		out.println("</body>");
		out.println("</html>");
	
	} catch (Exception e) {
		throw new ServletException(e);
	}
	

}
}