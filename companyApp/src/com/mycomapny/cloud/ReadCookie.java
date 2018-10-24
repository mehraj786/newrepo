package com.mycomapny.cloud;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ReadCookie extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException
	{
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		Cookie[] receivedCookie=req.getCookies();
		if(receivedCookie==null)
		{
			out.print("cookies are not present...");
			out.print("<html><body><fieldset><legend><font color=\"red\">Cookies Disabled</font></legend>");
			out.print("<p>oops:your browser seems to have cookies disabled. Make sure cookies are <br>");
			out.print("enabled or try opening a new browser window</p></fieldset></body></html>");
		}
		else
		{
			for(Cookie recvdCookie:receivedCookie)
			{
				out.print("Cookie Name:"+recvdCookie.getName());
				out.print("Cookie value:"+recvdCookie.getValue());
			}
		}
	}
}
