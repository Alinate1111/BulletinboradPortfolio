package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MemberDAO;
import vo.Member;

public class MemberLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 한글 처리
		request.setCharacterEncoding("utf-8");
		
		// 객체 생성
		Member member = new Member();
		member.setId(request.getParameter("id"));
		member.setPwd(request.getParameter("pwd"));
		
		// DB 처리
		MemberDAO memberDAO = MemberDAO.getInstance();
		int result = memberDAO.loginMember(member);

		// 세션 생성 -> 이동
		if(result == 1) {
			HttpSession session = request.getSession();
			session.setAttribute("loginId", member.getId());
			session.setAttribute("searchList", "all");
			response.sendRedirect("../board/getBoardList.do");
		} else {
			response.sendRedirect("loginMemberForm.jsp");
		}
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
}
