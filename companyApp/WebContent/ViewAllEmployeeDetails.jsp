<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.jspider.common.EmployeeInfoBean"%>
<%@page import="com.jspider.common.EmployeeFactory"%>
<%@page import="com.jspider.common.EmployeeDAO"%>
<%@page import="java.util.List"%>
<!DOCTYPE>
<html>
<%@include file="Header.html" %>
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

<script>
function myFunction() {
  var input, filter, table, tr, td, i;
  input = document.getElementById("myInput");
  filter = input.value.toUpperCase();
  table = document.getElementById("myTable");
  tr = table.getElementsByTagName("tr");
  for (i = 1; i < tr.length; i++) {
    td = tr[i].getElementsByTagName("td")[1];
    if (td) {
      if (td.innerHTML.toUpperCase().indexOf(filter) > -1) {
        tr[i].style.display = "";
      } else {
        tr[i].style.display = "none";
      }
    }       
  }
}
</script>

</head>

<body>
	<input style="margin-top:80px;" type="text" id="myInput" onkeyup="myFunction()" placeholder="Search for names.." title="Type in a name">
	
<% 
	EmployeeDAO data1=EmployeeFactory.typeOfConnection();
	List<EmployeeInfoBean> data=data1.viewAllDetails();
	//List<EmployeeInfoBean> data=(List<EmployeeInfoBean>)request.getAttribute("EmployeeInfo");
	
%>
	<!-- <table width="100%" border="1">
	<tr bgcolor="cyan"><td>Employee ID</td>
	<td>FirstName</td><td>MiddleName</td><td>LastName</td>
	<td>Department Name</td><td>Salary</td></tr> -->
	<table id="myTable">

      <tr class="header">
        <th style="width:15%;">Employee ID</th>
        <th style="width:20%;">First Name</th>
        <th style="width:20%;">Middle Name</th>
        <th style="width:20%;">Last Name</th>
        <th style="width:30%;">Department Name</th>
        <th style="width:40%;">Salary</th>
        <th colspan="2" style="width:50%;">Action</th>
      </tr>
    
<%
	for(EmployeeInfoBean data2:data)
	{
%>
	
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
		<td><a href="./deleteDetails?empid=<%=data2.getRegno()%>">Delete</a></td>
<% 		
	}
%>
	</tr>
	
	</table>
	<div class="row" style="margin-top:100px;"></div>
</body>
<%@include file="Footer.html" %>
</html>