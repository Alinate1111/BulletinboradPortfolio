document.addEventListener("DOMContentLoaded", () => {
	let form = document.updateForm;
	
	// 글수정 이벤트
	document.querySelector("#btnUpdate").addEventListener("click", () => {
		if(!form.subject.value) {
			alert("글제목을 입력하시오.");
			form.subject.focus();
			return;
		}
		if(!form.content.value) {
			alert("글내용을 입력하시오.");
			form.content.focus();
			return;
		}
		form.submit();
	});
	
	// 글삭제 이벤트
	document.querySelector("#btnDelete").addEventListener("click", () => {
		form.action="deleteBoardPro.do";
		form.submit();
	});
	
	// 댓글 이벤트
	document.querySelector("#btnReply").addEventListener("click", () => {
		form.action = "replyBoardForm.do"
		form.submit();
	});
	
	// 게시판 목록
	document.querySelector("#btnBoardList").addEventListener("click", () => {
		location = "getBoardList.jsp?pageNum=" + form.pageNum.value;
	});
});