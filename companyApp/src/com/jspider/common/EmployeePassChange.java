package com.jspider.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class EmployeePassChange
{
	public int updatePassword(String empid,String cpass,String npass,String repass)
	{
		Connection con=null;
		PreparedStatement stmt=null;
		PreparedStatement stmt1=null;
		ResultSet rs=null;
		//Statement stmt2=null;
		int i=0;
		String dbpass="";
		if(npass.equals(repass))
		{
			try
			{
				Driver ref=new Driver();
				DriverManager.registerDriver(ref);
				String dbUrl="jdbc:mysql://localhost:3306/cloud_db?user=root&password=root";
				con=DriverManager.getConnection(dbUrl);
				String query="select password from employees_otherinfo where empid='"+empid+"'";
				stmt=con.prepareStatement(query);
				rs=stmt.executeQuery();
				while(rs.next())
				{
					dbpass=rs.getString(1);
				}
				if(cpass.equals(dbpass))
				{
					String query1="update employees_otherinfo set password='"+npass+"' where empid='"+empid+"'";
					stmt1=con.prepareStatement(query1);
					i=stmt1.executeUpdate();
					return i;
				}
				else
				{
					return 0;
				}
			}
			catch(SQLException e)
			{
				e.printStackTrace();
				return 0;
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
					if(stmt1!=null)
					{
						stmt1.close();
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
		}
		else
		{
			return -1;
		}
	}
}
