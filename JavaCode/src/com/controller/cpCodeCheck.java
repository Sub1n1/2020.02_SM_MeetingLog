package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.model.MemberDAO;

@WebServlet("/cpCodeCheck")
public class cpCodeCheck extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 회사코드 인증
		//System.out.println("회사코드 인증요청");
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");

		String cpCode = request.getParameter("cpCode");

		PrintWriter out = response.getWriter();
		Gson gson = new Gson();
		MemberDAO dao = new MemberDAO();

		out.println(gson.toJson(dao.cpCodeCheck(cpCode)));
	}

}
