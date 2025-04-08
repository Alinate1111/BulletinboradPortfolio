package vo;

//#### 페이징 처리 ####
/*
< 페이징에서 필요한 변수 >
페이징(paging): 게시판의 글을 일정한 건수로 나누어 페이지로 만드는 것
- cnt: 전체 글 개수
- pageSize: 한 페이지당 글 개수  ex) 한 페이지당 글 개수 10개 
- pageNum: 출력할 페이지 번호 -> String
- currentNum: 현재 페이지 번호 -> int

- totalPage: 전체 페이지 개수 ex) 192(글수) / 10(블럭수) -> 20개의 페이지
- blockPage: 출력할 페이지 개수  ex) 한 페이지의 블럭이 10개
- startPage: 시작 페이지 번호
- endPage: 끝 페이지 번호
*/

public class Paging {
	private int pageSize;
	private int blockPage;
	private int cnt;
	private int currentNum;
	private int totalPage;
	private int startPage;
	private int endPage;

	public int getPageSize() {
		return pageSize;
	}

	public int getBlockPage() {
		return blockPage;
	}

	public int getCnt() {
		return cnt;
	}

	public int getCurrentNum() {
		return currentNum;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public int getStartPage() {
		return startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public void setBlockPage(int blockPage) {
		this.blockPage = blockPage;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}

	public void setCurrentNum(int currentNum) {
		this.currentNum = currentNum;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	@Override
	public String toString() {
		return "Paging [pageSize=" + pageSize + ", blockPage=" + blockPage + ", cnt=" + cnt + ", currentNum="
				+ currentNum + ", totalPage=" + totalPage + ", startPage=" + startPage + ", endPage=" + endPage + "]";
	}

}
