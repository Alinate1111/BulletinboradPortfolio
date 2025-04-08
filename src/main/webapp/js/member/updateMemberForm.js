document.addEventListener("DOMContentLoaded",() => {
	let form = document.updateForm;
	
	// 중복 비밀번호 확인 이벤트 - keyup 이벤트
	let s_pwd_chk = document.querySelector("#s_pwd_chk");
	document.querySelector("#pwd2").addEventListener("keyup", () =>{
		if(form.pwd.value == form.pwd2.value) {
			s_pwd_chk.textContent = "비밀번호가 일치합니다.";
			s_pwd_chk.style.color = "blue";
		} else {
			s_pwd_chk.textContent = "비밀번호가 일치하지 않습니다.";
			s_pwd_chk.style.color = "red";
		}
	});
	
	// 이메일 확인 이벤트 - keyup 이벤트
	// 1. '@' 문자를 포함, 아이디가 4글자 이상인지를 판별
	// 2. '@' 문자 다음에 '.' 문자를 포함, 회사이름이 3글자 이상인지를 판별
	let isEmail = (value) => {
		return (value.indexOf('@') > 3) && (value.split('@')[1].indexOf('.') > 2); 
	}
	
	let s_email_chk = document.querySelector("#s_email_chk");
	document.querySelector("#email").addEventListener("keyup", (e) =>{
		let value = e.currentTarget.value;
		
		if(isEmail(value)) {
			s_email_chk.textContent = "사용가능한 이메일입니다.";
			s_email_chk.style.color = "blue";
		} else {
			s_email_chk.textContent = "사용할 수 없는 이메일입니다.";
			s_email_chk.style.color = "red";
		}
	});
	
	// 전화번호 확인 이벤트 - keyup 이벤트
	// 1. 정규표현식: 3자리-3,4자리-4자리
	// test(): 정규표현식에 일치하는지의 여부를 알려주는 함수
	// /로 감싸서 표현
	// ^: 시작, $: 끝, \d{}: 숫자
	let isPhone = (value) => {
		return /^\d{3}-\d{3,4}-\d{4}$/.test(value);
	}
	
	let s_phone_chk = document.querySelector("#s_phone_chk");
	document.querySelector("#phone").addEventListener("keyup", (e) =>{
		let value = e.currentTarget.value;
		
		if(isPhone(value)) {
			s_phone_chk.textContent = "사용가능한 휴대폰번호입니다.";
			s_phone_chk.style.color = "blue";
		} else {
			s_phone_chk.textContent = "사용할 수 없는 휴대폰번호입니다.";
			s_phone_chk.style.color = "red";
		}
	});
	
	// 주소 찾기 버튼 이벤트 - 카카오 라이브러리 활용
	document.querySelector("#btnAddress").addEventListener("click", () =>{
		new daum.Postcode({
	        oncomplete: function(data) {
	            form.address1.value = data.address;
	        }
	    }).open();
	});

	document.querySelector("#btnOK").addEventListener("click", () =>{
		if(!form.pwd.value) {
			alert("비밀번호를 입력하시오.");
			form.pwd.focus();
			return;
		}
		if(!form.pwd2.value) {
			alert("비밀번호 확인을 입력하시오.");
			form.pwd2.focus();
			return;
		}
		if(!form.username.value) {
			alert("회원명를 입력하시오.");
			form.username.focus();
			return;
		}
		if(!form.nickname.value) {
			alert("별명을 입력하시오.");
			form.nickname.focus();
			return;
		}
		if(!form.age.value) {
			alert("나이를 입력하시오.");
			form.age.focus();
			return;
		}
		if(!form.birthday.value) {
			alert("생년월일을 입력하시오.");
			form.birthday.focus();
			return;
		}
		if(!form.job.value) {
			alert("직업을 입력하시오.");
			form.job.focus();
			return;
		}
		if(!form.email.value) {
			alert("이메일을 입력하시오.");
			form.email.focus();
			return;
		}
		if(!form.phone.value) {
			alert("휴대폰번호를 입력하시오.");
			form.phone.focus();
			return;
		}
		if(!form.address1.value) {
			alert("주소 찾기 버튼을 클릭하시오.");
			form.address1.focus();
			return;
		}
		if(!form.address2.value) {
			alert("상세주소를 입력하시오.");
			form.address2.focus();
			return;
		}
		form.submit();
	});
	
	document.querySelector("#btnBoardList").addEventListener("click", () => {
		location = "../board/getBoardList.jsp";
	});
	
});