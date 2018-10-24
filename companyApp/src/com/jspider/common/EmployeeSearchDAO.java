package com.jspider.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;

public class EmployeeSearchDAO
{
	public EmployeeInfoBean authenticate(String empid)
	{
		Connection con=null;
		ResultSet rs=null;
		PreparedStatement stmt=null;
		int eid=Integer.parseInt(empid);
		try
		{
			Driver ref=new Driver();
			DriverManager.registerDriver(ref);
			String dbUrl="jdbc:mysql://localhost:3306/CLOUD_DB?user=root&password=root";
			con=DriverManager.getConnection(dbUrl);
			String query="select * from employee_info ei,salary_info si where ei.empid=si.empid and ei.empid=?";
			stmt=con.prepareStatement(query);
			stmt.setInt(1,eid );
			rs=stmt.executeQuery();
		
			EmployeeInfoBean data1=new EmployeeInfoBean();
			if(rs.next())
			{
				
				data1.setRegno(Integer.parseInt(empid));
				data1.setFname(rs.getString("firstname"));
				data1.setMname(rs.getString("middlename"));
				data1.setLname(rs.getString("lastname"));
				data1.setDeptname(rs.getString("deptname"));
				data1.setSalary(rs.getDouble("salary"));
				return data1;
			}
			else
			{
				return null;
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			return null;
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
		//return null;
	}
}
