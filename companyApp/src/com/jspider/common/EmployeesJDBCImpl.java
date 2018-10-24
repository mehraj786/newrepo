package com.jspider.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Driver;

public class EmployeesJDBCImpl implements EmployeeDAO
{
	public EmployeeInfoBean authenticate(String regno,String pass)
	{
		Connection con=null;
		ResultSet rs=null;
		PreparedStatement stmt=null;
		try
		{
			Driver ref=new Driver();
			DriverManager.registerDriver(ref);
			String dbUrl="jdbc:mysql://localhost:3306/CLOUD_DB?user=root&password=root";
			con=DriverManager.getConnection(dbUrl);
			String query="select * from employee_info ei,salary_info si,employees_otherinfo eoi where ei.empid=si.empid and ei.empid=eoi.empid and ei.empid=? and eoi.password=?";
			stmt=con.prepareStatement(query);
			stmt.setString(1,regno );
			stmt.setString(2, pass);
			rs=stmt.executeQuery();
		
			EmployeeInfoBean data1=new EmployeeInfoBean();
			if(rs.next())
			{
				
				data1.setRegno(Integer.parseInt(regno));
				data1.setFname(rs.getString("firstname"));
				data1.setMname(rs.getString("middlename"));
				data1.setLname(rs.getString("lastname"));
				data1.setDeptname(rs.getString("deptname"));
				data1.setSalary(rs.getDouble("salary"));
				
				data1.setIsAdmin(rs.getString("isAdmin"));
				data1.setPassword(rs.getString("password"));
		
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
	public List<EmployeeInfoBean> viewAllDetails()
	{
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try
		{
			Driver ref=new Driver();
			DriverManager.registerDriver(ref);
			String dbUrl="jdbc:mysql://localhost:3306/CLOUD_DB?user=root&password=root";
			con=DriverManager.getConnection(dbUrl);
			String query="select * from employee_info ei,salary_info si where ei.empid=si.empid";
			pstmt=con.prepareStatement(query);
			rs=pstmt.executeQuery();
			
			List<EmployeeInfoBean> al=new ArrayList<EmployeeInfoBean>();
			
			while(rs.next())
			{
				EmployeeInfoBean data1=new EmployeeInfoBean();
				data1.setRegno(Integer.parseInt(rs.getString("empid")));
				data1.setFname(rs.getString("firstname"));
				data1.setMname(rs.getString("middlename"));
				data1.setLname(rs.getString("lastname"));
				data1.setDeptname(rs.getString("deptname"));
				data1.setSalary(Double.parseDouble(rs.getString("salary")));
				al.add(data1);
				//return al;
			}
			
			return al;
		}
		catch(Exception e)
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
				if(pstmt!=null)
				{
					pstmt.close();
				}
				if(rs!=null)
				{
					rs.close();
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}
	public int employeeInfo(String fname,String mname,String lname,String deptname,String salary,String isadmin,String password)
	{
		Connection con=null;
		PreparedStatement stmt=null;
		PreparedStatement stmt1=null;
		PreparedStatement stmt2=null;
		//int empid=Integer.parseInt(reg1);
		try
		{
			Driver ref=new Driver();
			DriverManager.registerDriver(ref);
			String dbUrl="jdbc:mysql://localhost:3306/CLOUD_DB?user=root&password=root";
			con=DriverManager.getConnection(dbUrl);
			
			
			Statement st = con.createStatement();
			ResultSet rs=st.executeQuery("SELECT empid FROM employee_info");
			int id=0;
			if(rs.last()){
			id=rs.getInt("empid")+1;
			}
			
			Statement st1 = con.createStatement();
			ResultSet rs1=st1.executeQuery("SELECT empid FROM salary_info");
			int id1=0;
			if(rs1.last()){
			id1=rs1.getInt("empid")+1;
			}
			Statement st2 = con.createStatement();
			ResultSet rs2=st2.executeQuery("SELECT empid FROM employees_otherinfo");
			int id2=0;
			if(rs2.last()){
			id2=rs2.getInt("empid")+1;
			}
			
			
			String query1="insert into employee_info values('"+id+"','"+fname+"','"+mname+"','"+lname+"')";
			stmt=con.prepareStatement(query1);
			int i=stmt.executeUpdate();
			
			String query2="insert into salary_info values('"+id1+"','"+deptname+"','"+salary+"')";
			stmt1=con.prepareStatement(query2);
			int j=stmt1.executeUpdate();
			
			String query3="insert into employees_otherinfo values('"+id2+"','"+isadmin+"','"+password+"')";
			stmt2=con.prepareStatement(query3);
			int k=stmt2.executeUpdate();
			
			if(i==1 &&j==1 &&k==1)
			{
			return 1;
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
				if(stmt2!=null)
				{
					stmt2.close();
				}
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}
	public ResultSet editDetails(int empid)
	{
		String fname="";
		String mname="";
		String lname="";
		String deptname="";
		String salary="";
		
		Connection con=null;
		PreparedStatement stmt=null;
		PreparedStatement stmt1=null;
		ResultSet rs=null;
		ResultSet rs1=null;
		try
		{
			Driver ref=new Driver();
			DriverManager.registerDriver(ref);
			String dbUrl="jdbc:mysql://localhost:3306/CLOUD_DB?user=root&password=root";
			con=DriverManager.getConnection(dbUrl);
			String sql1="select * from employee_info where empid=?";
			stmt=con.prepareStatement(sql1);
			stmt.setInt(1, empid);
			rs=stmt.executeQuery();
			//List<EmployeeInfoBean> al=new ArrayList<EmployeeInfoBean>();
			if(rs.next())
			{
				//EmployeeInfoBean data1=new EmployeeInfoBean();
				//data1.setRegno(rs.getInt(1));
				//empid=rs.getInt(1);
				//data1.setFname(rs.getString("firstname"));
				//data1.setMname(rs.getString("middlename"));
				//data1.setLname(rs.getString("lastname"));
				fname=rs.getString("firstname");
				mname=rs.getString("middlename");
				lname=rs.getString("lastname");
				//al.add(data1);
				//return rs;
			}
			
			String sql2="select * from salary_info where empid=?";
			stmt1=con.prepareStatement(sql2);
			stmt1.setInt(1, empid);
			rs1=stmt1.executeQuery();
			if(rs1.next())
			{
				//empid=rs1.getInt(1);
//				EmployeeInfoBean data1=new EmployeeInfoBean();
//				data1.setRegno(rs1.getInt(1));
//				data1.setDeptname(rs1.getString("deptname"));
//				data1.setSalary(rs1.getInt("salary"));
				deptname=rs1.getString("deptname");
				salary=rs1.getString("salary");
				//glname=rs1.getString("glastname");
				//al.add(data1);
				//return al;
				//return rs1;
			}
			
			//return al;
			return rs;
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
					stmt.clearBatch();
				}
				if(stmt1!=null)
				{
					stmt1.close();
				}
				if(rs!=null)
				{
					rs.close();
				}
				if(rs1!=null)
				{
					rs1.close();
				}
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
	}
	public int updateEmployeeInfo(String reg1, String fname, String mname, String lname, String deptname,
			String salary) 
	{
		//int regno1=reg1;
		int i=0;
		int j=0;
		//int eid=Integer.parseInt(reg1);
		//double sal=Double.parseDouble(salary);
		Connection con=null;
		PreparedStatement stmt=null;
		PreparedStatement stmt1=null;
		//req.getAttribute("New Details");
		System.out.println(reg1);
		System.out.println(fname);
		System.out.println(mname);
		System.out.println(lname);
		System.out.println(deptname);
		System.out.println(salary);
		try
		{
			Driver ref=new Driver();
			DriverManager.registerDriver(ref);
			String dbUrl="jdbc:mysql://localhost:3306/CLOUD_DB?user=root&password=root";
			con=DriverManager.getConnection(dbUrl);
			String sql1="update employee_info set firstname=?,middlename=?,lastname=? where empid='"+reg1+"'";
			stmt=con.prepareStatement(sql1);
			//stmt.setString(1, reg1);
			stmt.setString(1, fname);
			stmt.setString(2, mname);
			stmt.setString(3, lname);
			i=stmt.executeUpdate();
			System.out.println("i="+i);
			String sql2="update salary_info set deptname=?,salary=? where empid='"+reg1+"'";
			stmt1=con.prepareStatement(sql2);
			//stmt1.setString(1, reg1);
			stmt1.setString(1, deptname);
			stmt1.setString(2, salary);
			
			j=stmt1.executeUpdate();
			System.out.println("j="+j);
		
		}
		catch(Exception e)
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
				if(stmt1!=null)
				{
					stmt1.close();
				}
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		if(i!=0||j!=0)
		{
			return 1;
		}
		else
		{
			return 0;
		}
		//return 0;
	}
	public int deleteEmployee(String empid)
	{
		int i=0;
		int j=0;
		int k=0;
		//int eid=Integer.parseInt(reg1);
		//double sal=Double.parseDouble(salary);
		Connection con=null;
		PreparedStatement stmt=null;
		PreparedStatement stmt1=null;
		PreparedStatement stmt2=null;
		
		try
		{
			Driver ref=new Driver();
			DriverManager.registerDriver(ref);
			String dbUrl="jdbc:mysql://localhost:3306/CLOUD_DB?user=root&password=root";
			con=DriverManager.getConnection(dbUrl);
			String sql1="delete from employee_info  where empid='"+empid+"'";
			stmt=con.prepareStatement(sql1);
			//stmt.setString(1, reg1);
			/*stmt.setString(1, fname);
			stmt.setString(2, mname);
			stmt.setString(3, lname);*/
			i=stmt.executeUpdate();
			System.out.println("i="+i);
			String sql2="delete from salary_info where empid='"+empid+"'";
			stmt1=con.prepareStatement(sql2);
			//stmt1.setString(1, reg1);
			/*stmt1.setString(1, deptname);
			stmt1.setString(2, salary);*/
			
			j=stmt1.executeUpdate();
			System.out.println("j="+j);
			String sql3="delete from employees_otherinfo where empid='"+empid+"'";
			stmt2=con.prepareStatement(sql3);
			k=stmt2.executeUpdate();
			System.out.println("k="+k);
		}
		catch(Exception e)
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
				if(stmt1!=null)
				{
					stmt1.close();
				}
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		if(i==1&&j==1&&k==1)
		{
			return 1;
		}
		else
		{
			return 0;
		}
		
	}
	public List<EmployeeInfoBean> viewEmployeeDetails() 
	{
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try
		{
			Driver ref=new Driver();
			DriverManager.registerDriver(ref);
			String dbUrl="jdbc:mysql://localhost:3306/CLOUD_DB?user=root&password=root";
			con=DriverManager.getConnection(dbUrl);
			String query="select * from employee_info ei,salary_info si where ei.empid=si.empid";
			pstmt=con.prepareStatement(query);
			rs=pstmt.executeQuery();
			
			List<EmployeeInfoBean> al=new ArrayList<EmployeeInfoBean>();
			
			if(rs.last())
			{
				EmployeeInfoBean data1=new EmployeeInfoBean();
				data1.setRegno(Integer.parseInt(rs.getString("empid")));
				data1.setFname(rs.getString("firstname"));
				data1.setMname(rs.getString("middlename"));
				data1.setLname(rs.getString("lastname"));
				data1.setDeptname(rs.getString("deptname"));
				data1.setSalary(Double.parseDouble(rs.getString("salary")));
				al.add(data1);
				//return al;
			}
			
			return al;
		}
		catch(Exception e)
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
				if(pstmt!=null)
				{
					pstmt.close();
				}
				if(rs!=null)
				{
					rs.close();
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		
		
	}
}
