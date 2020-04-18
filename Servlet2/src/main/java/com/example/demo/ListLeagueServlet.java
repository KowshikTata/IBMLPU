package com.example.demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.model.League;

public class ListLeagueServlet extends HttpServlet {

	
	private List<League> list;
	protected void doGet(HttpServletRequest request,HttpServletResponse response)
			throws ServletException, IOException
	{
		processRequest(request,response);
	}
	
	protected void doPost(HttpServletRequest request,HttpServletResponse response)
			throws ServletException, IOException
	{
		
		processRequest(request,response);
	}
	
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		list=new ArrayList<League>();
		list.add(new League(UUID.randomUUID().toString(),2020,"SUMMER","Duke League"));
		list.add(new League(UUID.randomUUID().toString(),2020,"SUMMER","FIFA League"));
		list.add(new League(UUID.randomUUID().toString(),2020,"SUMMER","SPA League"));
		out.println("<html><head><title>List League</title></head>"
				+ "<body><table border='1'><tr><td>League Id</td>"
				+ "<td>Year</td>"
				+ "<td>League Title</td>"
				+ "<td>Season</td></tr>"
				);
				
		for(League li:list)
		{
			out.println("<tr><td>"+li.getLeagueId()+"</td><td>"
					+ li.getYear()+"</td><td>"
					+ li.getSeason()+"</td><td>"
					+ li.getTitle()+"</td></tr>");
		}
		out.println("</table></body></html>");
	}
	
}
