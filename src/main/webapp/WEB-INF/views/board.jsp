<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP Study!</title>
<style>
table {
  font-family: arial, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

td, th {
  border: 1px solid #dddddd;
  text-align: left;
  padding: 8px;
}

tr:nth-child(even) {
  background-color: #dddddd;
}
</style>
</head>
<body>
	<button type="button" onclick="doLogout()">로그아웃</button>
 	<h1>${userId}님 환영합니다.</h1>
 	<input id="userNo" type="hidden" value="${userNo}">
	<!-- 문제. 테이블에 데이터 넣기  -->
	<table>
		<thead>
			<tr>
			    <th>Company</th>
			    <th>Contact</th>
			    <th>Country</th>
	 		</tr>
		</thead>
	 	<tbody>
		<!-- 함수를 사용하기 위해서는 fn:을 사용하여야한다. -->
		<!-- 지시자 부분 prefix="fn"이 function을 사용할 수 있게 해주는 지시문이다.(fn = function의 변수)-->
	 	<c:choose>
	 		<c:when test="${fn:length(data.list) > 0}">
			 	<c:forEach items="${data.list}" var="item">
				 		<tr>
						    <td>${item.get("Company")}</td>
						    <td>${item.Contact}</td>
						    <td>${item.Country}</td>
		  				</tr>
				</c:forEach>
	 		</c:when>
	 		<c:otherwise>
	 			<tr>
	 				<td colspan="3">데이터가 없습니다.</td>
	 			</tr>
	 		</c:otherwise>
	 	</c:choose>
	 	</tbody>
	</table>
	
	<script type="text/javascript">
	function doLogout(){
		location.href = "/logout"
	}
	</script>
	
</body>
</html>