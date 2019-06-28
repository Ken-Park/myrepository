<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<style>
	img{
		width:200px;
		height:200px;
	}
</style>
</head>
<body>
	<table>
		<tr>
			<td>프로필사진:</td>
		</tr>
		<tr>
			<td><img src="/resources/${result.imgaddr }"></td>
		</tr>
		<tr>
			<td>ID:</td>
			<td>${result.id }</td>
		</tr>
		<tr>
			<td>주소:</td>
			<td>${result.address }</td>
		</tr>
	</table>
</body>
</html>