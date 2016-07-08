function initializeDrawing() {
	var c = document.getElementById("myCanvas");
	var ctx = c.getContext("2d");
	
	// Pravougaonik
	ctx.fillStyle = "#FF0000";
	ctx.fillRect(0,0,150,75);
	
	// Linija
	ctx.moveTo(150,0);
	ctx.lineTo(300,75);
	ctx.stroke();
	
	// Krug
	ctx.beginPath();
	ctx.arc(350,40,40,0,2*Math.PI);
	ctx.stroke();
	ctx.closePath();
	
	// Luk
	ctx.beginPath();
	ctx.arc(390,40,40,0,0.33*Math.PI);
	ctx.stroke();
	ctx.closePath();
	
	// Tekst
	ctx.font = "30px Arial";
	ctx.fillText("Hello World",460,50);
	
	// Gradijent
	var grd = ctx.createLinearGradient(0,0,200,0);
	grd.addColorStop(0,"blue");
	grd.addColorStop(1,"white");

	ctx.fillStyle = grd;
	ctx.fillRect(10,150,150,80);
	
	// Kruzni gradijent
	var grd = ctx.createRadialGradient(285,190,20,285,190,100);
	grd.addColorStop(0,"red");
	grd.addColorStop(1,"white");

	ctx.fillStyle = grd;
	ctx.fillRect(210,150,150,80);
	
	// Slika
	var img=document.getElementById("canvas-image");
	ctx.drawImage(img, 10, 300);
}