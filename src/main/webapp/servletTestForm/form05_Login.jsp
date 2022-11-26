<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** Login Test **</title>
</head>
<body>
<h2>** Servlet : Member Login **</h2>
<form action="/Web01/mlogin" method=get>
<table>
<tr><td><label for=id> I D</label></td>
 	<td><input type="text" name=id id=id></td>
</tr>
<tr><td><label for=password> Password</label></td>
	<td><input type="password" name=password id=password></td>
</tr>
<tr><td></td>	
	<td><br>
	<input type="submit" value=로그인>&nbsp;&nbsp;
	<input type="reset" value="취소">
	</td>
</tr>	
</table>
</form>
<hr>
<% if (request.getAttribute("message") != null) {
	// message 출력 %>
	=> message : <%=request.getAttribute("message")%>
<% } %>	

</body>
</html>