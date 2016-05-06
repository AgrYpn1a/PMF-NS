var container;
var counter = 0;

function init() {
	container = document.getElementById('container');
}

function addSquare() {
	this.counter++;
	
	var square = document.createElement('div');
	square.setAttribute('class', 'square');
	square.innerHTML = '' + this.counter;
	square.onclick = deleteSquare;
	
	container.appendChild(square);
}

function deleteSquare() {
	container.removeChild(this);
}

var o = (function() {
	return
	{
		name: 'John Doe'	
	}
}());

console.log(o);