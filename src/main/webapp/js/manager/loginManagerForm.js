document.addEventListener("DOMContentLoaded",() => {
	let form = document.loginForm;
	
	// 로그인 버튼 이벤트
	document.querySelector("#btnLogin").addEventListener("click", () =>{
		if(!form.m_id.value) {
			alert("관리자 아이디를 입력하시오.");
			form.m_id.focus();
			return;
		}
		if(!form.m_pwd.value) {
			alert("관리자 비밀번호를 입력하시오.");
			form.m_pwd.focus();
			return;
		}
		form.submit();
	});
});