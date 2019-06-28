<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Content</title>
<style>
table, tr, td {
	border: 1px solid black;
}

#btndiv {
	margin-bottom: 50px;
}

#replyarea {
	width: 400px;
	height: 50px;
}
</style>
<script src="https://code.jquery.com/jquery-3.4.0.min.js"></script>
</head>
<body>
	<table>
		<tr>
			<td>번호
			<td>제목
			<td>내용
			<td>작성자
			<td>작성 시간
		</tr>
		<tr>
			<td>${result.prac_board_seq }
			<td>${result.title }
			<td>${result.contents }
			<td>${result.writer }
			<td>${result.writedate }
		</tr>
	</table>

	<div id="btndiv">
		<input type='button' id='backbtn' value='돌아가기'> 
	</div>

	<table>

		<c:forEach var="i" items="${result2 }">
			<tr>
				<td>댓글 <input type="hidden" name="prac_reply_seq" value="${i.prac_reply_seq }">
				
				<td>작성자:${i.reply_writer }
		
				<td>댓글:${i.reply_contents }
		
				<td>작성일자:${i.reply_writedate}
				
				<td><button type="button" class="deletebtn">삭제</button>
	
			</tr>
	</c:forEach>
	</table>
	
	<form action="replyProc">
	<input type="hidden" name="prac_board_seq" value="${result.prac_board_seq }">
	<div class="container border border-primary">
		<div class="row">
			<div class="col-lg-12 col-md-12 col-sm-12" id="content">
				<textarea placeholder="내용을 입력해주세요" name="reply_contents" id="replyarea"></textarea>
			</div>
		</div>
		<div class="row">
			<div id="fourthbox" class="col-lg-12 col-md-12 col-sm-12">
				<button id="replybtn">댓글달기</button> 
			</div>
		</div>
	</div>
	</form>
	
	<script>
		$("#backbtn").on("click", function() {
			$(location).attr("href", "boardView")
		})
		$(".deletebtn").on("click",function(){
			$(location).attr("href","replyDelete?number=" + $(this).parent().parent().find("td:nth-child(1)").find("input:nth-child(1)").val() 
					+ "&seq=" + ${result.prac_board_seq })
		})
	</script>
	</body>
</html>