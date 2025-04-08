package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BoardDAO;
import vo.Board;

public class BoardIncreaseRecommController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 한글 처리
		request.setCharacterEncoding("utf-8");

		//세션 확인
		HttpSession session = request.getSession();
		String loginId = (String)session.getAttribute("loginId");

		if(loginId == null || loginId.equals("")) {
			response.sendRedirect("../member/loginMemberForm.jsp");
		} else {
			// 글번호
			int num = Integer.parseInt(request.getParameter("num"));
			
			// DB 처리
			BoardDAO boardDAO = BoardDAO.getInstance();
			boardDAO.increaseRecommcount(num);
			Board board = boardDAO.getBoard(num);
			
			// 추천에 대한 세션 생성 -> 조회수 증가 방지
			session.setAttribute("recommFlag", "1");
			session.setAttribute("board", board);
			response.sendRedirect("getBoard.do");
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
