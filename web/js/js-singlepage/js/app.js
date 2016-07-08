function init() {
	// querySelectorAll() je metoda koja vraca niz elemenata
	// u ovom slucaju, niz svih elemneata koji imaju na sebi
	// klasu menu-item
	var items = document.querySelectorAll('.menu-item');
	
	// sada for petljom prodjemo kroz svaki od njih, 
	// i dodamo im evente
	for(var i=0; i<items.length; i++) {
		// na klik
		items[i].onmousedown = function() {
			// ovde treba da prikazemo odgovarajucu stranicu
			// u odnosu na ono sto je kliknuto
			// 'this' nam daje referencu na samog trenutni objekat
			// sve sto treba da uradimo jeste, da podesimo src iframe-a
			// na trenutnu stranicu
			
			// treba jos samo da proverimo da li
			// element ima atribut page
			if(this.getAttribute('page')) {
				// ako je to uredu, samo podesimo src na iframe-u
				document.querySelector('iframe').src = 
					'pages/' + this.getAttribute('page') + '.html';
			}
		}
		
		// na hover
		items[i].onmouseenter = function() {
			// pitamo se da li ima pod-meni,
			// tj pokusvamo da ga nadjemo, ako ne 
			// metod ce vratiti null ili undefined
			// sto se tumaci kao false
			var s = this.querySelector('.submenu');
			if(s) {
				// ako ima sumbeni treba ga prikazati
				s.style.display = 'inline';
			}
		}
		
		// na leave
		items[i].onmouseleave = function() {
			// isto radimo sto i na hover, 
			// samo sakrivamo pod-meni
			var s = this.querySelector('.submenu');
			if(s) {
				// ako ima sumbeni treba ga prikazati
				s.style.display = 'none';
			}

		}
	}
}