<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** Include Sub **</title>
</head>
<body>
<pre><h3>
** Include Sub *******************
=> Main 의 변수 확인 
<%-- * mainValue = <%=mainValue%> --%>
( 실행시에는 오류 발생하지않음 )
=> Sub 변수 정의
<% String subValue = "짜장면"; %>
** Sub End ***********************
</h3></pre>
</body>
</html>