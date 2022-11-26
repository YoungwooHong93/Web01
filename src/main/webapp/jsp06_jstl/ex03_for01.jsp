<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** JSTL Loop(forEach) Test</title>
<%
	String [] menu = {"쌀국수","칼국수","막국수","비빔국수","짜장면","짬뽕","스파게티"} ;
	pageContext.setAttribute("menuList", menu);
%>

</head>
<body>
<pre><h3>
** JSTL Loop(forEach) Test **
1) forEach 구문 기본형식
=> java 의 forEach 와 유사
   for (String s:students) { ..... }
</h3></pre>
<c:forEach var="menu" items="${menuList}">
	${menu}&nbsp;
<%-- 	<c:out value="${menu}" /> --%>
</c:forEach>
<br>
<pre><h3>
2) varStatus 속성 활용
=> index, count, first, last 
</h3></pre>
<table border = "1" style="text-align:center; width:100%;">
	<tr>
		<th>menu</th>
		<th>index</th>
		<th>count</th>
		<th>first</th>
		<th>last</th>
	</tr>
	<c:forEach var="menu" items="${menuList}" varStatus="vs">
		<tr>
			<td>${menu}</td>
			<td>${vs.index}</td>
			<td>${vs.count}</td>
			<td>${vs.first}</td>
			<td>${vs.last}</td>
		</tr>
	</c:forEach>
</table>
<hr>
<pre><h3>
3) varStatus 속성 first, last 활용    
=> first, last : boolean Type
=> for , if(또는 choose) 중첩 구문
=> 실습과제
   . first 는 굵은 파랑으로 출력
   . ul li 를 이용해서 출력 하면서 메뉴이름뒤에 쉼표 표시,
   . 단, 마지막에는 마침표 표시  
</h3></pre>
=> for, if(또는 choose) 중첩 Test<br>
<ul>
<c:forEach var="menu" items="${menuList}" varStatus="vs">
	<c:choose>
		<c:when test="${vs.first}">
			<li style="color:blue; font-weight:bold;">${menu},</li>
		</c:when>
		<c:when test="${vs.last}">
			<li>${menu}.</li>
		</c:when>
		<c:otherwise>
			<li>${menu},</li>
		</c:otherwise>
	</c:choose>
</c:forEach>
</ul>


</body>
</html>