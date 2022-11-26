<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** StudentDetail MVC2 **</title>
</head>
<body>
<h2>** StudentDetail MVC2 **</h2>
=> Request Student_snum : ${param.snum}<br>
<hr>
<c:if test="${empty apple}"> 
	<h3>=> 해당 학생의 자료가 없습니다.</h3>
</c:if>
<c:if test="${not empty apple}">
	<table>
		<tr height="40"><td bgcolor="Lavender">Snum</td><td>${apple.snum}</td></tr>
		<tr height="40"><td bgcolor="Lavender">Sname</td><td>${apple.sname}</td></tr>
		<tr height="40"><td bgcolor="Lavender">Age</td><td>${apple.age}</td></tr>
		<tr height="40"><td bgcolor="Lavender">Info</td><td>${apple.info}</td></tr>
		<tr height="40"><td bgcolor="Lavender">Jno</td><td>${apple.jno}</td></tr>
		<tr height="40"><td bgcolor="Lavender">Id</td><td>${apple.id}</td></tr>
		<tr height="40"><td bgcolor="Lavender">Height</td><td>${apple.height}</td></tr>
	</table>
</c:if>
</body>
</html>