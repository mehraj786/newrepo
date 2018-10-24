<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@page import="com.jspider.common.EmployeeInfoBean"%>
<%@page import="com.jspider.common.EmployeeFactory"%>
<%@page import="com.jspider.common.EmployeeDAO"%>
<%@page import="java.util.List" %>
  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% 
	EmployeeDAO dat=EmployeeFactory.typeOfConnection();
	List<EmployeeInfoBean> data1=dat.viewAllDetails();
	
%>	
<div class="container-fluid">

		<div class="row-fluid" style="margin-top:80px;margin-left:380px;"><h2><font color="blue">Employee Password Change Form</font></h2></div>
		<div class="row"></div>
		<form class="form-horizontal" action="./ChangePassword" method="post">

		 <div class="form-group">
			<label class="control-label col-sm-4">Emp ID</label>
			<div class="col-sm-4">
			<select class="form-control" name="empid">
		     <% 
		     for(EmployeeInfoBean d:data1)
		     { 
		     %>
            	<option><%=d.getRegno()%></option>
        	<%
        	}
		    %>
        </select>
				
				<!-- <input type="text" class="form-control" name="empid" pattern="[0-9]{1,}" title="enter only digits" placeholder="enter employee id" required/> -->
			</div>
		</div>
	
		<div class="form-group">
			<label class="control-label col-sm-4">Current Password</label>
			<div class="col-sm-4">
				<input type="password" name="cpass" class="form-control"  placeholder="enter current password" required/>
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-4">New Password</label>
			<div class="col-sm-4">
				<input type="password" name="npass" class="form-control" placeholder="enter new password" required/>
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-4">Re-enter New Password</label>
			<div class="col-sm-4">
				<input type="password" name="repass"  class="form-control" placeholder="re enter new password" required/>
			</div>
		</div>
		<div class="form-group" style="margin-left:450px;">
			<input type="submit" class=" btn btn-success" value="Change Password"/>
			
		</div>

		</form>
	</div>


</body>
</html>