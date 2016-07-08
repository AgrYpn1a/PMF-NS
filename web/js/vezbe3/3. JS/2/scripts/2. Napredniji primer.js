var isDaylightCheckbox, c, ctx, canvasWidth, canvasHeight;
var cloudPosition, cloudSpeed;

function initializeDrawing() {
	isDaylightCheckbox = document.getElementById("isDaylight");
	c = document.getElementById("myCanvas");
	ctx = c.getContext("2d");
	canvasWidth = 1000;
	canvasHeight = 600;
	cloudPosition = 0;
	cloudSpeed = 1;
	setInterval(draw, 50);
}

function draw() {
	if (isDaylightCheckbox.checked) {
		drawDaylight();
	} else {
		drawNight();
	}
}

function drawDaylight() {	
	
	var skyColor = "#26A6EA";
	var sunColor = "#F4ED55";
	var grassColor = "#46A600";
	var flowerColor = "#8026A6";
	
	drawSky(skyColor);	
	drawSun(sunColor);
	drawGrass(grassColor);
	drawCloud();
	drawFlower(flowerColor);
}

function drawNight() {
	var skyColor = "#093953";
	var sunColor = "#F4ED55";
	var grassColor = "#275E00";
	var flowerColor = "#8026A6";
	
	drawSky(skyColor);
	drawGrass(grassColor);
	drawCloud();
	drawFlower(flowerColor);
}

function drawSky(color) {
	ctx.fillStyle = color;
	ctx.fillRect(0, 0, canvasWidth, canvasHeight);
}

function drawSun(color) {
	// Sunce
	ctx.beginPath();
	ctx.arc(750, 230, 100, 0, 2*Math.PI);
	ctx.fillStyle = color;
	ctx.fill();
	ctx.closePath();
	
	// Zraci sunca
	ctx.beginPath();
	ctx.moveTo(492, 235);
	ctx.lineTo(629, 235);
	ctx.moveTo(871, 235);
	ctx.lineTo(1000, 235);
	ctx.moveTo(589, 44);
	ctx.lineTo(666, 135);
	ctx.moveTo(838, 135);
	ctx.lineTo(925, 44);
	ctx.moveTo(589, 408);
	ctx.lineTo(666, 327);
	ctx.moveTo(838, 327);
	ctx.lineTo(925, 408);
	ctx.moveTo(750, 110);
	ctx.lineTo(750, 0);
	ctx.moveTo(750, 352);
	ctx.lineTo(750, 489);
	ctx.strokeStyle = color;
	ctx.lineWidth = 10;
	ctx.stroke();
	ctx.closePath();
}

function drawGrass(color) {
	ctx.fillStyle = color;
	ctx.beginPath();
	ctx.arc(500, 2180, 1900, 0, 2*Math.PI);
	ctx.fill();
	ctx.closePath();
}

function drawCloud() {
	var img=document.getElementById("cloud");
	ctx.drawImage(img, cloudPosition, 50, 350, 159);
	cloudPosition += cloudSpeed;
	if (cloudPosition > canvasWidth + 300)
	{
		cloudPosition = -300;
	}
}

function drawFlower(color) {
	var yellow = "#F4ED55";

	ctx.strokeStyle = "black";
	ctx.lineWidth = 2;
	
	ctx.beginPath();
	ctx.arc(0, 470, 400, -0.07*Math.PI, 0.05*Math.PI, false);	
	ctx.stroke();
	ctx.closePath();
	
	ctx.fillStyle = color;
	ctx.beginPath();
	ctx.arc(355, 400, 20, 0, 2*Math.PI);
	ctx.fill();
	ctx.stroke();
	ctx.closePath();
	ctx.beginPath();
	ctx.arc(390, 420, 20, 0, 2*Math.PI);
	ctx.fill();
	ctx.stroke();
	ctx.closePath();
	ctx.beginPath();
	ctx.arc(425, 400, 20, 0, 2*Math.PI);
	ctx.fill();
	ctx.stroke();
	ctx.closePath();
	ctx.beginPath();
	ctx.arc(425, 360, 20, 0, 2*Math.PI);
	ctx.fill();
	ctx.stroke();
	ctx.closePath();
	ctx.beginPath();
	ctx.arc(390, 340, 20, 0, 2*Math.PI);
	ctx.fill();
	ctx.stroke();
	ctx.closePath();
	ctx.beginPath();
	ctx.arc(355, 360, 20, 0, 2*Math.PI);
	ctx.fill();
	ctx.stroke();
	ctx.closePath();
	
	ctx.fillStyle = yellow;
	ctx.beginPath();
	ctx.arc(390, 380, 20, 0, 2*Math.PI);
	ctx.fill();
	ctx.stroke();
	ctx.closePath();
}
