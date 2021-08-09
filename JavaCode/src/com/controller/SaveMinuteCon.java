package com.controller;

import java.io.IOException;
import java.util.Random;

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

@WebServlet("/SaveMinuteCon")
public class SaveMinuteCon extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 회의록 DB에 저장하기
		
		request.setCharacterEncoding("utf-8");
		
		HttpSession session = request.getSession();
		MeetingDAO dao = new MeetingDAO();
		
		Random random = new Random();
		int tmp = random.nextInt(1000);
		
		MemberDTO member = (MemberDTO)session.getAttribute("member");
		// 회의록 코드
		String code = member.getDepartment_code() + tmp;
		/*
		 * while(true) { if (!dao.findSameCode(code)) { code =
		 * member.getDepartment_code() + tmp; }else { break; } }
		 */		
		String company_code = member.getCompany_code();
		String department_code = member.getDepartment_code();
		String writer_name = member.getName();
		String meeting_place = request.getParameter("meeting_place");
		String meeting_date = request.getParameter("meeting_date");
		String joiner = request.getParameter("joiner");
		String joiner_department = request.getParameter("joiner_department");
		String meeting_title = request.getParameter("meeting_title");
		String wordcloud = ""; // 받아온 워드클라우드 주소값 
		String meeting_summary = request.getParameter("meeting_summary");
		String meeting_final = request.getParameter("meeting_final");
		String etc1_title = request.getParameter("etc1_title");
		String etc1 = request.getParameter("etc1");
		String etc2_title = request.getParameter("etc2_title");
		String etc2 = request.getParameter("etc2");
		String meeting_name = request.getParameter("meeting_name");  // 이거 고쳐야함.
		

		int cnt = dao.saveMinute(new MeetingDTO(code, company_code, department_code, writer_name,
												meeting_place, meeting_date, joiner, joiner_department, meeting_title,
												meeting_summary, meeting_final, wordcloud, etc1_title, etc1,
												etc2_title,etc2,meeting_name));
		if (cnt > 0) {
			System.out.println("회의록 전송 성공");
		} else {
			System.out.println("회의록 전송 실패");
		}
		
		MeetingDTO read_minutes = new MeetingDTO(code, company_code, department_code, writer_name,
				meeting_place, meeting_date, joiner, joiner_department, meeting_title,
				meeting_summary, meeting_final, wordcloud, etc1_title, etc1,
				etc2_title,etc2,meeting_name);
		
		request.setAttribute("read_minutes", read_minutes);
        RequestDispatcher dispatcher = request.getRequestDispatcher("minutesDuplicate.jsp");
        dispatcher.forward(request, response);
	}

}
