<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Insert title here</title>
</head>
<body>
	<h3>Customer added</h3>
	<label>Customer id: </label>
	${customerId}
	<label>Customer id: </label>
	${customerName}
	<br>
	<h3>Add Task</h3>
	<form action="AddTask" method="post">
		<label>CustomerId : </label>
		<input type="text" name="customerId" required><br>
		<label>TaskDescription : </label>
		<input type="text" name="taskDescription" required><br>
		<label>TaskDone (true/false) : </label>
		<input type="text" name="taskDone"><br>		
		<input type="submit" value="Send"></input>
	</form>

</body>
</html>