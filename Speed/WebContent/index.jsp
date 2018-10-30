<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" type="text/css" href="html-stylesheet/Site.css">
		<title>Speed</title>
		<style>
			body {
    			padding-top: 50px;
    			padding-bottom: 20px;
    			height: 800px;
    			background-color: #cccccc;
    			background-repeat: no-repeat;
    			background-image: radial-gradient(green, mediumseagreen);
			}
		</style>
		
		<script>	
		
			function click() {
				console.log("Setting image..")
				var imageSrc = document.getElementByID("test");
				console.log(imageSrc);
				imageSrc.src = "/Images/green_back.png"
			}
			
			function changeImage() {
				console.log("Setting image..")
				var imageSrc = document.getElementByID("img1");
				imageSrc.src = "/Images/green_back.png"
			}
			
			function allowDrop(ev) {
			    ev.preventDefault();
			}

			function drag(ev) {
			    ev.dataTransfer.setData("text", ev.target.id);
			}

			function drop(ev) {
				changeImage();
			    ev.preventDefault();
			    //var data = ev.dataTransfer.getData("text");
			    //ev.target.style.border = "none";
		        //ev.preventDefault(); // don't forget this!
			    //ev.target.removeChild(ev.target.childNodes[0]);
			    //ev.target.appendChild(document.getElementById(data));
			    //console.log("dropped");
			}
		</script>
		
	</head>
		
	<body>
		<div class="col-15">
<<<<<<< HEAD
			<p class="floatCenter"><% out.println("Player 1"); %></p>
			<img id="test" class="pileImage" src ="/Images/red_back.png" draggable="true" ondragstart="drag(event)">
			<button onclick = "click()">Testing</button>
=======
			<p class="floatCenter"></p>
			<img src ="Images/red_back.png" width="107px" height="150px" class="rotate90">
>>>>>>> 097d9a379443e6f79c26341f5d90bf808022e59e
		</div>
		
		<div class="col-1">
			<p class="col-13">
<<<<<<< HEAD
				<img id="img1" class="image" src ="/Images/ACEofSPADES.png" ondrop="drop(event)" ondragover="allowDrop(event)">
			</p>
			
			<p class="col-13">
				<img id="img2" class="image" src ="/Images/ACEofHEARTS.png">
			</p>
			
			<p class="col-13">
				<img id="img3" class="image" src ="/Images/ACEofCLUBS.png">
			</p>
			
			<p class="col-13">
				<img id="img4" class="image" src ="/Images/ACEofDIAMONDS.png">
=======
				<img src ="Images/red_back.png" width="107px" height="150px" id="b1" onclick="sendMessage('b1')" >
			</p>
			
			<p class="col-13">
				<img src ="Images/red_back.png" width="107px" height="150px" id="b2" onclick="sendMessage('b2')">
			</p>
			
			<p class="col-13">
				<img src ="Images/red_back.png" width="107px" height="150px" id="b3" onclick="sendMessage('b3')">
			</p>
			
			<p class="col-13">
				<img src ="Images/red_back.png" width="107px" height="150px" id="b4" onclick="sendMessage('b4')" >
>>>>>>> 097d9a379443e6f79c26341f5d90bf808022e59e
			</p>
		</div>
		
		<div class="col-1">
			<p class="col-13">
<<<<<<< HEAD
				<img id="img5" class="image" src ="/Images/ACEofDIAMONDS.png">
			</p>
			
			<p class="col-13">
				<img id="img6" class="image" src ="/Images/ACEofSPADES.png">
			</p>
			
			<p class="col-13">
				<img id="img7" class="image" src ="/Images/ACEofHEARTS.png">
			</p>
			
			<p class="col-13">
				<img id="img8" class="image" src ="/Images/ACEofCLUBS.png">
=======
				<img src ="Images/red_back.png" width="107px" height="150px" id="a1" onclick="sendMessage('a1')">
			</p>
			
			<p class="col-13">
				<img src ="Images/red_back.png" width="107px" height="150px" id="a2" onclick="sendMessage('a2')">
			</p>
			
			<p class="col-13">
				<img src ="Images/red_back.png" width="107px" height="150px" id="a3" onclick="sendMessage('a3')">
			</p>
			
			<p class="col-13">
				<img src ="Images/red_back.png" width="107px" height="150px" id="a4" onclick="sendMessage('a4')">
>>>>>>> 097d9a379443e6f79c26341f5d90bf808022e59e
			</p>
		</div>	
			
		<div class="col-15">
<<<<<<< HEAD
			<img class="pileImage" src ="/Images/red_back.png">
			<p ><% out.println("Player 2"); %></p>
=======
			<img src ="Images/red_back.png" width="107px" height="150px" class="rotate90" id="p" onclick="sendMessage('p')">
			<p id="role"></p>
>>>>>>> 097d9a379443e6f79c26341f5d90bf808022e59e
		</div>		

<script type="text/javascript" src="gameAndEvenHandlers.js"></script>
	</body>
</html>