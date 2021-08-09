
<%@page import="com.model.MeetingDTO"%>
<%@page import="com.model.MeetingDAO"%>
<%@page import="com.model.MemberDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<style>

</style>
<title>Insert title here</title>
<head>
		<title>Stellar by HTML5 UP</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<link rel="stylesheet" href="assets/css/main.css" />
		<noscript><link rel="stylesheet" href="assets/css/noscript.css" /></noscript>
	</head>
	<body class="is-preload">
  <%
      MemberDTO member = (MemberDTO) session.getAttribute("member");
      // 정수형태 데이터를 받아와야 할 때 Integer로 받아야 함.(int 안됨) 객체타입 => wrapper 클래스로 가져
      MeetingDAO dao = new MeetingDAO();
      ArrayList<MeetingDTO> minutes = null;

      if (member != null) {
         minutes = dao.selectMinutes(member.getCompany_code(), member.getDepartment_code());
      }
   %>

	<!-- Wrapper -->
			<!-- <div id="wrapper">

				Header
					<header id="header" class="alt">
						<span class="logo"><img src="images/logo.svg" alt="" /></span>
						<h1>View;roject</h1>
						<p>Just another free, fully responsive site template<br />
						built by <a href="https://twitter.com/ajlkn">@ajlkn</a> for <a href="https://html5up.net">HTML5 UP</a>.</p>
					</header>

	<!-- Banner -->
	<div id="banner">
		<div id="title">
			<h2>View:roject</h2>
			<%if (member != null){ %>
				<p><%=member.getName()%>님, 환영합니다</p>
			<%} %>
			<ul class="actions special">
			<%if(member == null) {%>
				<li><a href="login.html" class="button primary">Login</a></li>
				<li><a href="join1.html" class="button">Sign Up</a></li>
			<%} else {%>
				<li><a href="logout.jsp" class="button">Logout</a></li>
			<%} %>
			</ul>
		</div>
	</div>

	<!-- Nav -->
					<nav id="nav">
						<ul>
							<li><a href="#" class="active">home</a></li>
							<li><a href="#intro">Intro</a></li>
							<li><a href="#first">Process</a></li>
							<li><a href="#second">Lookup</a></li>
							<li><a href="#cta">Upload</a></li>
							<li><a href="#info">Information</a></li>
						</ul>
					</nav>

				<!-- Main -->
					<div id="main">

						<!-- Introduction -->
							<section id="intro" class="main">
								<div class="spotlight">
									<div class="content">
										<!-- <header class="major">
											<h2>AI, 어떻게 활용할 수 있을까요?</h2>
										</header>
										<p>View:roject는 STT(Speech To Text)엔진을 기반으로 한 회의록 자동 작성 서비스 플랫폼입니다.</p>
										<ul class="actions">
											<li><a href="generic.html" class="button">Learn More</a></li>
										</ul> -->
									</div>
									<!-- <span class="image"><img src="images/pic01.jpg" alt="" /></span> -->
								</div>
							</section>

						<!-- First Section -->
							<section id="first" class="main special">
								<header class="major">
									<h2>Process</h2><br>
								</header>
								<ul class="features">
									<div class="process"></div>
								</ul>
							</section>

						<!-- Second Section -->
							<section id="second" class="main special">
								<header class="major">
									<h2>Lookup</h2><br>
									
								</header>
							
			<div style="width:100%; height:500px; overflow: auto;" >
				<table border="0";>
					<tr>
						<td align="center">제목</td>
						<td align="center">회의일시</td>
						<td align="center">작성자</td>
						<td align="center">작성일</td>
					</tr>
					<%if(member == null){ %>
					<tr>
						<td colspan="4" align="center">로그인 후 이용해주세요.</td>	
					</tr>
					
					<%} else {%>	
						<%if(!minutes.isEmpty()){ %>
							  <%for(int i=0; i<minutes.size(); i++){
			                        out.print("<tr>");
			                        out.print("<td align = 'left'>" +"<a href = 'searchMinutesCon?meeting_name="+minutes.get(i).getMeeting_name()+"'>" +minutes.get(i).getMeeting_name() + "</a>" +"</td>");
			                        out.print("<td align = 'left'>" + minutes.get(i).getMeeting_date() + "</td>");
			                        out.print("<td align = 'left'>" + minutes.get(i).getWriter_name() + "</td>");
			                        out.print("<td align = 'left'>" + minutes.get(i).getWrite_date() + "</td>");
			                        out.print("</tr>");
	                     		} %>
						<%} else {%>
							<tr>
								<td colspan="4">회의록이 없습니다.</td>
							</tr>
						<%} %>
					<%} %>
					</table>
				</div>
					<div>
					<form action="searchMinutesCon" method="post">
						<table>
						<tr>
							<td style="height: 50px">회의제목</td>
							<td colspan="2"><input type="text" name="meeting_name"></td>
							<td><input type="submit" value="검색" id="search"></td>
						</tr>
						</table>
					</form>
					</div>			
				

			<!-- <p class="content">Nam elementum nisl et mi a commodo porttitor. Morbi sit amet nisl eu arcu faucibus hendrerit vel a risus. Nam a orci mi, elementum ac arcu sit amet, fermentum pellentesque et purus. Integer maximus varius lorem, sed convallis diam accumsan sed. Etiam porttitor placerat sapien, sed eleifend a enim pulvinar faucibus semper quis ut arcu. Ut non nisl a mollis est efficitur vestibulum. Integer eget purus nec nulla mattis et accumsan ut magna libero. Morbi auctor iaculis porttitor. Sed ut magna ac risus et hendrerit scelerisque. Praesent eleifend lacus in lectus aliquam porta. Cras eu ornare dui curabitur lacinia.</p> -->
								<!-- <footer class="major">
									<ul class="actions special">
										<li><a href="generic.html" class="button">Learn More</a></li>
									</ul>
								</footer> -->
							</section>

						<!-- Get Started -->
							<section id="cta" class="main special">
								<header class="major">
									<h2>Upload</h2><br>
									<p>하단의 버튼을 클릭하여 녹음파일을 업로드해주세요<br>회의 내용을 분석하여 회의록을 간편하게 작성할 수 있도록 도와드립니다</p>
								</header>
								<footer class="major">
		                          <!--  <ul class="actions special"> 
		                             <li><a href="" onclick="javascript:openWin();" class="button primary">회의록 작성</a></li>
		                           </ul> -->
		                            <div class="small">
									   <form action="http://localhost:9000/fileupload" method="post" enctype="multipart/form-data">
									      <input type="file" name="file">
									      <input type="submit" value="회의록 작성">  
									   </form>
									  </div>
                       			 </footer>
								</section>
	
								<section id="info" class="main special">
									<header class="major">
										<h2>Information</h2>
										<p></p>
									</header>
									<ul class="features">
										<div class="info"></div>
									</ul>
									
								</section>
							</div>

				<!-- Footer -->
					<footer id="footer">
						<section>
							<h2 style="color:#000;">PBL기반 빅데이터 분석 서비스 전문가 과정</h2>
							<p>View:roject is an automatic meeting book creation service platform based on a Speed To Text (STT) engine.
