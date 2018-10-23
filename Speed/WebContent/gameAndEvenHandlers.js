/**
 * 
 */

//	Game board
var game;
var player = ""; 

function staticGame(){
	  game = new Speed.Board();
}

//	Creates a static object shared via server
staticGame.prototype.publicMethod = function () {    
	  alert(this.publicVariable);
	};
	
game = new staticGame();

//	Start a new game
function newGame(){
	delete game;
	game = new Speed.Board;
}

function addPlayer(playerID){
	if(game.setPlayer1(ID)){
		player = playerID;
	}
	else if (game.setPlayer2(ID)){
		pplayer = playerID;
	}
}

document.getElementById("body").onload = function () {addPlayer(document.cookie.match(/JSESSIONID=[^;]+/));};

//	Drag and drop for the first row
document.getElementById("a1").addEventListener("drop", game.checkMatch(0, 0, player));
document.getElementById("a2").addEventListener("drop", game.checkMatch(0, 1, player));
document.getElementById("a3").addEventListener("drop", game.checkMatch(0, 2, player));
document.getElementById("a4").addEventListener("drop", game.checkMatch(0, 3, player));

//	Drag and drop for the second row
document.getElementById("b1").addEventListener("drop", game.checkMatch(0, 0, player));
document.getElementById("b2").addEventListener("drop", game.checkMatch(0, 1, player));
document.getElementById("b3").addEventListener("drop", game.checkMatch(0, 2, player));
document.getElementById("b4").addEventListener("drop", game.checkMatch(0, 3, player));

//	TODO Create AJAX connection for the decks and play hand
