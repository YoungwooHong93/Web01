<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, mvcTest.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** StudentList MVC1_JSP **</title>
<%
	StudentService service = new StudentService();
	List<StudentVO> list = service.selectList();
%>
</head>
<body>
<h2>** StudentList MVC1_JSP **</h2>
<table width=100%>
	<tr bgcolor="lime">
		<th>snum</th>
		<th>sname</th>
		<th>age</th>
		<th>info</th>
		<th>jno</th>
		<th>id</th>
		<th>height</th>
	</tr>
<%
	if (list != null) {
		for (StudentVO s : list) { %>
			<tr>
				<td><%=s.getSnum()%></td>
				<td><%=s.getSname()%></td>
				<td><%=s.getAge()%></td>
				<td><%=s.getInfo()%></td>
				<td><%=s.getJno()%></td>
				<td><%=s.getId()%></td>
				<td><%=s.getHeight()%></td>
			</tr>
<%		} //for
	} else { %>
		<tr>
			<td colspan="7">** 출력 자료가 1건도 없습니다. **</td>
		</tr>
<%  } %>
</table>


</body>
</html>