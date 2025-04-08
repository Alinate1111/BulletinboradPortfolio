document.addEventListener("DOMContentLoaded", () => {
	let form = document.insertForm;
	
	document.querySelector("#btnInsert").addEventListener("click", () => {
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
	document.querySelector("#btnBoardList").addEventListener("click", () => {
		location = "getBoardList.jsp";
	});
});