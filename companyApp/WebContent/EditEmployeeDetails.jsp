<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page import="com.jspider.common.EmployeeDAO" %>
<%@ page import="com.jspider.common.EmployeeFactory" %>
<%@ page import="com.jspider.common.EmployeeInfoBean" %>
<%@ page import="com.jspider.common.EmployeesJDBCImpl" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
	String empid=request.getParameter("empid");
	int regno1=0;
	int regno2=Integer.valueOf(empid);
	
	String fname=request.getParameter("fname");
	String mname=request.getParameter("mname");
	String lname=request.getParameter("lname");
	String deptname=request.getParameter("deptname");
	String salary=request.getParameter("salary");
	//EmployeeDAO data=EmployeeFactory.typeOfConnection();
	//List<EmployeeInfoBean> data=data1.editDetails(regno2);
	//List<EmployeeInfoBean> data1=data.viewAllDetails();
	/* String fname="";
	String mname="";
	String lname="";
	String deptname=""; */
	/* double salary=0.0;
	for(EmployeeInfoBean da:data1)
	{
		fname=da.getFname();
		mname=da.getMname();
		lname=da.getLname();
		deptname=da.getDeptname();
		salary=da.getSalary();
		System.out.println(salary);
		
	} */
	
	
%>
<form class="form-horizontal" action="./saveDetails?empid=<%=regno2 %>" method="post">

	<div class="form-group" style="margin-top:120px;">
		<label class="control-label col-sm-4">Employee ID</label>
		<div class="col-sm-4">
			<%-- <label class="form-control" name="empid"><%=regno2 %></label> --%>
			<input type="text" value="<%=empid %>" name="empid" class="form-control" disabled/>
		</div>
	</div>
	
	<div class="form-group">
		<label class="control-label col-sm-4">First Name</label>
		<div class="col-sm-4">
			<input type="text" name="fname" value="<%=fname  %>" class="form-control"  required/>
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-4">Middle Name</label>
		<div class="col-sm-4">
			<input type="text" name="mname" value="<%=mname %> "class="form-control"  required/>
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-4">Last Name</label>
		<div class="col-sm-4">
			<input type="text" name="lname" value="<%=lname %>" class="form-control" required/>
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-4">Department Name</label>
		<div class="col-sm-4">
			<input type="text" name="deptname" value="<%=deptname %>" class="form-control"  required/>
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-4">Salary</label>
		<div class="col-sm-4">
			<input type="text" name="salary" value="<%=salary %>" class="form-control" required/>
		</div>
	</div>
	
	
	
		<div class="form-group" style="margin-left:450px;">
			<input type="submit" class=" btn btn-success" value="submit"/>
			<div class="col-sm-2">
			<input type="reset"  value="reset" class="btn btn-danger" />
			</div>
		</div>

</form>
</body>
</html>