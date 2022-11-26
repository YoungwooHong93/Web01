<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** 구구단 1단 부터 9단 까지 **</title>
<!--  Html 주석문 -->
<%--  Jsp 주석문 --%>
</head>
<body>
	<h2>구구단</h2>
	<%
	// 구구단 출력하기 2
	// => Java Tag 들은 계층구조가 아님
	for (int i = 1; i <= 9; i++) {%>
	<%for (int j = 2; j <= 9; j++) {%>
	<%=j + " * " + i + " = " + (i * j)%>&nbsp;&nbsp;
	<%}%>
	<br>
	<%}%>

</body>
</html>