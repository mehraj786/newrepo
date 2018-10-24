 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<html>
<%@include file="Header.html" %>
<body>
<%
	String name=request.getParameter("name");
	if(name.equals("createProfile.html"))
	{
%>
		<%@include file="createProfile.html" %>
	<%
	}
	else if(name.equals("employeeSearch.html"))
	{
	%>
		<%@include file="employeeSearch.html" %>
	<%
	}
	else if(name.equals("newEPassChange.jsp"))
	{
	%>
		<%@include file="newEPassChange.jsp" %>
	<%
	}
	%>
</body>
<%@include file="Footer.html" %>
</html>