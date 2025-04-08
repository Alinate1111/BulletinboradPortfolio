package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import common.DBConnPool;

public class ManagerDAO {
	// 싱글턴 패턴
	private static ManagerDAO instance = new ManagerDAO();
	
	private ManagerDAO() { }
	
	public static ManagerDAO getInstance() {
		return instance;
	}
	
	// DB 연동 객체
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	//관리자 로그인
	public int loginManager(String m_id, String m_pwd) {
		String sql = "select * from manager where m_id=? and m_pwd=?";
		int result = 0;
		
		try {
			conn = DBConnPool.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m_id);
			pstmt.setString(2, m_pwd);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = 1;
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBConnPool.close(conn, pstmt, rs);
		}
		return result;
	}

}
