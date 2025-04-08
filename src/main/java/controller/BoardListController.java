package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BoardDAO;
import vo.Board;
import vo.Paging;

public class BoardListController extends HttpServlet {
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
			// 페이징 처리
			String pageNum = request.getParameter("pageNum");
			if(pageNum == null) pageNum = "1";
			int currentNum = Integer.parseInt(pageNum);
			
			// Paging 객체 생성
			Paging paging = new Paging();
			
			// 각 페이지의 시작글 번호, 끝글 번호
			paging.setPageSize(10);  // 한 페이지 당 10개의 글
			int startRow = (currentNum-1) * paging.getPageSize() + 1;
			int endRow = currentNum * paging.getPageSize();
			
			BoardDAO boardDAO = BoardDAO.getInstance();
			// 전체결과 또는 검색결과 세션 확인
			List<Board> boardList = null;
			String searchList = (String)session.getAttribute("searchList");
			String searchCondition = (String)session.getAttribute("searchCondition");
			String searchKeyword = (String)session.getAttribute("searchKeyword");
			int cnt = 0;
			if(searchList.equals("all")) {  // 검색 조건 없는 경우 -> 전체
				boardList = boardDAO.getBoardList(startRow, endRow);
				cnt = boardDAO.getBoardCount();
			} else if(searchList == null || searchList.equals("search")) {  // 검색 조건이 있는 경우
				session.setAttribute("searchList", "all");
				boardList = boardDAO.getBoardList(startRow, endRow, searchCondition, searchKeyword);
				cnt = boardList.size();
			}
			
			int totalPage = (cnt/paging.getPageSize()) + ((cnt%paging.getPageSize())==0 ? 0 : 1);
			//out.print(totalPage);  // 글수: 255, 페이지수: 26 
			
			// 매 페이지마다의 전체글수에 대한 역순 번호, 255 - (1-1)*10
			int number = cnt - ((currentNum-1) * paging.getPageSize());
						
			// 블럭에 대한 시작 페이지
			paging.setBlockPage(10);  // 한 페이지 당 블럭 10개
			int startPage = 1;
			if(currentNum%10 != 0) {
				startPage = (currentNum/paging.getBlockPage()) * paging.getBlockPage() + 1;
			} else if(currentNum%10 == 0) {
				startPage = (currentNum/paging.getBlockPage()-1) * paging.getBlockPage() + 1;
			}
			
			// 블럭에 대한 끝 페이지
			int endPage = startPage + paging.getBlockPage() - 1;
			if(endPage > totalPage) {
				endPage = totalPage; 
			}
			
			// Paging 객체에 값을 저장
			paging.setCnt(cnt);
			paging.setCurrentNum(currentNum);
			paging.setTotalPage(totalPage);
			paging.setStartPage(startPage);
			paging.setEndPage(endPage);
			System.out.print(paging);
			
			// BoardList, Paging, pageNum를 세션 객체 저장
			session.setAttribute("boardList", boardList);
			session.setAttribute("paging", paging);
			session.setAttribute("pageNum", pageNum);
			session.setAttribute("number", number);
			
			// 이동
			response.sendRedirect("getBoardList.jsp");
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
