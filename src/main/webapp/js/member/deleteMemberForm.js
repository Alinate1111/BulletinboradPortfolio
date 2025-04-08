document.addEventListener("DOMContentLoaded", () => {
	let form = document.deleteForm;
	
	// 회원 탈퇴 버튼 클릭 이벤트
	document.querySelector("#btnOK").addEventListener("click", () => {
		if(!form.pwd.value) {
			alert("비밀번호를 입력하시오.");
			form.pwd.focus();
			return;
		}
		let isChk = confirm("정말 회원을 탈퇴하시겠습니까?");
		if(isChk) form.submit();
	});
	// 게시판 보기 버튼 클릭 이벤트
	document.querySelector("#btnBoardList").addEventListener("click", () => {
		location = "../board/getBoardList.jsp";
	});
});