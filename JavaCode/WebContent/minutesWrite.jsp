<%@page import="com.model.MeetingDAO"%>
<%@page import="com.model.MemberDTO"%>
<%@page import="java.io.IOException"%>
<%@page import="java.io.FileReader"%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.BufferedReader"%>

<%@ page language="java" contentType="text/html; charset=utf-8"
   pageEncoding="utf-8"%>

<%@ page import="java.util.Date"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%
   Date nowTime = new Date();
   SimpleDateFormat sf = new SimpleDateFormat("yyyy년 MM월 dd일 a hh:mm:ss");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" type="text/css" href="assets/css/default.css">
<link rel="stylesheet" type="text/css" href="assets/css/minutes.css">
<title>회의록1</title>
<script type="text/javascript" src="assets/js/jquery.min.js"></script>

</head>

<body>
   <%
      String path1 = request.getParameter("path1");
      String path2 = request.getParameter("path2");
      String path3 = request.getParameter("path3");
      String path4 = request.getParameter("path4");
      String img = request.getParameter("img");
   %>
   
   <%   
      /* String path1 = "result";
      String path2 = "title";
      String path3 = "final";
      String path4 = "summary";
      String img = "wccorona"; */
      
      String imgPath = "result/wordcloud/"+img+".png"; // 워드클라우드
      
      ArrayList<String> pathList = new ArrayList<String>();
      pathList.add(path1); //스크립트
      pathList.add(path2); //안건
      pathList.add(path3); //결론
      pathList.add(path4); //내용
   
      ArrayList<String> strList1 = new ArrayList<String>(); //스크립트
      ArrayList<String> strList2 = new ArrayList<String>(); //안건
      ArrayList<String> strList3 = new ArrayList<String>(); //결론
      ArrayList<String> strList4 = new ArrayList<String>(); //내용
      
      // 텍스트 파일 읽기
      BufferedReader reader = null;
      for(int i=0; i < pathList.size(); i++){
         
         String filePath = "C:/Users/vdi02/STT/textResult/"+pathList.get(i)+".txt";
         /* String realPath = application.getRealPath(filePath); */
         try{
            reader = new BufferedReader(new FileReader(filePath));
            
            while(true){
               String str = reader.readLine();
               if(str == null) break;
               if(i==0){
                  strList1.add(str);
               } else if(i==1){
                  strList2.add(str);
               } else if(i==2){
                  strList3.add(str);
               } else {
                  strList4.add(str);
               }   
            }
            
         } catch(IOException e){
            e.printStackTrace();
         } finally{
            if(reader != null){
               reader.close();
            }
         }   
      }
   %>
   
   <% // title
      //for(int i = 0; i < strList2.size(); i++){
      //   out.print("<h1>"+ strList2.get(i) + "</h1>");
      //}
      
      // script
      //for(int i = 0; i < strList1.size(); i++){
      //   out.print(strList1.get(i));
      //}
      
      // summary
      //for(int i = 0; i < strList3.size(); i++){
      //   out.print(strList3.get(i));
      //}
      
      // final
      //for(int i = 0; i < strList4.size(); i++){
      //   out.print(strList4.get(i));
      //}
   %>

   <%
      MemberDTO member = (MemberDTO) session.getAttribute("member");
      MeetingDAO dao = new MeetingDAO();
   %>


<header>
      <h2 class="hide">대메뉴</h2>
      
      <div>
      <div class="logo"></div>
      <div class="tonghab">
      <div class="person"></div>
            <div class="user"><span ><%= member.getName() %> 님의 회의록</span></div>
            <nav class="three">
        
    </nav>   
       
</div>
      </div>   
   
   <div class="menubar">
   <ul>
      <li><a href="#" class= "up">.</a>
         <ul>
           <li><a href="#">제품정보</a></li>
           <li><a href="#">기업소개</a></li>
           <li><a href="#">멤버십</a></li>
           <li><a href="#">공지사항</a></li>
         </ul>
      </li>
      
   </ul>
