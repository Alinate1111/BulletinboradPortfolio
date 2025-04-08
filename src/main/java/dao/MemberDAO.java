package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import common.DBConnPool;
import vo.Member;

// member DB 처리 클래스
public class MemberDAO {
	// 싱글턴 패턴
	private static MemberDAO instance = new MemberDAO();
	
	private MemberDAO() { }
	
	public static MemberDAO getInstance() {
		return instance;
	}
	
	// DB 연동 객체
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	// 로그인
	// result: 0(아이디 없음), -1(비밀번호 불일치), 1(아이디, 비밀번호 모두 일치)
	// 로그인 성공 및 실패: 이전 페이지로 이동(로그인 페이지)
	public int loginMember(Member member) {
		String sql = "select pwd from member where id = ?";
		String dbPwd = "";
		int result = 0;
		
		try {
			conn = DBConnPool.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getId());
			rs = pstmt.executeQuery();
			
			// 아이디가 있다면
			if(rs.next()) {
				dbPwd = rs.getString("pwd");
				// 비밀번호가 일치한다면
				if(dbPwd.equals(member.getPwd())) {
					result = 1;
				// 비밀번호가 일치하지 않는다면
				} else {
					result = -1;
				}
			// 아이디가 없다면
			} else {
				result = 0;
			}
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("@@@ loginMember() 메서드 에러 @@@");
		} finally {
			DBConnPool.close(conn, pstmt, rs);
		}
		return result;
	}
	
	// ID 중복 확인
	// result: 1(중복 아이디가 있음, 추가하는 아이디는 사용불가), 0(중복 아이디가 없음, 추가하는 아이디는 사용가능)
	public int checkMemberId(String id) {
		String sql = "select * from member where id=?";
		int result = 0;
		
		try {
			conn = DBConnPool.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
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
	
	// 회원 추가(1건)
	public void insertMember(Member member) {
		String sql = "insert into member(id, pwd, username, nickname, age, birthday, job, email, phone, address) "
				+ " values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		try {
			conn = DBConnPool.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPwd());
			pstmt.setString(3, member.getUsername());
			pstmt.setString(4, member.getNickname());
			pstmt.setInt(5, member.getAge());
			pstmt.setString(6, member.getBirthday());
			pstmt.setString(7, member.getJob());
			pstmt.setString(8, member.getEmail());
			pstmt.setString(9, member.getPhone());
			pstmt.setString(10, member.getAddress());
			pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("@@@ insertMember() 메서드 에러 @@@");
		} finally {
			DBConnPool.close(conn, pstmt);
		}
	}
	
	// 회원 정보 확인(1건)
	public Member getMember(String id) {
		String sql = "select * from member where id = ?";
		Member member = new Member();
		
		try {
			conn = DBConnPool.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				member.setId(rs.getString("id"));
				member.setPwd(rs.getString("pwd"));
				member.setUsername(rs.getString("username"));
				member.setNickname(rs.getString("nickname"));
				member.setAge(rs.getInt("age"));
				member.setBirthday(rs.getString("birthday"));
				member.setJob(rs.getString("job"));
				member.setEmail(rs.getString("email"));
				member.setPhone(rs.getString("phone"));
				member.setAddress(rs.getString("address"));
				member.setReg_date(rs.getString("reg_date"));
			}
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("@@@ getMember() 메서드 에러 @@@");
		} finally {
			DBConnPool.close(conn, pstmt, rs);
		}
		return member;
	}
	
	// 회원 정보 수정(1건)
	// id를 조회하여 id, reg_date를 제외한 9가지 컬럼 수정
	public void updateMember(Member member) {
		String sql = "update member set pwd=?, username=?, nickname=?, age=?, birthday=?, job=?, "
				+ " email=?, phone=?, address=? where id=?";
		
		try {
			conn = DBConnPool.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getPwd());
			pstmt.setString(2, member.getUsername());
			pstmt.setString(3, member.getNickname());
			pstmt.setInt(4, member.getAge());
			pstmt.setString(5, member.getBirthday());
			pstmt.setString(6, member.getJob());
			pstmt.setString(7, member.getEmail());
			pstmt.setString(8, member.getPhone());
			pstmt.setString(9, member.getAddress());
			pstmt.setString(10, member.getId());
			pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("@@@ updateMember() 메서드 에러 @@@");
		} finally {
			DBConnPool.close(conn, pstmt);
		}
	}
	
	// 회원 탈퇴(1건 삭제)
	public int deleteMember(Member member) {
		String sql = "delete from member where id=? and pwd=?";
		int result = 0;
		
		try {
			conn = DBConnPool.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPwd());
			result = pstmt.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("@@@ deleteMember() 메서드 에러 @@@");
		} finally {
			DBConnPool.close(conn, pstmt);
		}
		return result;
	}
	
	// 회원 정보 확인(전체) - 관리자만 가능하도록 변경
	public List<Member> getMemberList() {
		List<Member> memberList = new ArrayList<Member>();
		Member member = null;
		String sql = "select * from member";
		
		try {
			conn = DBConnPool.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				member = new Member();
				member.setId(rs.getString("id"));
				member.setPwd(rs.getString("pwd"));
				member.setUsername(rs.getString("username"));
				member.setNickname(rs.getString("nickname"));
				member.setAge(rs.getInt("age"));
				member.setBirthday(rs.getString("birthday"));
				member.setJob(rs.getString("job"));
				member.setEmail(rs.getString("email"));
				member.setPhone(rs.getString("phone"));
				member.setAddress(rs.getString("address"));
				member.setReg_date(rs.getString("reg_date"));
				memberList.add(member);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("@@@ getMemberList() 메서드 에러 @@@");
		} finally {
			DBConnPool.close(conn, pstmt, rs);
		}
		return memberList;
	}
}
