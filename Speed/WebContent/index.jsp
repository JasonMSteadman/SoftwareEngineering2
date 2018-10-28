<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1" content="width=device-width, initial-scale=1">
<!--<link rel="stylesheet" type="text/css" href="../Stylesheets/Site.css"/>-->
		<title>Speed</title>
		
		<style>
			
			body {
    			padding-top: 50px;
    			padding-bottom: 20px;
    			height: 750px;
    			background-color: #cccccc;
    			background-repeat: no-repeat;
    			background-image: radial-gradient(green, mediumseagreen);
			}
						
			[class*="col-"] {
			    float: left;
			    padding: 0px;
			}
			
			[class*="tabs*"] {
			    float: left;
			    width: 100%;
			}
			
			.col-1 {
			    width: 100%;
			    padding-left: 25%;
			}
			
			.col-2 {
			    width: 25%;
			}
			
			.col-3 {
			    width: 75%;
			}
			
			.col-4 {
			    width: 33.33%;
			}
			
			.col-5 {
			    width: 41.66%;
			}
			
			.col-6 {
			    width: 50%;
			}
			
			.col-7 {
			    width: 58.33%;
			}
			
			.col-8 {
			    width: 66.66%;
			}
			
			.col-9 {
			    width: 100%;
			}
			
			.col-10 {
			    width: 85%;
			}
			
			.col-11 {
			    width: 7.5%;
			}
			
			.col-12 {
			    width: 15%;
			}
			
			.col-13 {
			    width: 12.5%;
			}
			
			.col-14 {
				width: 20%;
			}
			
			.col-15 {
				width: 100%;
				padding-left: 43.5%;
			}
			
			.rotate90 {
    			-webkit-transform: rotate(90deg);
    			-moz-transform: rotate(90deg);
    			-o-transform: rotate(90deg);
    			-ms-transform: rotate(90deg);
   				transform: rotate(90deg);
			}
			
			.floatCenter{
				float: center;
			}
			
		</style>
	</head>
		
	<body>
		<!-- <h1 class="col-3"><% out.println("This is Speed!"); %></h1> -->
		
		<div class="col-15">
			<p class="floatCenter"></p>
			<img src ="Images/red_back.png" width="107px" height="150px" class="rotate90">
		</div>
		
		<div class="col-1">
			<p class="col-13">
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
			</p>
		</div>
		
		<div class="col-1">
			<p class="col-13">
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
			</p>
		</div>	
			
		<div class="col-15">
			<img src ="Images/red_back.png" width="107px" height="150px" class="rotate90" id="p" onclick="sendMessage('p')">
			<p id="role"></p>
		</div>		

<script type="text/javascript" src="gameAndEvenHandlers.js"></script>
	</body>
</html>