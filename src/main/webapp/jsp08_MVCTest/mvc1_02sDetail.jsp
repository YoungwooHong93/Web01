<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="mvcTest.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** StudentDetail MVC1_JSP **</title>
<%
	int snum = Integer.parseInt(request.getParameter("snum"));
	StudentService service = new StudentService();
	StudentVO vo = new StudentVO();
	vo.setSnum(snum);
	vo = service.selectOne(vo);
%>
</head>
<body>
<h2>** StudentDetail MVC1_JSP **</h2>
<%
	if ( vo == null ) { %>
	=>	<%=snum%> 해당 학생의 자료가 없습니다. <br>		
<%	} else { %>
	<table>
		<tr height="30">
			<td bgcolor="yellow">Snum</td>
			<td><%=vo.getSnum()%></td>
		</tr>
		<tr height="30">
			<td bgcolor="yellow">Sname</td>
			<td><%=vo.getSname()%></td>
		</tr>
		<tr height="30">
			<td bgcolor="yellow">Age</td>
			<td><%=vo.getAge()%></td>
		</tr>
		<tr height="30">
			<td bgcolor="yellow">Info</td>
			<td><%=vo.getInfo()%></td>
		</tr>
		<tr height="30">
			<td bgcolor="yellow">Jno</td>
			<td><%=vo.getJno()%></td>
		</tr>
		<tr height="30">
			<td bgcolor="yellow">Id</td>
			<td><%=vo.getId()%></td>
		</tr>
		<tr height="30">
			<td bgcolor="yellow">Height</td>
			<td><%=vo.getHeight()%></td>
		</tr>
	</table>
<%	} %>




</body>
</html>