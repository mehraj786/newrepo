package com.jspider.common;

import java.sql.ResultSet;
import java.util.List;

public interface EmployeeDAO
{
	EmployeeInfoBean authenticate(String regno,String pass);
	public List<EmployeeInfoBean> viewAllDetails();
	public int employeeInfo(String fname,String mname,String lname,String deptname,String salary,String isadmin,String password);
	public int updateEmployeeInfo(String reg1,String fname,String mname,String lname,String deptname,String salary);
	public ResultSet editDetails(int empid);
	public int deleteEmployee(String empid);
	public List<EmployeeInfoBean> viewEmployeeDetails();
}
