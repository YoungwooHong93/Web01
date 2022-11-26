<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" 
    trimDirectiveWhitespaces="true"
    import="java.util.Arrays" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** Request Parameter Test **</title>
</head>
<body>
<pre><h3>
** Request Parameter Test **
** 당신의 정보
=> post 요청시에는 한글처리 필요함
<% request.setCharacterEncoding("utf-8"); %>

* I D => <%=request.getParameter("id")%>
* Name => <%=request.getParameter("name")%>
* 좋아하는 동물은 1 =>
<% 
	String[] pets = request.getParameterValues("pet");
	if ( pets!=null ) {
		for (String p:pets) {
			out.print("  "+p);
		} //for
	}else {
		out.print("~~ 선택한 동물이 없습니다 ~~");
	} //else
%>
<br><br>
* 좋아하는 동물은 2 => <%=Arrays.toString(pets)%>
* 좋아하는 동물은 3 =>
<% if (request.getParameterValues("pet")==null) {%>
	<%="선택한 동물이 없습니다 ~~"%>
	<% return; } %>
<%	for (String p:request.getParameterValues("pet")) {
	switch(p) {
	case "dog": p="강아지 "; break;
	case "cat": p="고양이 "; break;
	case "pig": p="꿀꿀이 "; break;
	case "eagle": p="독수리 "; break;
	default: break;
	} %>
	<%=p%>
<%}%>
</h3></pre>

</body>
</html>