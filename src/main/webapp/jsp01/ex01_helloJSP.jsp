<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** Hello JSP **</title>
</head>
<body>
	<h2>** Hello JSP **</h2>
	<h2>=> 안녕하세요 !!! ~~~</h2>
	<h2>** Hello Java **</h2>
	<%
	int i = 100;
	String name = "홍길동";
	%>
	<h3>
		i * 2 =
		<%=i * 2%></h3>
	<h3>
		name =
		<%=name%></h3>
	<hr>
	<h3>** JSP 장점 : View 작성 매우편리, 가독성 좋음</h3>
	<h3>** JSP 단점 : Java Code 작성 불편</h3>
</body>
</html>