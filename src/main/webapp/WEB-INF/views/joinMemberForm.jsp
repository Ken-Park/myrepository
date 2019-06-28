<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원가입</title>
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<style type="text/css">
table {
	border: 1px solid black;
	width: 600px;
	text-align: left;
}

tr, td {
	border: 1px solid black;
}
</style>
</head>
<body>
	<form id="form" action="joinMemberProc" method="post" enctype="multipart/form-data">
		<table>
			<tr>
				<td><input type=file name="image" id="imageInp">
			</tr>
			<tr>
				<td><img id="newImg" src="#" alt="프로필 이미지 미설정" />
			</tr>

			<tr>
				<td>아이디:</td>
				<td><input type="text" id="idtext" name="id" flag="false"
					distinct="false" required><span id="idresult"></span></td>

			</tr>
			<tr>
				<td>비밀번호:</td>
				<td><input type="password" id="pwtext" name="pw" required></td>
			</tr>
			<tr>
				<td>비밀번호 확인:</td>
				<td><input type="password" id="pwcheck" required></td>
			</tr>
			<tr>
				<td>이름:</td>
				<td><input type="text" id="nametext" name="name" required></td>
			</tr>
			<tr>
				<td>나이:</td>
				<td><input type="text" id="agetext" name="age" required></td>
			</tr>
			<tr>
				<td>주소:</td>
				<td><input type="text" id="addresstext" name="address" required></td>
			</tr>
			<tr>
				<td><button id="submitbtn">제출</button></td>
			</tr>
		</table>
	</form>
	<script>
		$("#idtext").on("input", function() {
			$.ajax({
				url : "idexist",
				data : {
					id : $("#idtext").val()
				}
			}).done(function(resp) {
				console.log(resp);

				if (resp == 1) {
					$("#idresult").html("사용가능");
					$("#idtext").attr("distinct", "true");

				} else {
					$("#idresult").html("ID중복");
					$("#idtext").attr("distinct", "false");
				}

			})
		})
		function readURL(input) {
			if (input.files && input.files[0]) {
				var reader = new FileReader();
				reader.onload = function(e) {
					$('#newImg').attr('src', e.target.result);
				}
				reader.readAsDataURL(input.files[0]);
			}
		}

		$("#imageInp").change(function() {
			readURL(this);
		});
	</script>

</body>
</html>