package com.jspider.common;
public class EmployeeFactory 
{
	private static String name="jdbc";
	private EmployeeFactory()
	{
		
	}
	public static EmployeeDAO typeOfConnection()
	{
		if(name.equals("jdbc"))
		{
			EmployeeDAO obj=new EmployeesJDBCImpl();
			return obj;
		}
		else if(name.equals("hibernate"))
		{
			return null;
		}
		return null;
	}
}
