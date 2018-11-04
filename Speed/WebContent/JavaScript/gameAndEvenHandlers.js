var websocket = new WebSocket("ws://localhost:8080/Speed/Server")	

websocket.onmessage = function processMessage(message){
	var jsonData = JSON.parse(message.data);
	if(jsonData != null){
		if(jsonData.hasOwnProperty("role")){
			
			document.getElementById("role").innerHTML = jsonData.role;
		}
		if(jsonData.hasOwnProperty("a1")){
			
			document.getElementById("a1").src = jsonData.a1;
			document.getElementById("a2").src = jsonData.a2;
			document.getElementById("a3").src = jsonData.a3;
			document.getElementById("a4").src = jsonData.a4;
			
			document.getElementById("b1").src = jsonData.b1;
			document.getElementById("b2").src = jsonData.b2;
			document.getElementById("b3").src = jsonData.b3;
			document.getElementById("b4").src = jsonData.b4;
			document.getElementById("deck").src = jsonData.deck;
			document.getElementById("hand").src = jsonData.hand;
			
			var winner = jsonData.w;
			window.alert(winner);
			if(winner == 0){
				window.alert(winner);
				if(winner == "1"){
					document.getElementById("winner").value = "Player One has won the game!";
				}
				if(winner == "2"){
					document.getElementById("winner").value = "Player Two has won the game!";
				}
			}
				
		}
	}
}

function sendMessage(gridLocation){
	websocket.send(gridLocation);
}
