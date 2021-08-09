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

@WebServlet("/dmCodeCheck")
public class dmCodeCheck extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 부서코드 인증
		//System.out.println("부서코드 인증요청");
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");

		String dmCode = request.getParameter("dmCode");

		PrintWriter out = response.getWriter();
		Gson gson = new Gson();
		MemberDAO dao = new MemberDAO();

		out.println(gson.toJson(dao.dmCodeCheck(dmCode)));
	}

}
