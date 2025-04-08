package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BoardDAO;
import vo.Board;

public class BoardUpdateFormController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 한글 처리
		request.setCharacterEncoding("utf-8");
		
		// 새션 확인
		HttpSession session = request.getSession();
		String loginId = (String)session.getAttribute("loginId");

		if(loginId == null || loginId.equals("")) {
			response.sendRedirect("../member/loginMemberForm.jsp");
		} else {
			// 글번호 획득
			int num = Integer.parseInt(request.getParameter("num"));
			// 페이지번호 획득
			String pageNum = request.getParameter("pageNum");
			
			// DB 처리
			BoardDAO boardDAO = BoardDAO.getInstance();
			Board board = boardDAO.getBoard(num);
			
			// 세션 저장, 이동
			session.setAttribute("board", board);
			session.setAttribute("pageNum", pageNum);
			response.sendRedirect("updateBoardForm.jsp");
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
