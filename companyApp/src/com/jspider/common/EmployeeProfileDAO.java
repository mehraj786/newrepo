package com.jspider.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class EmployeeProfileDAO 
{
	public int employeeInfo(String reg1,String fname,String mname,String lname,String deptname,String salary,String isadmin,String password)
	{
		
		Connection con=null;
		Statement stmt=null;
		Statement stmt1=null;
		Statement stmt2=null;
		int regno=Integer.parseInt(reg1);
		//StudentInfoBean data1=new StudentInfoBean();
			try 
			{
				Driver ref = new Driver();
				DriverManager.registerDriver(ref);
				String dbUrl="jdbc:mysql://localhost:3306/CLOUD_DB?user=root&password=root";
				con=DriverManager.getConnection(dbUrl);
				String query1="insert into employee_info(empid,firstname,middlename,lastname)"+
							  "values("+regno+",'"+fname+"','"+mname+"','"+lname+"');";
				stmt=con.createStatement();
				int q1=stmt.executeUpdate(query1);
				
				
				String query2="insert into salary_info(empid,deptname,salary)"+
							  "values("+regno+",'"+deptname+"','"+salary+");";
				stmt1=con.createStatement();
				int q2=stmt1.executeUpdate(query2);
				
				String query3="insert into employees_otherinfo(empid,isadmin,password)"+
							  "values("+regno+",'"+isadmin+"','"+password+"');";
				stmt2=con.createStatement();
				int q3=stmt2.executeUpdate(query3);
				if(q1==1 &&q2==1 &&q3==1)
				{
				return 1;
				}
				else
				{
					return 0;
				}
			} 
			catch (SQLException e)
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
					if(stmt2!=null)
					{
						stmt2.close();
					}
				}
				catch(SQLException e)
				{
					e.printStackTrace();
				}
			}
	}

	
}
