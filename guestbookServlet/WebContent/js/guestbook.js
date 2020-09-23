function checkWriteForm(){
	if(document.guestbookWriteForm.title.value == ""){
		alert("제목을 입력하세요");
		document.guestbookWriteForm.title.focus();
	}else if(document.guestbookWriteForm.content.value == ""){
		alert("내용을 입력하세요");
		document.guestbookWriteForm.content.focus();
	}else{
		document.guestbookWriteForm.submit();
	}
}

function showList(){
	document.GuestbookWriteServlet.submit();
}