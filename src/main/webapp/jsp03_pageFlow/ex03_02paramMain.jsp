<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** Jsp ActionTag Param Main **</title>
<%
	request.setCharacterEncoding("utf-8");
	String name = request.getParameter("name");
	// form 없이 퀴리스트링으로 Test ~~/ex03_02paramMain.jsp?name=홍길동 
	String menu = "짜장면";
	int price = 7000 ;
%>
</head>
<body>
<pre><h3>
** Jsp ActionTag Parameter Main **
=> Before Data Value
	* name = <%=name%>
	* menu = <%=menu%> 
	* price = <%=price%> 
--------------------------------------
<jsp:include page="ex03_01paramSub.jsp">
	<jsp:param value="<%=menu%>" name="menu"/>
	<jsp:param value="<%=price%>" name="price"/>
	<jsp:param value="탕수육" name="special"/>
	<jsp:param value="김길동" name="name"/>
</jsp:include>	
---------------------------------------
=> After Data Value
	* name1 = <%=request.getParameter("name")%>
	* name2 = <%=name%>
	* menu = <%=menu%> 
	* price = <%=price%> 
</h3></pre>
</body>
</html>