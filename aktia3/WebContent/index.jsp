<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">


<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>DB content</title>
</head>
<body>
	<form action="ListDb" method="get">
		<input type="submit" value="List DB entrys"></input>
	</form>
	<br>
	<br>
	<h3>Add Customer</h3>
	<form action="AddCustomer" method="post">
		<label>CustomerName : </label>
		<input type="text" name="customerName"><br>		
		<input type="submit" value="Send"></input>
	</form>
	<br>
	<br>
	<h3>Add Task</h3>
	<form action="AddTask" method="post">
		<label>CustomerId : </label>
		<input type="text" name="customerId"><br>
		<label>TaskDescription : </label>
		<input type="text" name="taskDescription"><br>
		<label>TaskDone (true/false) : </label>
		<input type="text" name="taskDone"><br>		
		<input type="submit" value="Send"></input>
	</form>
	<h3>Change taskDone status</h3>
	<form action="ChangeTaskStatus" method="post">
		<label>taskId : </label>
		<input type="text" name="taskId"><br>
		<label>New taskDone status : </label>
		<input type="text" name="taskDone"><br>	
		<input type="submit" value="Send"></input>
	</form>
</body>
</html>