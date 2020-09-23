function checkWriteForm() {
	// if(document.writeForm.name.value == ""){ 이름입력란의 name속성의 name를 뜻한다.
	if (document.getElementById("name").value == "") {// 이름입력란의 id속성의 name을
														// 뜻한다.
		alert("이름을 입력하세요");
		document.writeForm.name.focus();// 이름창에 포커스 주기

	} else if (document.writeForm.id.value == "") {
		alert("id를 입력하세요");
		document.writeForm.id.focus();

	} else if (document.writeForm.pwd.value == "") {
		alert("password를 입력하세요");
		document.writeForm.pwd.focus();

	} else if (document.writeForm.pwd.value != document.writeForm.repwd.value) {
		alert("password가 일치하지 않습니다.");

	} else if (document.writeForm.id.value != document.writeForm.idDuplicationCheck.value) {
		alert("아이디 중복체크를 해주세요");
	} else {

		document.writeForm.submit();
	}
}

function checkLoginForm() {
	if (document.loginForm.id.value == "") {
		alert("아이디를 입력하세요");
		document.loginForm.id.focus();
	} else if (document.loginForm.pwd.value == "") {
		alert("비밀번호를 입력하세요");
	} else {
		document.loginForm.submit();
	}
}

function checkId() {
	let id = document.writeForm.id.value
	if (id == "") {
		alert("먼저 아이디를 입력하세요")
	} else {
		window.open("checkId.jsp?id=" + id, "", "width=300 height=100")// 새로운
																		// 창을
																		// 띄우게 함
	}
}

function checkIdClose(id) {// id 넘오온거 받아주기

	opener.writeForm.id.value = id; // 열려있는창의 id 자리에 id값을 넣기
	opener.writeForm.idDuplicationCheck.value = id;
	window.close(); // 열려있는 창 닫기
	opener.writeForm.pwd.focus();

}

function checkPost() {
	window.open("checkPost.jsp", "", "width=600 height=500 scrollbars=yes");
}

function checkPostClose(zipcode, address) {// checkPost에서 zipcode와 address를  불러온다.
/*
	opener.document.form[0].zipcode.value = zipcode;// writeForm의 우편번호 창에 가져온 우편을  넣어준다
												
	opener.document.form[0].addr1.value = address;// writeForm의 주소창에 가져온 주소를 넣어준다

	window.close();
	opener.document.form[0].addr2.focus();//form 의 첫번째 form에 모두적용되게 고치면 회원정보 입력과 수정을 같이 할 수 있다. 열려진 문서의 첫번째 form에 적용됨*/
	
	opener.document.getElementById("zipcode").value = zipcode;// id값을 통해서 값을 넣어준다 
	opener.document.getElementById("addr1").value = address;// writeForm의 주소창에 가져온 주소를 넣어준다

	window.close();
	opener.document.getElementById("addr2").focus();
}

function checkLoginForm() {
	if (document.loginForm.id.value == "") {
		alert("id를 입력하세요");
		document.loginForm.id.focus();
	} else if (document.loginForm.pwd.value == "") {
		alert("password를 입력하세요");
		document.loginForm.pwd.focus();
	} else {
		document.loginForm.submit();
	}
}

function checkModifyForm() {
	// if(document.writeForm.name.value == ""){ 이름입력란의 name속성의 name를 뜻한다.
	if (document.getElementById("name").value == "") {// 이름입력란의 id속성의 name을
														// 뜻한다.
		alert("이름을 입력하세요");
		document.modifyForm.name.focus();// 이름창에 포커스 주기

	} else if (document.modifyForm.pwd.value == "") {
		alert("password를 입력하세요");
		document.modify.pwd.focus();

	} else if (document.modifyForm.pwd.value != document.modifyForm.repwd.value) {
		alert("password가 일치하지 않습니다.");

	} else {

		document.modifyForm.submit();
	}
}


