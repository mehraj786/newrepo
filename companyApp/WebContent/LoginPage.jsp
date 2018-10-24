<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.jspider.common.EmployeeDAO" %>
<%@page import="com.jspider.common.EmployeeFactory" %>
<%@page import="com.jspider.common.EmployeeInfoBean" %>  
    
    
<html>
<head>
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
<body>
<%
	String regno=request.getParameter("regno");
	String password=request.getParameter("pass");

	EmployeeDAO obj=EmployeeFactory.typeOfConnection();
	EmployeeInfoBean data=obj.authenticate(regno,password);
	
	if(data!=null)
	{
		request.getSession(true);
		request.setAttribute("StudentInfo", data);
		
%>
	<jsp:forward page="/homePage"/>
<% 	
	}
	else
	{
		
		request.setAttribute("mesg", data);
%>
	<jsp:forward page="/loginError"/>
<%
	}
	
%>
</body>
</html>