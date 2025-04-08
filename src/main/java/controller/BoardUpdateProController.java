package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BoardDAO;
import vo.Board;

public class BoardUpdateProController extends HttpServlet {
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
			// 페이지번호 확인
			String pageNum = request.getParameter("pageNum");

			// 객체 생성
			Board board = new Board();
			board.setNum(Integer.parseInt(request.getParameter("num")));
			board.setWriter(request.getParameter("writer"));
			board.setSubject(request.getParameter("subject"));
			board.setContent(request.getParameter("content"));
			board.setRef(Integer.parseInt(request.getParameter("ref")));
			board.setRe_step(Integer.parseInt(request.getParameter("re_step")));
			board.setRe_level(Integer.parseInt(request.getParameter("re_level")));
			
			// DB 처리
			BoardDAO boardDAO = BoardDAO.getInstance();
			boardDAO.updateBoard(board);
			
			// 세션 저장, 이동
			session.setAttribute("board", board);
			response.sendRedirect("getBoardList.do?pageNum=" + pageNum);
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
