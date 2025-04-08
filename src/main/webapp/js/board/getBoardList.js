document.addEventListener("DOMContentLoaded", () => {
	let form = document.searchForm;
	
	document.querySelector("#btnSearch").addEventListener("click", () => {
		if(!form.searchKeyword.value) {
			alert("검색할 내용을 입력하시오.");
			form.searchKeyword.focus();
			return;
		}
		form.submit();
	});
});