<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.jspider.common.EmployeeDAO"%>
<%@page import="com.jspider.common.EmployeePassChange"%>
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
<body>
<%
	String empid=request.getParameter("empid");
	String cpass=request.getParameter("cpass");
	String npass=request.getParameter("npass");
	String renpass=request.getParameter("repass");
	EmployeePassChange obj=new EmployeePassChange();
	int data=obj.updatePassword(empid,cpass,npass,renpass);
	if(data==1)
	{
%>	
	<!-- <h1><font color="blue">Password Change Successfully</font></h1> -->
	<div class="row-fluid" style="margin-top:120px;">
				<fieldset><legend></legend><h1><font color="blue">Password Change Successfully</font>
			</h1></fieldset>
		</div>
	<%
	}
	else if(data==-1)
	{
	%>
	<!-- <h1><font color="blue">password mismatch</font></h1> -->
	<div class="row-fluid" style="margin-top:120px;">
				<fieldset><legend></legend><h1><font color="blue">Password mismatch...</font>
			</h1></fieldset>
		</div>
	<%
	}
	else
	{
	%>
	<!-- <h1><font color="blue">Invalid Employee Id/Password</font></h1> -->
		<div class="row-fluid" style="margin-top:120px;">
				<fieldset><legend></legend><h1><font color="blue">Invalid Employee Id/Password</font>
			</h1></fieldset>
		</div>
	
	<%
	}
	%>
	<div class="row" style="margin-top:220;">
	
	</div>
</body>
<%@include file="Footer.html" %>
</html>