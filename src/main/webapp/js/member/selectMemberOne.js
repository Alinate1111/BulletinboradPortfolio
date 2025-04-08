document.addEventListener("DOMContentLoaded", () => {
	document.querySelector("#btnUpdate").addEventListener("click", () => {
		location = "updateMemberForm.jsp";
	});
	document.querySelector("#btnDelete").addEventListener("click", () => {
		location = "deleteMemberForm.jsp";
	});
	document.querySelector("#btnBoardList").addEventListener("click", () => {
		location = "../board/getBoardList.jsp";
	});
});