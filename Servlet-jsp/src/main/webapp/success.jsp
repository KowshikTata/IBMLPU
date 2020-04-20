<%@ page import="comm.example.model.ToDo" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Success</title>
</head>
<body>
<% 
//this space is called as scriptlet(same as errorservlet instead of view)
ToDo todo=(ToDo)request.getAttribute("todo");
out.println(todo.getId()+" , "+todo.getName()+" , "+todo.getCompletedBy());
%>
</body>
</html>