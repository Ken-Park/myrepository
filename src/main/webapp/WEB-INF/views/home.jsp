<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>Home</title>
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<style>
div {
	border: 1px solid black;
	box-sizing: border-box;
}

#wrapper {
	width: 500px;
	height: 400px;
	text-align: center;
	line-height: 100px;
}

.box {
	width: 100%;
	height: 25%;
}

#idbox, #idinputbox {
	float: left;
}

#idbox {
	width: 30%;
	height: 100%;
}

#idinputbox {
	width: 70%;
	height: 100%;
}

#pwbox, #pwinputbox {
	float: left;
}

#pwbox {
	width: 30%;
	height: 100%;
}

#pwinputbox {
	width: 70%;
	height: 100%;
}

#inputid, #inputpw {
	width: 98%;
	height: 98%;
}
</style>
</head>
<body>
	<h1>어서오세요!</h1>


	<c:choose>
		<c:when test="${id eq null }">

			<form action="loginProc">
				<div id="wrapper">
					<div class="box">환영합니다!</div>
					<div class="box">
						<div id=idbox>아이디</div>
						<div id=idinputbox>
							<input type="text" id="inputid" name="id"
								placeholder=" 10자 이하 아이디를 입력하세요" maxlength="10">
						</div>
					</div>
					<div class="box">
						<div id=pwbox>비밀번호</div>
						<div id=pwinputbox>
							<input type="password" id="inputpw" name="pw"
								placeholder=" 10자 이하 비밀번호를 입력하세요" maxlength="10">
						</div>
					</div>
					<div class="box">
						<button type="button" id="joinMemberbtn">회원가입</button>
						<button id="loginbtn">로그인</button>
					</div>
					
				</div>
			</form>
			<div>
				${msg }
			</div>
			<script>
				$("#joinMemberbtn").on("click", function() {
					$(location).attr("href", "joinMemberForm")
				})
			</script>
		</c:when>
		<c:otherwise>
			<table>
				<tr>
					<td>${id }님 환영합니다.
				</tr>
				<tr>
					<td><button type="button" id="logoutbtn">로그아웃</button>
					<td><button type="button" id="chatbtn">채팅</button>
					<td><button type="button" id="mypagebtn">마이페이지</button>
					<td><button type="button" id="boardbtn">게시판</button>
				</tr>
			</table>
			<script>
			$("#logoutbtn").on("click", function() {
				$(location).attr("href", "logoutProc")
			})
			$("#chatbtn").on("click", function() {
				$(location).attr("href", "chatProc")
			})
			$("#mypagebtn").on("click", function() {
				$(location).attr("href", "myPageForm")
			})
			$("#boardbtn").on("click", function() {
				$(location).attr("href", "boardView")
			})
			</script>
			
		</c:otherwise>
	</c:choose>

</body>
</html>
