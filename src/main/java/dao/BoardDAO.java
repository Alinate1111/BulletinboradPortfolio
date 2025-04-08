package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import common.DBConnPool;
import vo.Board;

// board 테이블의 데이터를 처리하는 클래스
public class BoardDAO {
	// 싱글턴 패턴
	private static BoardDAO instance = new BoardDAO();
	
	private BoardDAO() { };
	
	public static BoardDAO getInstance() {
		return instance;
	}
	
	// DB 연동 객체
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	// 전체 글수 구하기
	public int getBoardCount() {
		String sql = "select count(*) from board";
		int cnt = 0;
		
		try {
			conn = DBConnPool.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				cnt = rs.getInt(1);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("+++ getBoardCount() 메서드 에러 +++");
		} finally {
			DBConnPool.close(conn, pstmt, rs);
		}
		return cnt;
	}
	
	// 게시판 보기(전체) - 페이징 처리
	public List<Board> getBoardList(int start, int end) {
		List<Board> boardList = new ArrayList<Board>();
		Board board = null;
		String sql = "select * from ( "
			+ " select b.*, row_number() over(order by ref desc, re_step asc) rnum from board b "
			+ " ) where rnum between ? and ?";
		
		try {
			conn = DBConnPool.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				board = new Board();
				board.setNum(rs.getInt("num"));
				board.setWriter(rs.getString("writer"));
				board.setSubject(rs.getString("subject"));
				board.setContent(rs.getString("content"));
				board.setReg_date(rs.getString("reg_date"));
				board.setReadcount(rs.getInt("readcount"));
				board.setRecommcount(rs.getInt("recommcount"));
				board.setRef(rs.getInt("ref"));
				board.setRe_step(rs.getInt("re_step"));
				board.setRe_level(rs.getInt("re_level"));
				boardList.add(board);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("+++ getBoardList() 메서드 에러 +++");
		} finally {
			DBConnPool.close(conn, pstmt, rs);
		}
		return boardList;
	}
	
	// 게시판 보기(전체) - 페이징 처리 + 검색 기능
	public List<Board> getBoardList(int start, int end, String searchCondition, String searchKeyword) {
		List<Board> boardList = new ArrayList<Board>();
		Board board = null;
		String sql = "select * from ( "
			+ " select b.*, row_number() over(order by ref desc, re_step asc) rnum from board b ";
		
		if(searchCondition.equals("subject")) {
			sql += " where subject like '%'||?||'%'";
		} else if(searchCondition.equals("content")) {
			sql += " where content like '%'||?||'%'";
		} else if(searchCondition.equals("sandc")) {
			sql += " where subject like '%'||?||'%' or content like '%'||?||'%'";
		}
		sql += " ) where rnum between ? and ?";
		
		try {
			conn = DBConnPool.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			if(searchCondition.equals("subject") || searchCondition.equals("content")) {
				pstmt.setString(1, searchKeyword);
				pstmt.setInt(2, start);
				pstmt.setInt(3, end);
			} else if(searchCondition.equals("sandc")) {
				pstmt.setString(1, searchKeyword);
				pstmt.setString(2, searchKeyword);
				pstmt.setInt(3, start);
				pstmt.setInt(4, end);
			}
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				board = new Board();
				board.setNum(rs.getInt("num"));
				board.setWriter(rs.getString("writer"));
				board.setSubject(rs.getString("subject"));
				board.setContent(rs.getString("content"));
				board.setReg_date(rs.getString("reg_date"));
				board.setReadcount(rs.getInt("readcount"));
				board.setRecommcount(rs.getInt("recommcount"));
				board.setRef(rs.getInt("ref"));
				board.setRe_step(rs.getInt("re_step"));
				board.setRe_level(rs.getInt("re_level"));
				boardList.add(board);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("+++ getBoardList(searchCondition, searchKeyword) 메서드 에러 +++");
		} finally {
			DBConnPool.close(conn, pstmt, rs);
		}
		for(Board b : boardList) {
			System.out.println(b);
		}
		return boardList;
	}
	
