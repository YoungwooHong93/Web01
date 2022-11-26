<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** JSP Page Flow Test **</title>
</head>
<body>
<pre><h3>
** JSP Page Flow Test **
=> ex01_01flowForm.jsp 에서 전달된 값을 이용해서 
   Forward 또는 Redirect 테스트
=> this Page 는 출력 될까요 ?   
   ( 처리만 할뿐, 출력되지는 않음 )
=> 웹 페이지 이동(전환) 방법
   1) JavaCode : forward, redirect
   2) Jsp ActionTag : forward
   3) JSTL : redirect ( 다음 시간에.... )
   4) Html : meta Tag 로
   <!-- <meta charset="UTF-8" http-equiv="refresh" 
                  content="3;url=ex02_includeMain.jsp"> -->
   
=> Test 1) JavaCode : forward, redirect
<%
	String pageCode = request.getParameter("page");
	String uri ="";
	// server 내에서 경로설정이 다르기 때문에 서블릿으로 이동하는 경우
	// 1번은 forward 로, 2번은 redirect 로 test
	switch( pageCode ) {
		case "1" : uri ="/hello";
		break;
		
		case "2" : uri ="/Web01/gugu";
		break;
		
		case "3" : uri ="../jsp02_object/ex02_out.jsp";
		break;
		
		case "4" : uri ="../jsp02_object/ex04_application.jsp";
		break;
		
		default : out.print("** PageCode 를 정확하게 선택하지 않음 ~~");
	}
	// page 이동
	/* if (("f").equals(request.getParameter("send"))) {
		// Forward : 서버내에서 결과 웹 page가 바뀜 -> 요청한 url으로 변경 X
		request.getRequestDispatcher(uri).forward(request, response);
	} else {
		// Redirect : 재요청 처리 -> 요청한 url 로 변경됨.
		response.sendRedirect(uri);
	} */
%>
***********************************
=> Test 2) Jsp ActionTag : forward
=> 주소창에는 ex01_02flowMain.jsp 가 표시됨
<jsp:forward page="<%=uri%>" />

***********************************
</h3></pre>
</body>
</html>