(function(global) {
	
var $ = function() {
	
};

$.prototype = {
	check: function(_f) {
		console.log('Invoked!');
		this.f = _f;
		return this.checkName(this.f) && this.checkPass(this.f) && this.checkPassMatch(this.f);
	},
	
	checkName: function(f) {
		if(f.name.text == '')
			return false;
		
		if(f.name.length >= 6 &&
		  f.name.length <= 10) {
			return true;
		} else {
			return false;
		}
	},
	
	checkPass: function(f) {
		var foundLc = false, 
			foundUc = false,
			foundN  = false;
		
		var pass = f.pass;
		
		for(var i=0; i<pass.length; i++) {
			foundLc = this.isLowerCase(pass[i]);
			foundUc = this.isUpperCase(pass[i]);
			foundN = this.isNumber(pass[i]);
		}
		
		return foundLc && foundUc && foundN;
	},
	
	checkPassMatch: function(f) {
		return f.pass.equals(f.cpass) ? true : false;
	},
	
	isLowerCase: function(c) {
		return (c >= 97 && c <= 122) ? true : false;
	},
	
	isUpperCase: function(c) {
		return (c >= 65 && c <= 90) ? true : false;
	},
	
	isNumber: function(c) {
		return (c >= 0 && c <= 9) ? true : false;
	}
}

global.$ = $;
}(this));

(function validate() {
	return (new $()).check(document.form1);
}());
