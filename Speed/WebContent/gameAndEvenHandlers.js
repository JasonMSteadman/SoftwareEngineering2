/**
 * 
 */

//	Game board
var game = new Speed.Board();


//	Creates a static object shared via server
game.prototype.publicMethod = function () {    
	  alert(this.publicVariable);
	};

//	Start a new game
function newGame(){
	delete game;
	game = new Speed.Board;
}

//	Drag and drop for the first row
document.getElementById("a1").addEventListener("drop", checkMatch(0,0));
document.getElementById("a2").addEventListener("drop", checkMatch(0,1));
document.getElementById("a3").addEventListener("drop", checkMatch(0,2));
document.getElementById("a4").addEventListener("drop", checkMatch(0,3));

//	Drag and drop for the second row
document.getElementById("b1").addEventListener("drop", checkMatch(0,0));
document.getElementById("b2").addEventListener("drop", checkMatch(0,1));
document.getElementById("b3").addEventListener("drop", checkMatch(0,2));
document.getElementById("b4").addEventListener("drop", checkMatch(0,3));

//	TODO Create AJAX connection for the decks and play hand
