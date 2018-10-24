<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.jspider.common.EmployeeInfoBean"%>
<%@page import="com.jspider.common.EmployeeFactory"%>
<%@page import="com.jspider.common.EmployeeDAO"%>
<%@page import="com.jspider.common.EmployeesJDBCImpl" %>
<%@page import="java.util.List" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<%@include file="Header.html" %>
<body>
	<%
	EmployeeDAO dat=EmployeeFactory.typeOfConnection();
	//List<EmployeeInfoBean> data=dat.viewAllDetails();
String empid=request.getParameter("empid");
int q=dat.deleteEmployee(empid);

	if(q==1)
	{

	%>
		<div class="row-fluid" style="margin-top:100px;">
	 	<fieldset><legend></legend><h1><font color="blue">Record Deleted Successfully</font></h1>
	 	</fieldset>
	 	</div>
	 	
	 	
	 	
	<%
	}
	else
	{
	%>
	<div class="row-fluid" style="margin-top:100px;">
	 <fieldset><legend></legend><h1><font color="blue"></font></h1>
	 </fieldset>
	 </div>
	<%
	}
	%>
	<table class="table" border="1" style="margin-top:10px;">
	<thead>
      <tr>
        <th>Employee ID</th>
        <th>First Name</th>
        <th>Middle Name</th>
        <th>Last Name</th>
        <th>Department Name</th>
        <th>Salary</th>
        <th colspan="2">Action</th>
      </tr>
    </thead>
<%
List<EmployeeInfoBean> data=dat.viewAllDetails();
	for(EmployeeInfoBean data2:data)
	{
%>
	<tbody>
	<tr class="success">	
		<td><%=data2.getRegno() %></td>
		<td><%=data2.getFname() %></td>
		<td><%=data2.getMname() %></td>
		<td><%=data2.getLname() %></td>
		<td><%=data2.getDeptname() %></td>
		<td><%=data2.getSalary() %></td>
		<td><a href="./editDetails?empid=<%=data2.getRegno() %>&fname=<%=data2.getFname() %>
		&mname=<%=data2.getMname() %>&lname=<%=data2.getLname() %>
		&deptname=<%=data2.getDeptname() %>&salary=<%=data2.getSalary() %>" style="color:blue;">Update</a></td>
		<td><a  href="./deleteDetails?empid=<%=data2.getRegno()%>">Delete</a></td>
<% 		
	}
%>
	</tr>
	</tbody>
	</table>
	
	
</body>
<br><br>
<%@include file="Footer.html" %>
</html>