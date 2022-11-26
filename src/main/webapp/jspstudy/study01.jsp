<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>22.09.19 Study</title>
</head>
<body>
<pre><h3>
1. 변수 선언
<c:set var="name" value="홍영우"/>
<c:set var="age" value="31" />
<c:set var="height" value="178" />
<c:set var="weight" value="82" />
=> Java 의 스크립트
<%
	String name = "홍영우";
	int age = 31;
	int height = 178;
	int weight = 82;
%>
*Java 표현식
<%=name%> <br>
<%=age %> <br>
<%=height %> <br>
<%=weight %> <br>

2. 변수 출력
<c:out value="${name}" />
<c:out value="${age}" />
<c:out value="${height}" />
<c:out value="${weight}" />

3. 연산 적용
<c:set var="add1" value="${age}+${height}"/>
<c:set var="add2" value="${age+height}"/>
\${age}+\${height} => ${add1}

\${age+height} => ${add2}

\${age*weight} => ${age*weight}




</h3>
</pre>
</body>
</html>