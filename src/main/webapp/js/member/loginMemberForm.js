document.addEventListener("DOMContentLoaded",() => {
	let form = document.loginForm;
	
	// 저장된 쿠키가 있다면 쿠키 읽기
	if(getCookie("cookie_id")) {
		form.id.value = getCookie("cookie_id");
		form.chk_id_save.checked = true;
	}
	
	// 쿠키 저장 - 쿠키명, 쿠키값, 만료시간
	// escape(): 알파벳, 숫자, @,-_+./를 제외한 모든 문자를 16진수 문자열로 인코딩
	function setCookie(name, value, expireDays) {
		let today = new Date();
		today.setDate(today.getDate() + expireDays);
		document.cookie = name + "=" + escape(value) + "; path=/; expires=" + today.toGMTString() + ";";
	}
	
	// 쿠키 읽기
	// unescape(): 알파벳, 숫자, @,-_+./를 제외한 모든 문자를 디코딩
	function getCookie(name) {
		let search = name + "=";
		if(document.cookie.length > 0) {
			let begin = document.cookie.indexOf(search); // 쿠키명에 해당하는 인덱스를 찾음
			if(begin != -1) { // 쿠키명에 해당하는 쿠키가 있다면
				begin += search.length;                    // 쿠키값에 해당하는 첫 인덱스
				end = document.cookie.indexOf(";", begin); // 쿠키값에 해당하는 끝 인덱스
				if(end == -1) end = document.cookie.length;
				return unescape(document.cookie.substring(begin, end)); // 쿠키값
			}
		}
	}
	
	// 로그인 버튼 이벤트
	document.querySelector("#btnLogin").addEventListener("click", () =>{
		if(!form.id.value) {
			alert("아이디를 입력하시오.");
			form.id.focus();
			return;
		}
		if(!form.pwd.value) {
			alert("비밀번호를 입력하시오.");
			form.pwd.focus();
			return;
		}
		// checkbox에서 체크했을 때 쿠키 생성, 해제했을 때 쿠키 삭제
		if(form.chk_id_save.checked) {
			// 쿠키 생성
			setCookie("cookie_id", form.id.value, 7); // 쿠키명, 쿠키값, 유지기간(7일)
		} else {
			// 쿠키 삭제
			setCookie("cookie_id", form.id.value, 0); // 쿠키명, 쿠키값, 유지기간(0일)
		}
		form.submit();
	});
	
	// 비밀번호 enter keydown 이벤트
	document.querySelector("#pwd").addEventListener("keydown", (e) =>{
		if(e.keyCode == 13) {
			if(!form.id.value) {
				alert("아이디를 입력하시오.");
				form.id.focus();
				return;
			}
			if(!form.pwd.value) {
				alert("비밀번호를 입력하시오.");
				form.pwd.focus();
				return;
			}
			// checkbox에서 체크했을 때 쿠키 생성, 해제했을 때 쿠키 삭제
			if(form.chk_id_save.checked) {
				// 쿠키 생성
				setCookie("cookie_id", form.id.value, 7); // 쿠키명, 쿠키값, 유지기간(7일)
			} else {
				// 쿠키 삭제
				setCookie("cookie_id", form.id.value, 0); // 쿠키명, 쿠키값, 유지기간(0일)
			}
			form.submit();
		}
	});
});