<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP Study!</title>
</head>
<body>
	<h1>Hello World!</h1>
	<h3>${backNumber}</h3><!-- value가져오기 -->
	<h3>${name}</h3><!-- value가져오기 -->
	
	<!-- JSP IF문 -->
	<!-- c:if : JSP문법(jstl문법) 
		if는 있고 else는 없음 
		test : 조건식 -->
	<!-- 숫자 비교 -->
	<c:if test="${backNumber == 7}">
	<h4>대한민국 만세!</h4>
	</c:if>
	<!-- 문자 비교 -->
	<c:if test="${name.equals('손흥민')}">
	<h4>코리아 만세!</h4>
	</c:if>
	
	
	<!-- JSP if else를 구현하고 싶을 때 -->
		<!-- c:choose = if,else를 담기위한 컨테이너 -->
		<!-- c:when = if -->
		<!-- c:otherwise = else -->
		<h1 style="color:red">if, else 문</h1>
		<p style="font-size:25px">c:choose = if,else를 담기위한 컨테이너</p>
		<p style="font-size:25px">c:when = if</p>
		<p style="font-size:25px">c:otherwise = else</p>
	<c:choose>
		<c:when test="${size < 100}">
			<h4 style="color:red;">사이즈는 100 미만입니다.</h4>
		</c:when>
		<c:when test="${size >= 100 && size < 200}">
			<h4>사이즈는 200 미만입니다.</h4>
		</c:when>
		<c:otherwise>
			<h4>사이즈는 200 이상입니다.</h4>
		</c:otherwise>
	</c:choose>
	
	
	<!-- JSP 반복문(for문) -->
	<!-- 
	for(String str : wsgList){ 
	
	 *items="${wsgList}" === wsgList
	 *var="str" === str
	 
	} -->
	<h1 style="color:red">c:forEach문</h1>
		<h5>items="${wsgList}"을 변수 "str"에 담아서 출력</h5>
	<c:forEach items="${wsgList}" var="str">
		<h4>str : ${str}</h4>
	</c:forEach>
	
	<c:forEach items="${actorList}" var="actor">
	 	<h4>배우이름 : ${actor.name},</br> 배우나이 : ${actor.age}</h4>
	</c:forEach>
		<h2>이병헌만 출력 ==> ${actorList[0].name}, ${actorList[0].age}</h2>
		<h2>차승원만 출력 ==> ${actorList[1].name}, ${actorList[1].age}</h2>
		<h3>깃허브랑 연동했다???</h3>
	
	<c:forEach items="${mapList}" var="map">
		<h4>mapList의 no : ${map.no}번</h4>
	</c:forEach>
	
	
</body>
</html>