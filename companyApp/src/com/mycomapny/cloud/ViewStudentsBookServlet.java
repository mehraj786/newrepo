package com.mycomapny.cloud;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Driver;

public class ViewStudentsBookServlet extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		Connection con=null;
		Statement stmt=null;
		ResultSet rs=null;
		int i=0;
		String name="";
		try
		{
			Driver ref=new Driver();
			DriverManager.registerDriver(ref);
			String dbUrl="jdbc:mysql://localhost:3306/BECM78_db?user=root&password=root";
			con=DriverManager.getConnection(dbUrl);
			
			String query="select Student_NM,count(*) as 'NO of Books' from library group by Student_NM";
			stmt=con.createStatement();
			rs=stmt.executeQuery(query);
			out.print("<html><body><table border=\"1\" width=\"100%\"><tr bgcolor=\"cyan\">");
			out.print("<td><h1>Student Name</h1></td><td><h1>No Of Books</h1></td></tr>");
			while(rs.next())
			{
				out.print("<tr><td><h1>"+rs.getString("Student_NM")+"</h1></td>");
				out.print("<td><h1>"+rs.getInt("No Of Books")+"</h1></td></tr>");
			}
			out.print("</table></body></html>");
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
				if(rs!=null)
				{
					rs.close();
				}
				if(stmt!=null)
				{
					stmt.close();
				}
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
	}
}