</div>
      

   </header>



   <form action="SaveMinuteCon" method="post">
      <div class="contents">
         <table class="type1">

            <colgroup>
               <col style="width: 150px">
               <col>
            </colgroup>

            <span class="text1">회&nbsp;&nbsp;&nbsp;의&nbsp;&nbsp;&nbsp;록</span>
            <tr>
               <th>제목</th>
               <td colspan="3">
               <input  style="width: 550px; text-align: left;"  type="text" name="meeting_name" placeholder="회의 제목을 입력해주세요."></td>
               </tr>
               <tr>
               <th>일시</th>
               <td  width="250px"><input type="text" name="meeting_date"
                  placeholder="회의일시를 입력해주세요."></td>
               <th>장소</th>
               <td width="250px"><input type="text" name="meeting_place" 
                  placeholder="회의장소를 입력해주세요."></td>
            </tr>

            <tr>
               <th>작성자</th>
               <td>
                  <%=member.getName()%>
               </td>
               <th>작성일</th>
               <td><%=sf.format(nowTime)%></td>
            </tr>

            <tr>
               <th>참석자</th>
               <td>
                  <input type="text" name="joiner"placeholder="참석자를 입력해주세요.">      
               </td>
               <th>부서명</th>
               <td>
                  <input type="text" name="joiner_department" placeholder="부서명을 입력해주세요.">
               </td>
            </tr>


            <tr>
               <th class="contents1">안건</th>
               <td colspan="3">
               
                  <textarea name="meeting_title" rows="3" cols="100"
                     placeholder="안건을 입력해주세요."><%for(int i = 0; i < strList2.size(); i++){
                        out.print(strList2.get(i));
                     } %></textarea>
               </td>
            </tr>



            <tr>
               <th class="content">회의내용</th>
               <td colspan="3">
                  <!-- cols:너비 rows:높이--> 
                  <textarea name="meeting_summary" rows="25"
                  cols="100" placeholder="회의내용을 입력해주세요."><%for(int i = 0; i < strList4.size(); i++){
                                                      out.print(strList4.get(i));
                                                   }%></textarea>
               </td>
            </tr>


            <tr>
               <th class="contents2" >결론</th>
               <td colspan="3">
                  <!-- <input type="text" style="width: 100%" placeholder="옵션을 입력해주세요."> -->
                  <textarea name="meeting_final" rows="3" cols="100"
                  placeholder="결론을 입력해주세요."><%for(int i = 0; i < strList3.size(); i++){
                                             out.print(strList3.get(i));
                                           }%></textarea>
               </td>
            </tr>

            <tr>
               <th>
                  <input type="text" name="etc1_title" placeholder="추가1" style="width: 100%">
               </th>
               <td colspan="3">
                  <textarea name="etc1" rows="2" cols="100"></textarea>
               </td>
            </tr>

            <tr>
               <th>
                  <input type="text" name="etc2_title" placeholder="추가2" style="width: 100%">
               </th>
               <td colspan="3">
                  <textarea name="etc2" rows="2" cols="100"></textarea>
               </td>
            </tr>

         </table>
      </div>

      
         <input type="submit" class="btn" id="submit" name="submit" alt="submit" value="등&nbsp;&nbsp;&nbsp;록">
    
   


   </form>

   <form class="menu">
      <div class="keyword-item">
         <span class="text2" style="cursor: pointer">Keyword</span>
         <div class="Mtext">
            <img alt="asd" src=<%=imgPath%>>
         </div>

         <span class="text3">Script</span>
         <div class="script" style="overflow-y:scroll">
            <!-- <textarea rows="38" cols="67"style="overflow-x: hidden; overflow-y: auto;"></textarea> -->
            <!-- <table>
               <tr>
                  <td></td>
               </tr>
            </table> -->
            <%
               for (int i = 0; i < strList1.size(); i++) {
                  out.print(strList1.get(i));
               }
            %>
         </div>
      </div>
   </form>



   <script>
      // html dom 이 다 로딩된 후 실행된다.
      $(document).ready(function() {

         // menu 클래스 바로 하위에 있는 text2 클래스를 클릭했을때
         $(".menu .text2").click(function() {
            var submenu = $(this).next(".Mtext");

            // submenu 가 화면상에 보일때는 위로 보드랍게 접고 아니면 아래로 보드랍게 펼치기
            if (submenu.css('display') !== 'none') {
               submenu.slideUp();
            } else {
               submenu.slideDown();
            }
         });
      });
   </script>




</body>
</html>