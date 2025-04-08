package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDAO;
import vo.Member;

public class MemberUpdateProController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 한글 처리
		request.setCharacterEncoding("utf-8");
		
		// 객체 생성
		Member member = new Member();
		member.setId(request.getParameter("id"));
		member.setPwd(request.getParameter("pwd"));
		member.setUsername(request.getParameter("username"));
		member.setNickname(request.getParameter("nickname"));
		member.setAge(Integer.parseInt(request.getParameter("age")));
		member.setBirthday(request.getParameter("birthday"));
		member.setJob(request.getParameter("job"));
		member.setEmail(request.getParameter("email"));
		member.setPhone(request.getParameter("phone"));
		String address1 = request.getParameter("address1");
		String address2 = request.getParameter("address2");
		String address = address1 + " " + address2;
		member.setAddress(address.trim());
		
		// DB 처리
		MemberDAO memberDAO = MemberDAO.getInstance();
		memberDAO.updateMember(member);
		
		// 이동
		response.sendRedirect("updateMemberForm.do");
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
