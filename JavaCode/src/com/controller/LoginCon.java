package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.MemberDAO;
import com.model.MemberDTO;

@WebServlet("/LoginCon")
public class LoginCon extends HttpServlet {
   protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
      // 로그인
	  
	  request.setCharacterEncoding("utf-8");
      
      String id = request.getParameter("id");
      String pw = request.getParameter("pw");
      
      MemberDAO dao = new MemberDAO();
      MemberDTO member = dao.loginMember(id, pw);
      
      System.out.println(id + "/" + pw);
      
      if (member != null) {
         // 로그인 성공
         HttpSession session = request.getSession();
         session.setAttribute("member", member);
         
         System.out.println("로그인성공!!!");
         response.sendRedirect("main.jsp");
         
      } else {
         System.out.println("로그인 실패...");
         response.sendRedirect("login.html");
      }
      
      
      
   }

}