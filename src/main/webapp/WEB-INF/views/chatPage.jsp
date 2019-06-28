<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ChatPage</title>
<style>
	div{
		border:1px solid black;
		box-sizing: border-box;
	}
	
	.container{
		width:400px;
		height:500px;
		margin:0 auto;
	}
	
	.contents{
		width:100%;
		height:85%;
		over-flow-y:auto;
	}
	.control{
		width:100%;
		height:15%;
	}
	
	.control>input[type=text]{
		height:100%;
		width:80%;
		box-sizing:border-box;
	}
	.control>input[type=button]{
		height:100%;
		width:18%;
		box-sizing:border-box;
	}
</style>
<script src="https://code.jquery.com/jquery-3.4.0.min.js"></script>
</head>
<body>
	<div class="container">
		<div class="contents">
		
		</div>
		<div class="control">
			<input type="text" id="input">
			<input type="button" id="send" value="send">
		</div>
	</div>
	
	<script>
		var socket = new WebSocket("ws://localhost/chat");
		
		socket.onmessage = function(evt){
			$(".contents").append(evt.data + "<br>")
		}//서버로부터 메세지가 도착한 경우
		
		$("#send").on("click",function(){
			var msg = $("#input").val();
			$("#input").val("");
			socket.send(msg);
		})//서버로 메세지를 보내는 경우
		
		
	</script>
</body>
</html>