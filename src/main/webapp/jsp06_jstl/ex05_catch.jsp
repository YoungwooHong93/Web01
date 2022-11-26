<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** catch Tag Test **</title>
</head>
<body>
<h3><pre>
** catch Tag Test **
=> 예외상황을 처리해 주는 Tag 
   비정상적 종료(500 오류)를 예방하고 대응하기 위함. 
=> java 
   try {
      .....
   }catch(Exception e) {
      .....
   }finally {
      ......
   }  
   
=> c:catch ~~ /c:catch 블럭에서 Exception 발생시 대응
=> 예외발생시 발생한 Exception 객체를 var의 값에 저장하고 catch블럭 밖으로 진행 
-----------------------------------------
** catch 블럭 밖에서 예외 발생 Test
=> Java 예외 발생 : 10/0 = <%=10/10%> : by Zero, 500 발생 
<c:catch var="e">
	** 예외 발생 전
	=> Java 예외 발생 : 10/0 => <%=10/10%> 
				    : by Zero 의 경우 500 발생 없이 계속 진행됨.
				    
	=> EL 예외 발생 : 10/0 => ${10/0}
		-> EL 연산의 나누기 연산은 실수형 연산으로 처리
		   Exception 발생 하지 않고, 결과는 Infinity
		   
		-> EL 의 % 연산 : 10%0 => ${10%10}
		   정수형 연산으로 처리하므로 by Zero Exception 발생
		   
		-> 실수형 Test : 10.0%0.0 => ${10.0%0.0}
	 	   실수형 연산으로 처리하므로 NaN 반환. Exception 발생하지 않음.
	** 예외 발생 후
</c:catch>
<!-- 
catch Tag 에 정의된 변수를 이용해서 오류를 확인할수있게해줌
=> null 이면 정상임을 의미
   아니면 오류발생을 의미 -->
<c:if test="${e != null}">
	=> 연산 도중 오류 발생 : ${e}
</c:if>

** Page 정상 종료 **
</pre></h3>

</body>
</html>