<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.jspider.common.EmployeeDAO" %>
<%@ page import="com.jspider.common.EmployeeFactory" %>
<%@ page import="com.jspider.common.EmployeeInfoBean" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<style>
fieldset{
height:300px;background-color:cyan;
}
</style>

</head>
<%@include file="Header.html" %>
<body>
<%
	//String empid=request.getParameter("empid");
	String fname=request.getParameter("fname");
	String mname=request.getParameter("mname");
	String lname=request.getParameter("lname");
	String deptname=request.getParameter("deptname");
	String salary=request.getParameter("salary");
	String password=request.getParameter("pass");
	String isadmin=request.getParameter("admin");
	EmployeeDAO data1=EmployeeFactory.typeOfConnection();
	int data=data1.employeeInfo( fname, mname, lname, deptname, salary, isadmin, password);
	List<EmployeeInfoBean> data2=data1.viewEmployeeDetails();
	if(data==1)
	{
%>
	<div class="row-fluid" style="margin-top:120px;">
	<h1><font color="blue">Record Added Successfully</font></h1>
	 
	 <table class="table">
	 		<tr>
	 		<th>ID</th><th>First Name</th><th>Middle Name</th>
	 		<th>Last Name</th><th>Department</th><th>Salary</th>
	 		</tr>
	 		<%
	 		for(EmployeeInfoBean eb1:data2)
	 		{
	 				
	 			
	 		%>
	 		<tr>
	 		<td><%=eb1.getRegno()  %></td><td><%=eb1.getFname() %></td>
	 		<td><%=eb1.getMname() %></td>
	 		<td><%=eb1.getLname()%></td><td><%= eb1.getDeptname() %></td>
	 		<td><%=eb1.getSalary() %></td>
	 		</tr>
	 		<%
	 		}
	 		%>
	 		
	 		</table>
	 
	 
	 
	 </div>
	<%
	}
	else
	{
	%>
	<div class="row-fluid" style="margin-top:120px;">
	<fieldset><legend></legend><h1><font color="blue">Record Not Added/Duplicate Employee Id</font>
	</h1></fieldset>
	</div>
	<%
	}
	%>
</body>
<%@include file="Footer.html" %>
</html>