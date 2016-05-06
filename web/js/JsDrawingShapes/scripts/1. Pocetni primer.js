function initializeDrawing() {
	var c = document.getElementById("myCanvas");
	var ctx = c.getContext("2d");
	
	// Pravougaonik
	ctx.fillStyle = "#FF0000";
	ctx.fillRect(c.width - 150, c.height - 75,150,75);
	
	// Linija
	ctx.moveTo(c.width - 150,  c.height - 75);
	ctx.lineTo(c.width/2 + 150, c.height);
	ctx.stroke();
	
	// Krug
	ctx.beginPath();
	ctx.arc(c.width/2 + 120,c.height - 40,40,0,2*Math.PI);
	ctx.stroke();
	ctx.closePath();
	
	// Luk
	ctx.beginPath();
	ctx.arc(c.width/2 + 120,c.height - 60,40,10,-0.33*Math.PI);
	ctx.stroke();
	ctx.closePath();
	
	// Tekst
	ctx.font = "30px Arial";
	ctx.fillText("Hello World",460,50);
	
	// Gradijent
	var grd = ctx.createLinearGradient(c.width,0,c.width - 150,0);
	grd.addColorStop(0,"blue");
	grd.addColorStop(1,"white");

	ctx.fillStyle = grd;
	ctx.fillRect(c.width - 150,0,150,80);
	
	// Kruzni gradijent
	var grd = ctx.createRadialGradient(285,190,20,285,190,100);
	grd.addColorStop(0,"red");
	grd.addColorStop(1,"white");

	ctx.fillStyle = grd;
	ctx.fillRect(210,150,150,80);
	
	// Slika
	var img=document.getElementById("canvas-image");
	ctx.drawImage(img, c.width - img.width, 0);
}