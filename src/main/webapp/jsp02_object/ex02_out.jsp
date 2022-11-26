<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Date" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** out 객체 Test **</title>
</head>
<body>
<pre><h2>
** out 객체 Test **
=> Jsp 출력 3종류
	1) html 컨텐츠
	2) Java 표현식
		-> 지금은 <%=new Date()%> 
	3) Java 의 out 객체
	<% out.print("~~ out 객체를 이용한 출력 ~~"); %>
</h2></pre>

</body>
</html>