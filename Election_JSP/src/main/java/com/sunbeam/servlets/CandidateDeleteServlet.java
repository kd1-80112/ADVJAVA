package com.sunbeam.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;
@WebServlet("/canddel")
public class CandidateDeleteServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String candId = req.getParameter("id");
		int id = Integer.parseInt(candId);
		int cnt = 0;
		try(CandidateDao candDao = new CandidateDaoImpl()) {
			cnt = candDao.deleteById(id);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
		String message = "Candidates Deleted: " + cnt;
		req.setAttribute("message", message);
		
		RequestDispatcher rd = req.getRequestDispatcher("result");
		rd.forward(req, resp);
	}
	
	

}
