function init() {
	var items = document.querySelectorAll('.menu-item');

	for (var i = 0; i < items.length; i++) {
		items[i].onmouseenter = function () {
			var sub = this.querySelector('.submenu');
			if (sub) {
				sub.style.display = 'inline';
			}
		};

		items[i].onmouseleave = function () {
			var sub = this.querySelector('.submenu');
			if (sub) {
				sub.style.display = 'none';
			}
		};
	}
}