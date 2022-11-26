<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** JSTL Start **</title>
</head>
<body>
<pre><h3>
** JSTL Start **
=> Jstl Library 를 정의
   디렉티브 taglib 에 uri=".." prefix=".."
   
1. 출력 : out Tag
=> Java 의 out 객체, 표현식 역할 / EL 을 대신할 수 있음. (EL과 역할 동일)
<c:out value="~~ Hello JSTL !!!! ~~" />

2. 변수 정의
=> set
<c:set var="name" value="홍길동" /> 
<c:set var="age" value="22" />
=> Java 의 스크립트
<% String name = "Java_name"; %>
* Java 표현식 => <%= name %>

3. 변수 출력
=> Jstl 의 out Tag
* name => <c:out value="${name}" />
* age => <c:out value="${age}" />

=> 출력 우선순위 : value, default, 컨텐츠

* 1순위 Test
=> out 에서 default 와 컨텐츠를 동시 사용하면 : 500 오류가 발생됨.
<c:out value="Value_1순위" default="Default_2순위" />

* 2순위 Test : outTag _default
<c:out value="${name11}" default="Default_2순위" />

* 3순위 Test : setTag_컨텐츠
<c:set var ="test">setTag_컨텐츠</c:set>
* test_out : <c:out value="${test}" />

=> EL
\${name} => ${name}
\${age} => ${age}
\${age + 100} => ${age + 100}
\${test} => ${test}

4. 연산 적용
<c:set var="add" value="${age*5}" />
\${add} => ${add}
<c:set var="bool" value="${age == name}" />
\${bool} => ${bool}
<c:set var="max" value= "${age>add ? age : add}" />
\${max} => ${max}

5. 변수 삭제
=> remove
<c:remove var="age" />
\${empty_age} => ${empty age}
\${empty_add} => ${empty add}
\${empty_name} => ${empty name}
\${age} => ${age}

=> 정의하지 않은 변수 remove Test (오류는 발생하지 않음)
<c:remove var="age111" />

6. 우선순위
=> jstl 변수 와 Attribute 
=> 동일하게 Page에 정의된 경우에는 나중에 정의된 값이 우선 적용됨
   page(set변수, attribute 중 나중에 정의된 값 우선) -> request -> session -> application
<% //pageContext.setAttribute("name", "pageContext_name");
   request.setAttribute("name", "request_name");
%>
<c:set var="name" value="이길동" />
\${name} => ${name} 
</h3></pre>


</body>
</html>