document.addEventListener("DOMContentLoaded", () => {
	let form = document.boardForm;
	
	// 댓글 버튼
	document.querySelector("#btnReply").addEventListener("click", () => {
		form.action = "replyBoardForm.do"
		form.submit();
	});
	
	// 게시판 목록 버튼
	document.querySelector("#btnBoardList").addEventListener("click", () => {
		location = "getBoardList.jsp?pageNum=" + form.pageNum.value;
	});
	
	// 추천 이미지 버튼
	let recommImg = document.querySelector("#btnRecomm");
	document.querySelector("#btnRecomm").addEventListener("click", () => {
		document.querySelector("#btnRecomm").src = "../icons/recomm2.png";
		location = "increaseRecomm.do?num=" + recommImg.value;
	});
});

// AJAX(Asynchronized JAvascript Xml): 자바스크립트를 활용한 비동기 데이터 전송 방법
// - JSON 방법으로 데이터 전송
// - 비동기: 동기화 상대적인 표현, 데이터를 전송하는 시점과 관계없이 데이터를 수신하는 곳에서 데이터를 처리하는 방법
/*
$("document").ready(() => {
	$("#btnRecomm").click(() => {
		let numValue = $("#btnRecomm").val();
		$.ajax({
			url: "increaseRecomm.jsp",  // 처리할 페이지
			type: "get",  // 데이터 전송 방식
			data: {num: numValue},  // 전송 데이터(name, value)
			dataType: "text",
			success: (resData) => {
				if(resData != "") {
					location.reload();
					$("#btnRecomm").attr("src", "../icons/recomm2.png");
				}
			}
		});
		
	});
});
*/