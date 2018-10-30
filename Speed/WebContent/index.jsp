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
			<p class="floatCenter"><% out.println("Player 1"); %></p>
			<img id="test" class="pileImage" src ="/Images/red_back.png" draggable="true" ondragstart="drag(event)">
			<button onclick = "click()">Testing</button>
		</div>
		
		<div class="col-1">
			<p class="col-13">
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
			</p>
		</div>
		
		<div class="col-1">
			<p class="col-13">
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
			</p>
		</div>	
			
		<div class="col-15">
			<img class="pileImage" src ="/Images/red_back.png">
			<p ><% out.println("Player 2"); %></p>
		</div>		

	</body>
</html>