$(document).ready(function(){
$('#loginBtn').click(function(){
	
	$('.idDiv').empty();
	$('.pwDiv').empty();
	
	let id = $('#id').val();
	let pwd = $('#pwd').val();
	
	if(id==""){ 
		$('.idDiv').text("ID을 입력하세요").css('font-weight','bold').css('color','red').css('font-size','8pt');
		$('#id').focus();
	}else if(pwd==""){
		$('.pwdDiv').text("password를 입력하세요").css('font-weight','bold').css('color','red').css('font-size','8pt');
		$('#pwd').focus();
	}else{
		$('form[name=loginForm]').submit();
	}
});
});

$(document).ready(function(){
	$('#singUpBtn').click(function(){
		$('#nameDiv').empty();
		$('#idDiv2').empty();
		$('#pwDiv2').empty();
		$('#repwDiv').empty();
		
		let name = $('#name').val();
		let id2 = $('#id2').val();
		let pwd2 = $('#pwd2').val();
		let repwd2 = $('#repwd2').val();
		
		if(name==""){ 
			$('#nameDiv').text("이름을 입력하세요").css('font-weight','bold').css('color','red').css('font-size','8pt');
			$('#name').focus();
		}else if(id2==""){
			$('#idDiv2').text("id를 입력하세요").css('font-weight','bold').css('color','red').css('font-size','8pt');
			$('#id2').focus();
		}else if(pwd2==""){
			$('#pwdDiv2').text("비밀번호를 입력하세요").css('font-weight','bold').css('color','red').css('font-size','8pt');
			$('#pwd2').focus();
		}else if(pwd2!=repwd2){
			$('#repwdDiv').text("비밀번호가 같지 않습니다.").css('font-weight','bold').css('color','red').css('font-size','8pt');
			$('#repwd2').focus();
		}else{
			$('form[name=writeForm]').submit();
		}
		
		
		
		
		
	});
});