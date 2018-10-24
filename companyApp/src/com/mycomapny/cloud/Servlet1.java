package com.mycomapny.cloud;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet1 extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		
		ServletContext context=getServletContext();
		String movie=context.getInitParameter("movie1");
		
		ServletConfig config=getServletConfig();
		String actor1=config.getInitParameter("Actor1");
		String actor2=config.getInitParameter("Actor2");
		
		String actress1=config.getInitParameter("Actress1");
		String actress2=config.getInitParameter("Actress2");
		
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		out.print("movie name= "+movie);
		out.print("  Actor1="+actor1);
		out.print("  Actor2="+actor2);
		
		out.print("  Actress1="+actress1);
		out.print("  Actress2="+actress2);
	}

}
