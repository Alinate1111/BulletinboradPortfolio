package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BoardDAO;

public class BoardReplyFormController extends HttpServlet {
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
			// 댓글 처리
			int num = Integer.parseInt(request.getParameter("num"));
			int ref = Integer.parseInt(request.getParameter("ref"));
			int re_step = Integer.parseInt(request.getParameter("re_step"));
			int re_level = Integer.parseInt(request.getParameter("re_level"));
			// 페이지 번호 확인
			String pageNum = request.getParameter("pageNum");
			
			// DB 처리
			BoardDAO boardDAO = BoardDAO.getInstance();
			int result = boardDAO.getMaxNum();
			
			// 세션 저장, 이동
			session.setAttribute("num", num);
			session.setAttribute("ref", ref);
			session.setAttribute("re_step", re_step);
			session.setAttribute("re_level", re_level);
			session.setAttribute("pageNum", pageNum);
			session.setAttribute("result", result);
			response.sendRedirect("replyBoardForm.jsp");
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
