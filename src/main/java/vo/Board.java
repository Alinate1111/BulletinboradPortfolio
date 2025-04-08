package vo;

// 자바빈, DTO
// - 10개의 필드 구성
// - num(글번호), writer(작성자), subject(글제목), content(글내용), reg_date(등록일),
// - readcount(조회수), recommcount(추천수),
// - ref(원글번호), re_step(댓글 순서), re_level(댓글 단계)
// - 날짜: reg_date -> 문자열로 처리
public class Board {
	private int num;
	private String writer;
	private String subject;
	private String content;
	private String reg_date;
	private int readcount;
	private int recommcount;
	private int ref;
	private int re_step;
	private int re_level;

	public int getNum() {
		return num;
	}

	public String getWriter() {
		return writer;
	}

	public String getSubject() {
		return subject;
	}

	public String getContent() {
		return content;
	}

	public String getReg_date() {
		return reg_date;
	}

	public int getReadcount() {
		return readcount;
	}

	public int getRecommcount() {
		return recommcount;
	}

	public int getRef() {
		return ref;
	}

	public int getRe_step() {
		return re_step;
	}

	public int getRe_level() {
		return re_level;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}

	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}

	public void setRecommcount(int recommcount) {
		this.recommcount = recommcount;
	}

	public void setRef(int ref) {
		this.ref = ref;
	}

	public void setRe_step(int re_step) {
		this.re_step = re_step;
	}

	public void setRe_level(int re_level) {
		this.re_level = re_level;
	}

	@Override
	public String toString() {
		return "Board [num=" + num + ", writer=" + writer + ", subject=" + subject + ", content=" + content
				+ ", reg_date=" + reg_date + ", readcount=" + readcount + ", recommcount=" + recommcount + ", ref="
				+ ref + ", re_step=" + re_step + ", re_level=" + re_level + "]";
	}

}
