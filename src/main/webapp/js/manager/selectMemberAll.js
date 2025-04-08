document.addEventListener("DOMContentLoaded", () => {
	document.querySelector("#btnBack").addEventListener("click", () => {
		location = "memberForm.jsp";
	});
	document.querySelector("#btnRemoveAll").addEventListener("click", () => {
		location = "memberRemoveAll.jsp";
	});
});