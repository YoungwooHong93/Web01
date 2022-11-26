<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** Jsp Object Test : Request Information **</title>
</head>
<body>
<pre><h2>
** Request 객체 Information **

=> Web 기본 객체(implicit object)
=> JSP에서 별도 선언 없이 사용 가능
=> request, response, out, session, 
   pageContext, application 등 9종류

* ContextPath => <%=request.getContextPath()%>
* getMethod => <%=request.getMethod()%>
* RequestURL => <%=request.getRequestURL()%> 
* RequestURI => <%=request.getRequestURI()%> 
* ServletPath => <%=request.getServletPath()%> 
* ServerPort => <%=request.getServerPort()%> 
* ServerName => <%=request.getServerName()%>
</h2></pre>

</body>
</html>