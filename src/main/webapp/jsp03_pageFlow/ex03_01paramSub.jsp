<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** Jsp ActionTag Param Sub **</title>
</head>
<body>
<pre><h3>
** Jsp ActionTag Param Sub **
=> request 의 Parameter 형식으로 전달됨
   그러므로 request.getParameter("..") 로 처리하면 됨.
=> 전달된 Main 의 Data Value
	* name : <%=request.getParameter("name")%>
	-> 클라이언트의 요청 Parameter 확인 (유지됨)
	* menu : <%=request.getParameter("menu")%>	
	* price : <%=request.getParameter("price")%>	
	* special : <%=request.getParameter("special")%>	
	
=> 값 변경 Test
<% int price =Integer.parseInt(request.getParameter("price"))*5; %>
	* New price = <%=price%>	
</h3></pre>

</body>
</html>