	// 게시글 보기(1건)
	public Board getBoard(int num) {
		Board board = new Board();
		String sql = "select * from board where num=?";
		
		try {
			conn = DBConnPool.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				board.setNum(rs.getInt("num"));
				board.setWriter(rs.getString("writer"));
				board.setSubject(rs.getString("subject"));
				board.setContent(rs.getString("content"));
				board.setReg_date(rs.getString("reg_date"));
				board.setReadcount(rs.getInt("readcount"));
				board.setRecommcount(rs.getInt("recommcount"));
				board.setRef(rs.getInt("ref"));
				board.setRe_step(rs.getInt("re_step"));
				board.setRe_level(rs.getInt("re_level"));
			}
			
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("+++ getBoard() 메서드 에러 +++");
		} finally {
			DBConnPool.close(conn, pstmt, rs);
		}
		return board;
	}
	
	// 글번호의 최대값 구하기
	public int getMaxNum() {
		String sql = "select max(num) from board";
		int result = 0;
		
		try {
			conn = DBConnPool.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = rs.getInt(1);
			}
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("+++ getMaxNum() 메서드 에러 +++");
		} finally {
			DBConnPool.close(conn, pstmt, rs);
		}
		return result;
	}
	
	// 다음 시퀀스값 구하기
	public int getNextSequence() {
		String sql = "select board_seq.nextval from dual";
		int nextval = 0;
		
		try {
			conn = DBConnPool.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				nextval = rs.getInt(1);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("+++ getNextSequence() 메서드 에러 +++");
		} finally {
			DBConnPool.close(conn, pstmt, rs);
		}
		return nextval;
	}
	
	// 글등록
	public void insertBoard(Board board) {
		int nextval = getNextSequence();
		
		String sql = "insert into board(num, writer, subject, content, ref, re_step, re_level)"
				+ " values(board_seq.currval, ?, ?, ?, ?, ?, ?)";
		
		try {
			conn = DBConnPool.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board.getWriter());
			pstmt.setString(2, board.getSubject());
			pstmt.setString(3, board.getContent());
			// 원글과 댓글의 구분
			if(board.getRef() == 0) {
				pstmt.setInt(4, nextval);  // 원글
			} else {
				pstmt.setInt(4, board.getRef());  // 댓글
			}
			pstmt.setInt(5, board.getRe_step());
			pstmt.setInt(6, board.getRe_level());
			pstmt.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("+++ insertBoard() 메서드 에러 +++");
		} finally {
			DBConnPool.close(conn, pstmt);
		}
	}
	
	// 댓글 추가
	// ref(원글), re_step(글 순서), re_level(글 단계)을 조정 -> 게시글 추가
	public void replyBoard(Board board) {
		// [1단계]
		// - 원글에 대한 같은 그룹일 때 글순서가 크다면 글순서를 1 증가함 
		String sql = "update board set re_step = re_step+1 where ref=? and re_step>?";
		
		try {
			conn = DBConnPool.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, board.getRef());
			pstmt.setInt(2, board.getRe_step());
			pstmt.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("+++ replyBoard() 메서드 에러 +++");
		} finally {
			DBConnPool.close(conn, pstmt);
		}
		
		// [2단계]
		// - 댓글의 ref, re_step, re_level 값을 설정
		int ref = board.getRef();
		int re_step = board.getRe_step() + 1;
		int re_level = board.getRe_level() + 1;
		
		// 댓글
		Board b = new Board();
		b.setWriter(board.getWriter());
		b.setSubject(board.getSubject());
		b.setContent(board.getContent());
		b.setRef(ref);
		b.setRe_step(re_step);
		b.setRe_level(re_level);
		//System.out.println(b2);
		
		// [3단계]
		// - 댓글 추가
		insertBoard(b);
	}
	
	// 글수정
	public void updateBoard(Board board) {
		String sql = "update board set subject=?, content=? where num=?";
		
		try {
			conn = DBConnPool.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board.getSubject());
			pstmt.setString(2, board.getContent());
			pstmt.setInt(3, board.getNum());
			pstmt.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("+++ updateBoard() 메서드 에러 +++");
		} finally {
			DBConnPool.close(conn, pstmt);
		}
	}
	
	// 글삭제
	public void deleteBoard(Board board) {
		String sql = "delete from board where num=?";
		
		try {
			conn = DBConnPool.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, board.getNum());
			pstmt.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("+++ deleteBoard() 메서드 에러 +++");
		} finally {
			DBConnPool.close(conn, pstmt);
		}
	}
	
	// 조회수 1 증가
	public void increaseReadcount(int num) {
		String sql = "update board set readcount = readcount+1 where num=?";
		
		try {
			conn = DBConnPool.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("+++ increaseReadcount() 메서드 에러 +++");
		} finally {
			DBConnPool.close(conn, pstmt);
		}
	}
	
	// 추천수 1 증가
	public void increaseRecommcount(int num) {
		String sql = "update board set recommcount = recommcount+1 where num=?";
		
		try {
			conn = DBConnPool.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("+++ increaseRecommcount() 메서드 에러 +++");
		} finally {
			DBConnPool.close(conn, pstmt);
		}
	}
	
}