A longer meeting than meeting time view:roject dramatically reduces the amount of time needed to Check out your changed project View:roject</p>
							<ul class="actions">
								<li><a href="generic.html" class="button">Learn More</a></li>
							</ul>
						</section>
						<section>
							<h2>Etiam feugiat</h2>
							<dl class="alt">
								<dt>Address</dt>
								<dd> 광주광역시 북구 용봉로 77(용봉동) 전남대학교</dd>
								<dt>Phone</dt>
								<dd>(000) 000-0000 x 0000</dd>
								<dt>Email</dt>
								<dd><a href="#">bsoo@smartmedia.com</a></dd>
							</dl>
							<ul class="icons">
								<li><a href="#" class="icon brands fa-twitter alt"><span class="label">Twitter</span></a></li>
								<li><a href="#" class="icon brands fa-facebook-f alt"><span class="label">Facebook</span></a></li>
								<li><a href="#" class="icon brands fa-instagram alt"><span class="label">Instagram</span></a></li>
								<li><a href="#" class="icon brands fa-github alt"><span class="label">GitHub</span></a></li>
								<li><a href="#" class="icon brands fa-dribbble alt"><span class="label">Dribbble</span></a></li>
							</ul>
						</section>
						<!-- <p class="copyright">&copy; Untitled. Design: <a href="https://html5up.net">HTML5 UP</a>.</p> -->
					</footer>

			</div>
			
<script> 
/* function openWin(){  
    window.open("http://localhost:8082/Viewroject/fileUpload.jsp", "파일업로드", "width=500, height=300, toolbar=no, menubar=no, scrollbars=no, resizable=yes" );  
}   */
 
</script>

		<!-- Scripts -->
			<script src="assets/js/jquery.min.js"></script>
			<script src="assets/js/jquery.scrollex.min.js"></script>
			<script src="assets/js/jquery.scrolly.min.js"></script>
			<script src="assets/js/browser.min.js"></script>
			<script src="assets/js/breakpoints.min.js"></script>
			<script src="assets/js/util.js"></script>
			<script src="assets/js/main.js"></script>

	</body>
</html>