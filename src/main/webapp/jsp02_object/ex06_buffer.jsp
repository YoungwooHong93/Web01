<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"    
	buffer="8kb" autoFlush="false"    
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** Buffer Test **</title>
</head>
<body>
<h3><pre>
** Buffer Test
=> 관련속성 (page 디렉티브)
	- buffer : 버퍼 사용여부 및 크기 지정
		8kb (기본),
		none (사용하지않음)
	- autoFlush : 버퍼가 다 찼을때 처리방식
		true (플러시하고 계속 작업)
		false (overflow Exception 발생)
		-> java.io.IOException: 오류: JSP 버퍼 오버플로우	
</pre></h3>
<% 
	// test1. 1Kb 이상 출력문
	// 1) buffer="1kb"
	// => autoFlush="false/true" 
	//    false : 버퍼가 다차면 무조건 IOException 발생
	//          -> ...java.io.IOException: 오류: JSP 버퍼 오버플로우...
	//    true : 잘 출력됨 
	// 2) buffer="8kb"
	// => autoFlush="false/true" : 용량이 충분하여 모두 잘 출력됨
	for (int i=0; i<1000; i++) {
	out.println("1234");
	} // for

	/* if (true) { 
		out.print("<br>*** Exception 발생 ***"); // Exception 발생시 중지됨 -> 500 Error 발생
		throw new Exception();
	} */
	// test2. 예외발생 코드 추가 
	// 1) buffer="1kb"
	// => autoFlush="false/true" 
	//    false : IOException 발생 ( ...java.io.IOException: 오류: JSP 버퍼 오버플로우... )
	//    true : 현재 Exception 발생 했지만 이미 채워진 버퍼는 플러시됨
	//           -> java.lang.Exception : console 로 확인.
	// 2) buffer="8kb"
	// => Exception() 코드가 있는경우 autoFlush="false/true" : Exception() 발생 (38행에 정의한)
	//    현재의 버퍼내에서 Exception 발생된 상태이므로 이 상태가 response 됨 (500)  
	// => Exception() 코드가 없는경우 autoFlush="false/true" : 끝까지 출력
%>
<hr>
*** Program Stop ***
</body>
</html>