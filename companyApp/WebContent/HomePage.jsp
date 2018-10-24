<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.jspider.common.EmployeeInfoBean"%>
<%@page import="com.jspider.common.EmployeeFactory"%>
<%@page import="com.jspider.common.EmployeeDAO"%>
<%@page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>

<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Login</title>
<!-- <link href="css/bootstrap.css" rel="stylesheet"> -->
<style>
* {
  box-sizing: border-box;
}

#myInput {
  background-image: url("searchicon.png");
  background-position: 10px 10px;
  background-repeat: no-repeat;
  width: 100%;
  font-size: 16px;
  padding: 12px 20px 12px 40px;
  border: 1px solid #ddd;
  margin-bottom: 12px;
}

#myTable {
  border-collapse: collapse;
  width: 100%;
  border: 1px solid #ddd;
  font-size: 18px;
}

#myTable th, #myTable td {
  text-align: left;
  padding: 12px;
}

#myTable tr {
  border-bottom: 1px solid #ddd;
}

#myTable tr.header, #myTable tr:hover {
  background-color: #f1f1f1;
}
</style>


</head>
<%@include file="Header.html" %>
<body>
<%
	EmployeeDAO dat=EmployeeFactory.typeOfConnection();
	List<EmployeeInfoBean> data1=dat.viewAllDetails();
	HttpSession sess=request.getSession(false);
	if(sess!=null)
	{
	EmployeeInfoBean data=(EmployeeInfoBean)request.getAttribute("StudentInfo");
	int regno2=data.getRegno();
	String fname=data.getFname();
	String mname=data.getMname();
	String lname=data.getLname();
	String deptname=data.getDeptname();
	Double salary=data.getSalary();
%>
<%-- <% 
	if(data.getIsAdmin().equalsIgnoreCase("y"))
	{
		request.setAttribute("EmployeeInfo",data1);
%>
		<div>
		<h1><font color="blue"><a href="./viewAllEmployees" style="color:red;margin-top:80px;">Click here</a> to view all the employee details</font><h1>
		</div>
<%
	}
%> --%>
	<table id="myTable" style="margin-top:70px;">

      <tr class="header">
        <th style="width:15%;">Employee ID</th>
        <th style="width:20%;">First Name</th>
        <th style="width:20%;">Middle Name</th>
        <th style="width:20%;">Last Name</th>
        <th style="width:30%;">Department Name</th>
        <th style="width:40%;">Salary</th>
        <th style="width:50%;" colspan="2">Action</th>
      </tr>
    
	<!-- <tr bgcolor="cyan"><td>Employee ID</td>
	<td>FirstName</td><td>MiddleName</td><td>LastName</td>
	<td>Department Name</td><td>Salary</td></tr> -->
	
	<tr class="success">
		<td><%=regno2 %></td>
		<td><%=fname %></td>
		<td><%=mname %></td>
		<td><%=lname %></td>
		<td><%=deptname %></td>
		<td><%=salary %></td>
		<td><a href="./editDetails?empid=<%=regno2 %>&fname=<%=fname %>&mname=<%=mname %>
		&lname=<%=lname %>&deptname=<%=deptname %>&salary=<%=salary %>" 
		style="color:blue;">Update</a></td>
		<%
			if(data.getIsAdmin().equalsIgnoreCase("y"))
			{
		%>
		<%-- <td><a href="./deleteDetails?empid=<%=regno2%>">Delete</a></td> --%>
		<%
			}		
		%>
	</tr>
	
	</table>
	<% 
	if(data.getIsAdmin().equalsIgnoreCase("y"))
	{
		request.setAttribute("EmployeeInfo",data1);
%>
		<div>
		<h1><font color="blue"><a href="./viewAllEmployees" style="color:red;margin-top:80px;">Click here</a> to view all the employee details</font><h1>
		</div>
		<div class="row" style="margin-top:120px;">
		</div>
<%
	}
%>
	
	<%
	}
	else
	{
	%>
	<jsp:forward page="/loginError"/>
	<%
	}
	%>
</body>
<br><br>
<%@include file="Footer.html" %>
</html>