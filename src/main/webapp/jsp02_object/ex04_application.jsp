<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** Jsp Object : application **</title>
</head>
<body>
<pre><h2>
** Jsp Object : application **
=> 웹 어플리케이션에 대한 정보를 저장

1) 초기화 파라미터 Name & Value
=> 초기화 파라미터는 web.xml(설정화일) 에 등록함
   context-param Tag ~~
<ul>
<% 	Enumeration<String> ipnames = application.getInitParameterNames(); 
	while (ipnames.hasMoreElements()) {
		String ipname = ipnames.nextElement();
%>		
		<li><% out.print(ipname+"="+application.getInitParameter(ipname));
	} // while%>
</ul>
2) 서버 정보
* 서버정보 : <%=application.getServerInfo()%>
* 서블릿규약 메이저버전 : <%=application.getMajorVersion()%>
* 서블릿규약 마이너버전 : <%=application.getMinorVersion()%>
=> 버전 : 메이져버전.마이너버전
		( 메이져버전 이 변경되면 버젼간의 호환이 안됨 )

3) 리소스(Resources) 정보  
=> getRealPath() : 매개변수에 따른 realPath return

* RealPath 1 : <%=application.getRealPath("")%>
			-> "" 사용시에는 현재 프로젝트의 realPath return
* RealPath 2 : <%=application.getRealPath("/jsp02_object")%>
			-> 지정한 경로의 시스템상에서의 realPath return

=> getResource() : => 매개변수에 따른 URL객체 return  
* Resource 1 : <%=application.getResource("") %> 
   			-> "" 사용시에는 현재 프로젝트의 URL객체 return
* Resource 2 : <%=application.getResource("/jsp02_object") %> 
   			-> 지정한 경로에 접근 할 수 있는 URL객체 return
   			
</h2></pre>
</body>
</html>