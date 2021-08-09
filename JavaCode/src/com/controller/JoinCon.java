package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.MemberDAO;
import com.model.MemberDTO;

@WebServlet("/JoinCon")
public class JoinCon extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 회원가입
		
		request.setCharacterEncoding("utf-8");
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		
		String company_name = request.getParameter("company_name");
		String department_name = request.getParameter("department_name");
		String position = request.getParameter("position");
		
		String phone1 = request.getParameter("phone1");
		String phone2 = request.getParameter("phone2");
		String phone3 = request.getParameter("phone3");
		String phone = phone1+phone2+phone3;
		
		String email1 = request.getParameter("email1");
		String email2 = request.getParameter("email2");
		String email = email1+"@"+email2;
		
		String company_code = request.getParameter("company_code");
		String department_code = request.getParameter("department_code");
		
		MemberDAO dao = new MemberDAO();
		int cnt = dao.joinMember(new MemberDTO(id, pw, name, 
												company_name, department_name, position, 
												phone, email, 
												company_code, department_code));
		if (cnt > 0) {
			System.out.println("회원가입 성공");
			response.sendRedirect("join3.html");
		} else {
			System.out.println("회원가입 실패");
		}
		
		
		
		
	}

}
