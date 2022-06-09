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
<h1>HOME 화면</h1>
<button type="button" onclick="movePage()">게시판 화면 이동</button>
</body>
<script type="text/javascript">
function movePage(){
	 location.href = "/board"; //Controller에 있는 주소를 입력하면 됨.
}
</script>
</html>