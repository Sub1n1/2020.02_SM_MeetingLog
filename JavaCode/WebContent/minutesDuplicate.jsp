<%@page import="com.model.MeetingDTO"%>
<%@page import="java.io.IOException"%>
<%@page import="java.io.FileReader"%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.BufferedReader"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="utf-8"%>

<%@ page import="java.util.Date"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%
   Date nowTime = new Date();
   SimpleDateFormat sf = new SimpleDateFormat("yyyy년 MM월 dd일");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" type="text/css" href="assets/css/default.css">
<link rel="stylesheet" type="text/css" href="assets/css/minutes2.css">
<title>회의록1</title>
<script type="text/javascript" src="assets/js/jquery.min.js"></script>

</head>

<body>

	<%
         MeetingDTO minutes = (MeetingDTO)request.getAttribute("read_minutes");
   %>

	<div class="contents">
		<table class="type1" style="width: 100%">

			<span class="text1">회&nbsp;&nbsp;&nbsp;의&nbsp;&nbsp;&nbsp;록</span>
			<tr>
				<th>제목</th>
				<td colspan="3" cols="50"><%= minutes.getMeeting_name() %></td>
			</tr>
			<tr>
				<th>일시</th>
				<td width="250px"><%= minutes.getMeeting_date()%></td>
				<th>장소</th>
				<td width="310px"><%= minutes.getMeeting_place()%></td>
			</tr>

			<tr>
				<th>작성자</th>
				<td><%= minutes.getWriter_name() %></td>
				<th>작성일</th>
				<td><%=sf.format(nowTime)%></td>
			</tr>

			<tr>
				<th>참석자</th>
				<td><%= minutes.getJoiner() %></td>
				<th>부서명</th>
				<td><%= minutes.getJoiner_department() %></td>
			</tr>


			<tr>
				<th class="contents1">안건</th>
				<td colspan="3"><%= minutes.getMeeting_title()%></td>
			</tr>



			<tr>
				<th class="content">회의내용</th>
				<td colspan="3"><%= minutes.getMeeting_summary()%></td>
			</tr>


			<tr>
				<th class="contents2">결정사항</th>
				<td colspan="3"><%= minutes.getMeeting_final()%></td>
			</tr>

			<tr>
				<th><%= minutes.getEtc1_title() %></th>
				<td colspan="3"><%= minutes.getEtc1() %></td>
			</tr>

			<tr>
				<th><%= minutes.getEtc2_title() %></th>
				<td colspan="3"><%= minutes.getEtc2() %></td>
			</tr>

		</table>
	</div>


	<a href="main.jsp#second"><div class="back" style="cursor: pointer;"></div></a>

</body>
</html>