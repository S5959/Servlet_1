<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Board List</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<style type="text/css">
	.notice {
		width: 100%;
		max-width: 1200px;
		align: center;
		font-size: 40px;
	}
	.tbl {
		width: 100%;
		max-width: 1200px;
		margin: 100px auto;
	}
	.t1 .t2 .t3 .t4 {
		height: 45px;
	}
	.t1 {
		background-color: gray;
		font-style: bold;
		height: 45px;
		margin: 10px;
	}
	.t2 {
		height: 35px;
		border-bottom: gray 3px solid;
	}
	.t3 {
		height: 45px;
	}
	.t4 {
		height: 35px;
	}
	.no, .name, .date, .hit {
		width: 10%;
		text-align: center;
	}
	.sub {
		width: 60%;
		align: center;
		text-align: center;
	}
	.sub_ele {
		text-align: left;
		padding-left: 20px;
	}
	.btn {		
		text-align: center;
		background-color: #ADD8E6;
	}
	.btn_a {
		font-weight: bold;
		text-decoration: none;
		color: black;
	}
</style>
</head>
<body>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">WebSiteName</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="#">Home</a></li>
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Page 1 <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="#">Page 1-1</a></li>
          <li><a href="#">Page 1-2</a></li>
          <li><a href="#">Page 1-3</a></li>
        </ul>
      </li>
      <li><a href="#">Board</a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
      <li><a href="#"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
      <li><a href="#"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
    </ul>
  </div>
</nav>


<h1>Board List Page</h1>
	<table class="tbl">		
		<tr class="t1">
			<th class="no">No</th>
			<th class="sub">SUBJECT</th>
			<th class="name">NAME</th>
			<th class="date">DATE</th>
			<th class="hit">HIT</th>
		</tr>
		
		<c:forEach items="${boardList}" var="list">
		<tr class="t2">
			<td name="num" class="no"> ${list.num} </td>
			<td name="title" class="sub sub_ele"><b> ${list.title} </td>
			<td name="writer" width="20" align="center"> ${list.writer} </td>
			<td name="regDate" width="20" align="center"> ${list.regDate} </td>
			<td name="hit" width="20" align="center"> ${list.hit} </td>
		</tr>
		</c:forEach>
		
		<tr class="t3">
			<td colspan="5" align="center"> 《  &nbsp;〈  &nbsp; 1 &nbsp; | &nbsp; 2 &nbsp; | &nbsp; 3 &nbsp; | &nbsp; 4 &nbsp; | &nbsp; 5 &nbsp; 〉 &nbsp; 》 </td>
		</tr>
		<tr class="t4">
			<td colspan="4"></td>
			<td class="btn">
				<a href="./boardWrite.board" class="btn_a">글쓰기</a>
			</td>
		</tr>
	</table>
	
</body>
</html>