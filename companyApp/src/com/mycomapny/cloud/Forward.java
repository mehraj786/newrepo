package com.mycomapny.cloud;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Forward extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		String url="/servlet2";
		//RequestDispatcher dispatcher=req.getRequestDispatcher(url);
		//dispatcher.forward(req, resp);
		ServletContext context=getServletContext();
		RequestDispatcher dispatcher= context.getRequestDispatcher(url);
		dispatcher.forward(req, resp);
		
		
	}

}
