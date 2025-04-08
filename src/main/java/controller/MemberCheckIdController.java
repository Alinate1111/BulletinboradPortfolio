package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MemberDAO;

public class MemberCheckIdController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 한글 처리
		request.setCharacterEncoding("utf-8");
		
		// id 채크
		String id = request.getParameter("id");

		MemberDAO memberDAO = MemberDAO.getInstance();
		int result = memberDAO.checkMemberId(id);

		// 이동
		//result: 1(중복 아이디가 있음, 추가하는 아이디는 사용불가), 0(중복 아이디가 없음, 추가하는 아이디는 사용가능)
		HttpSession session = request.getSession();
		session.setAttribute("chkId", id);
		if(result == 0) {
			session.setAttribute("chkNum", "0");
			response.sendRedirect("insertMemberForm.jsp");
		} else {
			session.setAttribute("chkNum", "1");
			response.sendRedirect("insertMemberForm.jsp");
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
