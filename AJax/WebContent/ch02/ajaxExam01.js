let httpRequest = null;

function startMethod(){
	httpRequest = new XMLHttpRequest();
	httpRequest.onreadystatechange = resultProcess;
	httpRequest.open("GET", "ajaxExam01.xml", true);//ajaxExam01.xml로 전송
	//httpRequest.setRequestHeader("Content-Type","application/x-www-form-urlencoded;charset=UTF-8");
	httpRequest.send();
}

function resultProcess(){
	if(httpRequest.readyState==4){
		if(httpRequest.status==200){
			
			document.getElementById("displayArea").innerHTML = httpRequest.responseText;//ajaxExam01.xml에서 받아오기
			//document.getElementById("displayArea").style.visibility = "visible"; visibility: hidden; 와 연계됨
			document.getElementById("displayArea").style.display = "block"; //display: none; 와 연계됨
		}
	}
}