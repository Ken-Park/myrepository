<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Write Board</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.4.0.min.js"></script>
<style>
div {
	border: 1px solid black;
	box-sizing: border-box;
	text-align: center;
}

#content {
	height: 300px;
}

textarea {
	width: 100%;
	height: 100%;
}

#subject input {
	width: 100%;
	height: 100%;
}
#newImg{
	width:300px;
	height:300px;
}
</style>
</head>
<body>
	<form action="writeProc" method="post" enctype="multipart/form-data">
	<div class="container border border-primary">
		<div class="row">
			<input type="hidden" name="number" value="1">
			<div class="col-lg-12 col-md-12 col-sm-12" id="subject">
				<input type="text" placeholder="제목을 입력해주세요" name="title">
			</div>
		</div>
		<div class="row">
			<div class="col-lg-12 col-md-12 col-sm-12" id="image">
				<input type=file name="image" id="imageInp"><span><img id="newImg" src="#" alt="이미지 미설정" /></span>
			</div>
		</div>
		<div class="row">
			<div class="col-lg-12 col-md-12 col-sm-12" id="content">
				<textarea placeholder="내용을 입력해주세요" name="contents"></textarea>
			</div>
		</div>
		<div class="row">
			<div id="fourthbox" class="col-lg-12 col-md-12 col-sm-12">
				<input type="submit" value="작성 완료" id="completebtn"> 
				<input type="button" value="목록으로" id="tolistbtn">
			</div>
		</div>
	</div>
	</form>
	<script>
		$("#tolistbtn").on("click",function(){
			$(location).attr("href","boardView")
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