var commonJs = {
	isEmail : function(email){
		var regex = /[0-9a-zA-Z][_0-9a-zA-Z-]*@[_0-9a-zA-Z-]+(\.[_0-9a-zA-Z-]+){1,2}$/;
		if(email.length < 6 || !regex.test(email)) {
			return false;
		}
		return true;
	}
}