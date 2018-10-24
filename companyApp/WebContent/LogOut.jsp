<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<html>
<body>
<%
	HttpSession httpSession=request.getSession(false);
	if(httpSession!=null)
	{
		httpSession.invalidate();
	}
%>
<jsp:forward page="login.html"/>
</body>
</html>