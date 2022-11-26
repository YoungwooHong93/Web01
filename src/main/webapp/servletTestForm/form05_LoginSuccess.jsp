<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** Login Success **</title>
</head>
<body>
<h2>** Login Success **</h2>
<h2> ~~~ 안녕하세요 ~~~  </h2>
<pre>
=> request 값 확인 Test 
	I D : <%=request.getParameter("id")%> 
	Password : <%=request.getParameter("password")%> 
<hr>
=> Login 성공 확인 (Java의 표현식)
=> <%=session.getAttribute("LoginID")%>  <%=session.getAttribute("LoginName")%>님 반갑습니다 ~~ <br>
</pre>
<hr>
=> EL 적용 <br>
=> ${LoginName} 님 반갑습니다 ~~ <br>
<br><br><hr>
<a href="/Web01/logout">Logout</a>
<a href="/Web01/index.jsp">[Home]</a>
</body>
</html>