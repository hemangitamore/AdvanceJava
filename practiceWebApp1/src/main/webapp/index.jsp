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
 <div class="container">
    	<div class="alert alert-primary" role="alert">
  			Welcome to Student CRUD application
		</div>
    </div>
    <div class="container mt-5">
    	<div class="row">
    		<div class="col-lg-4">
    			<div class="card">
  					<div class="card-body">
    					<h5 class="card-title">Add Student</h5>
    					<p class="card-text">Click the button below to open registration form</p>
    					<a href="addStudent.jsp" class="btn btn-success">Add Student</a>
  					</div>
				</div>
    		</div>
    		<div class="col-lg-4">
    			<div class="card">
  					<div class="card-body">
    					<h5 class="card-title">Fetch Student</h5>
    					<p class="card-text">Click the button below to view all the students</p>
    					<a href="StudentController" class="btn btn-success">Fetch all Students</a>
  					</div>
				</div>
    		</div>
    	</div>
    </div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>