<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.jspider.common.EmployeeInfoBean" %>
<%@ page import="com.jspider.common.EmployeeSearchDAO" %>
<html>
<head>
<style>
fieldset{
height:100px;background-color:cyan;
}
<link rel="stylesheet" href="css/bootstrap.css">
</style>

</head>

<%@include file="Header.html" %>
<body style="margin-top:240px;">

<%
	String search=request.getParameter("search");
	EmployeeSearchDAO obj=new EmployeeSearchDAO();
	EmployeeInfoBean data=obj.authenticate(search);
	if(data!=null)
	{
%>

	<div class="row-fluid" style="margin-top:80px;">
	<fieldset><legend></legend><h1><font color="blue">Record  Found</font>
	</h1></fieldset>
	</div>
	<table class="table" border="1">
	<thead>
	<th>Employee ID</th>
	<th>First Name</th>
	<th>Middle Name</th>
	<th>Last Name</th>
	<th>Department Name</th>
	<th>Salary</th>
	</thead>
	<tbody>
		<tr class="success">
			<td><%=data.getRegno() %></td>
			<td><%=data.getFname() %></td>
			<td><%=data.getMname() %></td>
			<td><%=data.getLname() %></td>
			<td><%=data.getDeptname() %></td>
			<td><%=data.getSalary() %></td>
		</tr>
	</tbody>
	</table>
	<%
	}
	else
	{
	%>
		<div class="row-fluid" style="margin-top:120px;">
				<fieldset><legend></legend><h1><font color="blue">Sorry! Record Not Found</font>
			</h1></fieldset>
		</div>
		<div class="row-fluid" style="margin-top:160px;">
		</div>
	<%
	}
	%>
</body>
<%@include file="Footer.html" %>
</html>