<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Board</title>
<script src="https://code.jquery.com/jquery-3.4.0.min.js"></script>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<style>
	div {
	border: 1px solid black;
	box-sizing: border-box;
	text-align: center;
	}

	#fifthbox {
	text-align: right;
	}

	#a input {
	border: white;
	background-color: white;
	}
	#boardimg{
	width:50px;
	height:50px;
	}
</style>
</head>
<body>
	<div class="container border border-primary">
            <div class="row">
                <div class="col-lg-12 col-md-12 col-sm-12">자유게시판</div>
            </div>
            
            <div class="row">
                <div class="col-lg-1 col-md-2 col-sm-2">번호</div>
                <div class="col-lg-6 col-md-10 col-sm-10">title</div>
                <div class="col-lg-2 col-md-8 col-sm-8">writer</div>
                <div class="col-lg-2 col-md-2 col-sm-2">date</div>
                <div class="col-lg-1 col-md-2 col-sm-2">조회수</div>
            </div>
            
            <div class="row">
                <div class="col-lg-12 col-md-12 col-sm-12">
                
                <c:set var="count" value="1"></c:set>
                
                
                	<c:forEach var="i" items="${result }">
                		
                		<div class="row">
                		<div class="col-lg-1 col-md-2 col-sm-2" name="seq">
                		${i.prac_board_seq }
                		</div>
                		<div class="col-lg-6 col-md-10 col-sm-10">
                		<img alt="" src="${i.imgaddr }" id="boardimg">
                		<a href="contentView?number=${i.prac_board_seq }">${i.title }</a>
                		</div>
                		<div class="col-lg-2 col-md-8 col-sm-8">${i.writer }</div>
                		<div class="col-lg-2 col-md-2 col-sm-2">${i.writedate }</div>
                		<div class="col-lg-1 col-md-2 col-sm-2">${i.viewcount }</div>
                		</div>
                	</c:forEach>
                </div>
            </div>
            
            <div class="row">
                <div class="col-lg-12 col-md-12 col-sm-12">
                <c:forEach var="i" items="${navi }">
                
                <a href="selectAll.board?number=${i}">${i }</a>
               
                </c:forEach>
                </div>
            </div>
            
            <div class="row">
                <div id="fifthbox" class="col-lg-12 col-md-12 col-sm-12">
                <input type="button" value="글 쓰기" id="writebtn">
                <input type="button" value="돌아가기" id="backbtn">
                </div>
            </div>
        </div>
        <script>
        	$("#writebtn").on("click",function(){
        		$(location).attr("href", "boardWrite")
        	})
        	$("#backbtn").on("click",function(){
        		$(location).attr("href", "/")
        	})
        </script>
</body>
</html>