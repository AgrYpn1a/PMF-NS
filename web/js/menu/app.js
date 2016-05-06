function init() {
	var q = document.querySelectorAll('.menu-item');
	
	for(var i=0; i<q.length; i++) {
		q[i].onmouseenter = function() {
			var sub = this.querySelector('.submenu');
			if(sub) {
				sub.style.display = 'inline';
			}
		};
		
		q[i].onmouseleave = function() {
			var sub = this.querySelector('.submenu');
			if(sub) {
				sub.style.display = 'none';
			}
		};
	}
}
