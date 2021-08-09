package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.MeetingDAO;
import com.model.MeetingDTO;
import com.model.MemberDTO;

@WebServlet("/searchMinutesCon")
public class searchMinutesCon extends HttpServlet {

   protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
	  // 회의록 DB에서 꺼내오기 
	  
	  request.setCharacterEncoding("utf-8");
      MeetingDAO dao = new MeetingDAO();
      
      String meeting_name = request.getParameter("meeting_name");
      System.out.println(meeting_name);
      MeetingDTO read_minutes = null;
      read_minutes = dao.showMinutes(meeting_name);
      
      if(read_minutes == null) {
         response.setContentType("text/html; charset=UTF-8");
         PrintWriter out = response.getWriter();
         out.println("<script>alert('회의록이 존재하지 않습니다.');</script>");
         response.sendRedirect("main.jsp");   
      }else {
         request.setAttribute("read_minutes", read_minutes);
         RequestDispatcher dispatcher = request.getRequestDispatcher("minutesDuplicate.jsp");
         dispatcher.forward(request, response);
      }
      
      
   }

}