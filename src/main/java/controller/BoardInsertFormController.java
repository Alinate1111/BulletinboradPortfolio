package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BoardDAO;

public class BoardInsertFormController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 한글 처리
		request.setCharacterEncoding("utf-8");
		
		// 세션 확인
		HttpSession session = request.getSession();
		String loginId = (String)session.getAttribute("loginId");

		if(loginId == null || loginId.equals("")) {
			response.sendRedirect("../member/loginMemberForm.jsp");
		} else {
			BoardDAO boardDAO = BoardDAO.getInstance();
			int result = boardDAO.getMaxNum();
			session.setAttribute("result", result);
			response.sendRedirect("insertBoardForm.jsp");
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
