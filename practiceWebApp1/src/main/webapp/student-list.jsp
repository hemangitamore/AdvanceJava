<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.studentCrud.model.Student"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
 
</head>
<body>
<div class="alert alert-primary" role="alert">
  			List of all the employees
		</div>
		<div "container mt-5">
		<%
		if(request.getAttribute("studentList")!=null){
			List<Student>students=(ArrayList<Student>)request.getAttribute("studentList");
			%>
			
			<table class="table">
			<thead>
			<tr>
			<th scope="col">Id</th>
			<th scope="col">Name</th>
			<th scope="col">Marks</th>
			<th scope="col">Action</th>
			
			</tr>
			</thead>
			
			<tbody>
			<%
			Iterator<Student>itr=students.iterator();
			while(itr.hasNext()){
				Student student=itr.next();
				%>
				
				<tr>
				<td><%= student.getId() %></td>
				<td><%= student.getName() %></td>
				<td><%= student.getMarks() %></td>
				
				<td><a href='#' class="btn btn-danger">Delete</a></td>
				</tr>
				<% 
			}
			
			
			%>
			
			
			</tbody>
			
			</table>
			<% 
		}
		
		
		%>
		
		</div>
		
 
</body>
</html>