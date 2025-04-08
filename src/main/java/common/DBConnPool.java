package common;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DBConnPool {
	
	public static Connection getConnection() {
		try {
			// 1. 커넥션풀에서 커넥션 획득
			Context initCtx = new InitialContext();  // 컨텍스트 객체 생성
			Context ctx = (Context)initCtx.lookup("java:comp/env");  // 커넥션풀 룩업
			DataSource ds = (DataSource)ctx.lookup("dbcp_myoracle");  // 이름에 해당하는 커넥션을 연결
			System.out.println("***** 커넥션풀 연결 성공 *****");
			return ds.getConnection();
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("***** 커넥션풀 연결 실패 *****");
		}
		return null;
	}
	
	// DB 해제 메서드 - conn, pstmt -> insert, update, delete
	public static void close(Connection conn, PreparedStatement pstmt) {
		try {
			if(pstmt != null) pstmt.close();
			if(conn != null) conn.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("***** DB 연결 해제 *****");
	}
		
	// DB 해제 메서드 - conn, pstmt, rs -> select
	public static void close(Connection conn, PreparedStatement pstmt, ResultSet rs) {
		try {
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
			if(conn != null) conn.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("***** DB 연결 해제 *****");
	}
	
}
