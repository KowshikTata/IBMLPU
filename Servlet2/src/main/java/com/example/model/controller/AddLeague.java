package com.example.model.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddLeague extends HttpServlet{

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doProcess(request, response);

	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		int year =Integer.parseInt(request.getParameter("year").toString());
		
		String title=request.getParameter("title").toString();
		String season=request.getParameter("season").toString();
		
		if(title.length()>=8 && (year==2019 || year==2020) )
		{
			RequestDispatcher view=request.getRequestDispatcher("success.html");
			view.forward(request, response);
		}
		else
		{
			RequestDispatcher view=request.getRequestDispatcher("error2.html");
			view.forward(request, response);
		}
	
	
	}
	
}
