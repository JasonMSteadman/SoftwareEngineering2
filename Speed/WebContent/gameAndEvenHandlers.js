var websocket = new WebSocket("ws://localhost:8080/Speed/Server")	

websocket.onmessage = function processMessage(message){
	var jsonData = JSON.parse(message.data);
	if(jsonData == null){
		return;
	}
	else if(jsonData.hasOwnProperty("role")){
		document.getElementById("role").innerHTML = jsonData.role;
	}
	else{
			
		document.getElementById("a1").src = jsonData.a1;
		document.getElementById("a2").src = jsonData.a2;
		document.getElementById("a3").src = jsonData.a3;
		document.getElementById("a4").src = jsonData.a4;
		
		document.getElementById("b1").src = jsonData.b1;
		document.getElementById("b2").src = jsonData.b2;
		document.getElementById("b3").src = jsonData.b3;
		document.getElementById("b4").src = jsonData.b4;
		
		document.getElementById("p").src = jsonData.p;
	}
}

function sendMessage(gridLocation){
	websocket.send(gridLocation);
}
