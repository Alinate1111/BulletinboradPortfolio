package common;

import java.io.IOException;

import javax.servlet.jsp.JspWriter;

// 자바스크립트 코드 정리
public class JSFunction {
	private static String script = "";
	
	// 데이터 추가/수정/삭제 성공 메서드 -> 추가/수정/삭제 페이지로 이동
	public static void alertLocation(JspWriter out, String msg, String url) {
		script = "<script>alert('" + msg + "');location='" + url + "';</script>";
		try {
			out.print(script);
		} catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
	// 데이터 추가/수정/삭제 실패 메서드 -> 이전 페이지로 이동
	public static void alertBack(JspWriter out, String msg) {
		script = "<script>alert('" + msg + "');history.back();</script>";
		try {
			out.print(script);
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}
