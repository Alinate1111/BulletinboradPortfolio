package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MemberDAO;
import vo.Member;

public class MemberDeleteProController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 한글 처리
		request.setCharacterEncoding("utf-8");
		
		//  객체 생성
		Member member = new Member();
		member.setId(request.getParameter("id"));
		member.setPwd(request.getParameter("pwd"));
		
		// DB 처리
		MemberDAO memberDAO = MemberDAO.getInstance();
		int result = memberDAO.deleteMember(member);
		
		// 모든 세션 삭제 -> 이동
		HttpSession session = request.getSession();
		session.invalidate();
		if(result != 0) {
			response.sendRedirect("loginMemberForm.jsp");
		} else {
			response.sendRedirect("deleteMemberForm.do");
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
