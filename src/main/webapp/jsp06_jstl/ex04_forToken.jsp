<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** forTokens & PageFlow (import, redirect) **</title>
</head>
<body>
<h3><pre>
** 1. forTokens
=> 구분자로 분리된 각각의 토큰을 처리할때 사용됨.
=> test 1.1) 단일 구분자
	<c:forTokens var="city" items="서울,부산,용인,성남,Paris,NewYork" delims=",">
	${city}&nbsp;
	</c:forTokens>

=> test 1.2) 복수 구분자
	<c:forTokens var="city" items="서울,부산;용인!성남,Paris;NewYork" delims=",;!">
	${city}&nbsp;
	</c:forTokens>

** 2. import (WebPage가 포함됨)
=> jsp:include 와 동일
	(즉 실행결과 Page가 포함되므로 변수 공유 불가)
--------------------------------------
<%-- <c:import url="ex02_ifForm.jsp" /> --%>
<c:import var="iform" url="ex02_ifForm.jsp" />
${iform}
--------------------------------------
** 3. redirect
=> response.sendRedirect() 와 동일
=> 웹브라우져의 주소창의 url 이 변경됨
<%-- <c:redirect url="ex02_ifForm.jsp"  /> --%>

** 4. url
=> Value 를 url로 인식 시켜줌_set 으로 정의해도 결과는 동일
=> test 4.1) a_Tag Link
<%-- <c:url var="test" value="ex02_ifForm.jsp" /> --%>
<c:set var="test" value="ex02_ifForm.jsp" />

* test = ${test}
<a href="${test}" >urlTest_set</a>

=> test 4.2) image
</pre></h3>
<c:url var = "iname" value="../images/aaa.gif" />
<img alt="urlTest" src="${iname}">




</body>
</html>