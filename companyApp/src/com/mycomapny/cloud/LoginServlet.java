package com.mycomapny.cloud;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Driver;

public class LoginServlet extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		String user=req.getParameter("uname");
		String pass=req.getParameter("password");
		String uname1="";
		String pasword1="";
		Connection con=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try
		{
			Driver ref=new Driver();
			DriverManager.registerDriver(ref);
			String dbUrl="jdbc:mysql://localhost:3306/cloud_db?user=root&password=root";
			con=DriverManager.getConnection(dbUrl);
			String query="select * from login";
			stmt=con.prepareStatement(query);
			rs=stmt.executeQuery();
			if(rs.next())
			{
				uname1=rs.getString("username");
				pasword1=rs.getString("password");
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if(con!=null)
				{
					con.close();
				}
				if(stmt!=null)
				{
					stmt.close();
				}
				if(rs!=null)
				{
					rs.close();
				}
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		if(user.equals(uname1) && pass.equals(pasword1))
		{
			out.print("<html><body><center><h1>");
			out.print("<font color=\"blue\">");
			out.print("Welcome to New Cloud Computing");
			out.print("</font></h1></center></body></html>");
		}
		else
		{
			out.print("Invalid username or password");
		}
	}
}
