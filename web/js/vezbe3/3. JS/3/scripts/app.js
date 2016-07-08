var current = '';

function init() {
	var q = document.querySelectorAll('.menu-item');
	var r = document.querySelectorAll('.page');
	
	for(var i=0; i<r.length; i++)
		if(r[i].style.display)	
			current = r[i].getAttribute('id');
	
	for(var i=0; i<q.length; i++) {
		if(q[i].parentElement.getAttribute('divid')) {
			q[i].onmousedown = function() {
				var divid = this.parentElement.getAttribute('divid');
				for(var i=0; i<r.length; i++) {
					if(r[i].getAttribute('id') === divid) {
						r[i].style.display = 'block';
						current = divid;
					}
					else
						r[i].style.display = 'none';
				}
			};
		}
		
		q[i].onmouseenter = function() {
			// handle drop down menu if exists
			var sub = this.querySelector('.submenu');
			if(sub)
				sub.style.display = 'inline-block';
		};
		
		q[i].onmouseleave = function() {
			// handle drop down menu if exists
			var sub = this.querySelector('.submenu');
			if(sub)
				sub.style.display = 'none';
			
		};
	}
}