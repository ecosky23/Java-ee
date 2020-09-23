let httpRequest = null;
//let message = null;
function startMethod(){
	httpRequest = new XMLHttpRequest();
	httpRequest.onreadystatechange = resultProcess;
	httpRequest.open("GET","ajaxExam02.xml",true);
	httpRequest.send();
}

function resultProcess(){
	if(httpRequest.readyState==4){
		if(httpRequest.status==200){
			
			let xmlDoc = httpRequest.responseXML;//XML문서로 통체로 받는 것
			let trTag = "";
			let tdTag = "";
			
			//먼저 테이블을 지운다.
			let trChildsList = document.getElementById("resultDisplay");
			while(trChildsList.hasChildNodes()){
				trChildsList.removeChild(trChildsList.firstChild);
			}//resultDisplay의 자식들이 있으면 모두 지워준다.
			
			
			let subjectList = xmlDoc.getElementsByTagName("subject");
			
			
			
			for(i=0; i<subjectList.length; i++){//행  가로(줄)
				
				trTag  = document.createElement("tr");//5개 생겨야됨
				
				let subjectChildList = subjectList[i].childNodes;
				
				for(j=0; j<subjectChildList.length; j++){
					if(subjectChildList[j].firstChild != null){
						tdTag = document.createElement("td");
						
						tdTag.appendChild(subjectChildList[j].firstChild);//A101부터 시작 다음은 XML 다음은 301
						trTag.appendChild(tdTag);
					}//if
				}//for j
				//alert("갯수"+subjectChildList.length);
		//		let codeNumberValue = subject.getElementsByTagName("codeNumber").item(0).firstChild.nodeValue;
		//		let titleNameValue = subject.getElementsByTagName("titleName").item(0).firstChild.nodeValue;
		//		let roomNumberValue = subject.getElementsByTagName("roomNumber").item(0).firstChild.nodeValue;
				
		//		
		//		message += "<tr><td>"+codeNumberValue+"</td><td>"+titleNameValue+"</td><td>"+roomNumberValue+"</td></tr>";
				document.getElementById("resultDisplay").appendChild(trTag);
			}//for i
	
			
			
		}
	}
}