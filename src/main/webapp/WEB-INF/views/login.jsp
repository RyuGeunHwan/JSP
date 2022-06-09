<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<input Id="userId" type="text" palceholder="아이디를 입력하세요..."/>
	<input Id="userPassword" type="password" palceholder="비밀번호를 입력하세요..."/>
	<button type="button" onclick="doLogin()">로그인</button>
</body>
<script
      src="https://code.jquery.com/jquery-3.6.0.min.js"
      integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
      crossorigin="anonymous"
    ></script>
<script type="text/javascript">
	function doLogin(){
		// JQuery = $('#userId') & $('#userPassword')
		// 순수 자바스크립트(바닐라 자바스크립트)
		var userId = document.getElementById('userId').value;
		var userPassword = document.getElementById('userPassword').value;
		
		
		
		if(userId !== '' || userPassword !== ''){
			var jsonData = {
					userId : userId,
					userPassword : userPassword
			        }
			
			$.ajax({
		          url : '/login',
		          type : 'POST',
		          contentType : 'application/json',
		          dataType : 'json', //json으로 응답 받겠다.
		          data : JSON.stringify(jsonData),
		          success: function(response){
		            if(response){
		            	location.href = "/board";
		            }
		          }, error:function(request, statis, error){
		            console.log(error)
		          }
		        })// ajax end
		}
	
	}
</script>
</html>