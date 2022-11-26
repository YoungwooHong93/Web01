<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <%@ page errorPage="ex01_errorMessage.jsp" %> --%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** Exception Test main **</title>
</head>
<body>
<pre><h3>
** Exception Test Main **
=> test1) WebPage 별로 : WebPage의 page디렉티브에서 정의
=> test2) 응답 상태코드별로 : web.xml
=> test3) Exception 별로 : web.xml 
=> test4) 에러처리의 우선순위 : 1 -> 3 -> 2 
<hr>
1) NullPointerException : Exception Type
* country : <%=request.getParameter("country").toUpperCase() %>
   getParameter에 "country"가 없으면 null
    -> Null return -> NullPointerException -> 500 -> errorPage에서 처리

2) NumberFormatException : 상태코드 500
* number : <%=Integer.parseInt(request.getParameter("country")) %>

3) ArithmeticException : Exception Type
   => by zero Test   
* 123 / 0 => <%=123 / 0 %>
	
</h3></pre>
</body>
</html>