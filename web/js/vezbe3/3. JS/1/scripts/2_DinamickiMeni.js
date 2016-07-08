function initialize() {

	var menuItems = document.querySelectorAll(".menu-item");
	
	for (var i = 0; i < menuItems.length; i++) {
		menuItems[i].onmouseenter = displaySubmenu;
		menuItems[i].onmouseleave = hideSubmenu;
	}
}

function displaySubmenu() {
	var submenu = this.querySelector(".submenu");
	if (submenu) {
		submenu.style.display = "inline";
	}
}

function hideSubmenu() {
	var submenu = this.querySelector(".submenu");
	if (submenu) {
		submenu.style.display = "none";
	}
}