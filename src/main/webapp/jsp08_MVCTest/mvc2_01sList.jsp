<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** StudentList MVC2 **</title>
</head>
<body>
<h2>** StudentList MVC2 **</h2>
<table width=100%>
	<tr bgcolor="aqua" height="40">
		<th>snum</th>
		<th>sname</th>
		<th>age</th>
		<th>info</th>
		<th>jno</th>
		<th>id</th>
		<th>height</th>
	</tr>
	<c:if test="${empty banana}">
		<tr>
			<td colspan="7">** 출력 자료가 1건도 없습니다. **</td>
		</tr>
	</c:if>
	<c:if test="${not empty banana}">
		<c:forEach var="member" items="${banana}">
			<tr height="40">
				<td><a href="/Web01/sdetail2?snum=${member.snum}">${member.snum}</a></td>
				<td>${member.sname}</td>
				<td>${member.age}</td>
				<td>${member.info}</td>
				<td>${member.jno}</td>
				<td>${member.id}</td>
				<td>${member.height}</td>
			</tr>
		</c:forEach>
	</c:if>
</table>

</body>
</html>