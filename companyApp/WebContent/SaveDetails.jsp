<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="com.jspider.common.EmployeeInfoBean"%>
<%@page import="com.jspider.common.EmployeeFactory"%>
<%@page import="com.jspider.common.EmployeeDAO"%>
<%@page import="java.util.List" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<%@include file="Header.html" %>
<body>
<%
EmployeeDAO dat=EmployeeFactory.typeOfConnection();
String id=request.getParameter("empid");
String fname=request.getParameter("fname");
String mname=request.getParameter("mname");
String lname=request.getParameter("lname");
String deptname=request.getParameter("deptname");
String salary=request.getParameter("salary");
//int eid=Integer.valueOf(id);
//int eid=Integer.parseInt(id);
System.out.println("Saved details page="+id);
int q=dat.updateEmployeeInfo(id, fname, mname, lname, deptname, salary);

%>
<%
	if(q==1)
	{
%>
		
	<div class="row-fluid" style="margin-top:250px;">
	 <fieldset><legend></legend><h1><font color="blue">Record Updated Successfully</font></h1>
	 </fieldset>
	 </div>
<%
		
	}
	else
	{
%>
		
	<div class="row-fluid" style="margin-top:250px;">
	 <fieldset><legend></legend><h1><font color="blue">Record Not Updated Duplicate Entry</font></h1>
	 </fieldset>
	 </div>
<%
	}
%>
</body>
<br><br>
<%@include file="Footer.html" %>
</html>