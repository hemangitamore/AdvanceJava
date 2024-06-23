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
<div class="container mt-5">
    	<form action="StudentController" method="post">
    		<div class="row">
    			<div class="col-lg-4">
    				<div class="mb-3">
    					<label for="id" class="form-label">Id</label>
    					<input type="text" class="form-control" id="id" name="id">
  					</div>
    			</div>
    			<div class="col-lg-4">
    				<div class="mb-3">
    					<label for="name" class="form-label">Name</label>
    					<input type="text" class="form-control" id="name" name="name">
  					</div>
    			</div>
    		</div>
    		<div class="row">
    			<div class="col-lg-4">
    				<div class="mb-3">
    					<label for="marks" class="form-label">Marks</label>
    					<input type="text" class="form-control" id="marks" name="marks">
  					</div>
    			</div>
    			
    			
    		</div>
    		
    		<div class="row">
    			<div class="col-lg-4">
    				<input type="submit" class="btn btn-success" value="Add Student">
    			</div>
    		</div>
    	</form>
    </div>
     <div class="container">
    	<div class="row">
    		<div class="col-lg-4">
    		
    			<%
    			
    				if(request.getAttribute("msg")!=null){
    					%>
    					<div class="alert alert-success" role="alert">
  							<%=request.getAttribute("msg") %>
						</div>
    					<%
    				}
    				if(request.getAttribute("errormsg")!=null){
						%>
						<div class="alert alert-danger" role="alert">
							<%=request.getAttribute("errormsg") %>
						</div>
						<%
				}
    			%>
    		</div>
    	</div>
    </div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>

</body>
</html>