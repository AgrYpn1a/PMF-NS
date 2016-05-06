var isDaylightCheckbox, c, ctx, canvasWidth, canvasHeight;
var imgs = [];
var positions = [];

function initializeDrawing() {
	isDaylightCheckbox = document.getElementById("isDaylight");
	c = document.getElementById("myCanvas");
	ctx = c.getContext("2d");
	canvasWidth = c.width;
	canvasHeight = c.height;
	
	positions[0] = 200;
	positions[1] = 100;
	positions[2] = 320;

	setInterval(draw, 50);
}

function draw() {
	if (isDaylightCheckbox.checked) {
		drawDaylight();
	} else {
		drawNight();
	}
	
	for(var i=0; i<positions.length; i++) {
		if(positions[i] > canvasWidth)
			positions[i] = -imgs[i].width;
	}
	
	positions[0] += 2;
	positions[1] += 4;
	positions[2] += 3;
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

// TODO
function drawSky(color) {
	ctx.fillStyle = color;
	ctx.fillRect(0, 0, c.width, c.height);
}

// TODO
function drawSun(color) {
}

// TODO
function drawGrass(color) {
	ctx.beginPath();
	ctx.arc(canvasWidth/2, canvasHeight + 300, 600,0,2*Math.PI);
	ctx.stroke();
	ctx.closePath();
	ctx.fillStyle = color;
	ctx.fill();
}

// TODO
function drawCloud() {
	this.imgs[0] = document.getElementById("cloud");
	this.imgs[1] = document.getElementById("cloud2");
	this.imgs[2] = document.getElementById("cloud3");

	ctx.drawImage(imgs[0], positions[0], 240, 
				  imgs[0].width/2, imgs[0].height/2);
	ctx.drawImage(imgs[1], positions[1], 0, 
				  imgs[1].width/1.4, imgs[1].height/1.4);
	ctx.drawImage(imgs[2], positions[2], 120, 
				  imgs[0].width/3, imgs[2].height/3);
	
}

// TODO
function drawFlower(color) {
}
