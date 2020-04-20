<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Form</title>
</head>
<body>
<form:form action="processForm" method="post" modelAttribute="student">
<label>First Name</label>
<form:input path="firstName" /><br>
<label>Last Name</label>
<form:input path="lastName" /><br>
<label>Email</label>
<form:input path="email" /><br>
<label>Country </label>
<form:select path="country">
<form:options items="${student.countryOptions}" />
</form:select><br/>
Favorite Language:	
<form:radiobutton path="favouriteLanguage" value="Java" />Java 
<form:radiobutton path="favouriteLanguage" value="C#" />C#
<form:radiobutton path="favouriteLanguage" value="PHP" />PHP
<form:radiobutton path="favouriteLanguage" value="Ruby" />Ruby
<br>
<input type="submit" value="Submit">
</form:form>
</body>
</html>