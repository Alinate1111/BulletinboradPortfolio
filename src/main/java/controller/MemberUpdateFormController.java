package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MemberDAO;
import vo.Member;

public class MemberUpdateFormController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 한글 처리
		request.setCharacterEncoding("utf-8");
		
		//로그인 처리에서 생성한 세션을 확인
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("loginId");
		if(id == null || id.equals("")) {
			response.sendRedirect("loginMemberForm.jsp");
		} else {
			MemberDAO memberDAO = MemberDAO.getInstance();
			Member member = memberDAO.getMember(id);
			session.setAttribute("member", member);
			response.sendRedirect("updateMemberForm.jsp");
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
