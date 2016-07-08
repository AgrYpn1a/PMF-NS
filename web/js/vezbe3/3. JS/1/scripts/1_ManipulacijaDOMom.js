var kontejner;
var counter = 0;

function inicijalizuj() {
	kontejner = document.getElementById("container");
}

function dodajKvadrat() {
	counter++;
	
	var kvadrat = document.createElement("div");
	kvadrat.setAttribute("class", "kvadrat");
	kvadrat.innerHTML = counter;
	kvadrat.onclick = obrisiKvadrat;
	
	kontejner.appendChild(kvadrat);
}

function obrisiKvadrat() {
	kontejner.removeChild(this);
}