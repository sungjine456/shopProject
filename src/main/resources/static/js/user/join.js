var join = {
	form : $("#form"),
	pw : $("#form #password"),
	pwConfirm : $("#form #passwordConfirm"),
	email : $("#form #email"),
	name : $("#form #name"),
	joinBtn : $("#form #joinBtn"),
	emailBool : $("#form #emailBool"),
	passwordBool : $("#form #passwordBool"),
	emailSpan : $("#form #emailSpan"),
	passwordSpan : $("#form #passwordSpan"),
	joinEvent : function(){
		if(this.email.val() === "") {
			alert("이메일을 입력해주세요.");
			this.email.focus();
			return false;
		}
		if(!commonJs.isEmail(this.email.val())) {
			alert("올바른 형식의 이메일을 확인해주세요.");
			this.email.focus();
			return false;
		}
		if(this.pw.val() === ""){
			alert("비밀번호를 입력해주세요.");
			this.pw.focus();
			return false;
		}
		if(this.pwConfirm.val() === ""){
			alert("비밀번호확인을 입력해주세요.");
			this.pwConfirm.focus();
			return false;
		}
		if(this.pw.val().length < 6 && this.pwConfirm.val().length < 6){
			alert("비밀번호는 6자 이상 입력해주세요.");
			this.pw.focus();
			return false;
		}
		if(this.pw.val() !== this.pwConfirm.val()){
			alert("비밀번호확인을 다시 입력해주세요.");
			this.pw.focus();
			return false;
		}
		if(this.name.val() === "") {
			alert("이름을 입력해주세요.");
			this.name.focus();
			return false;
		}
		if(this.passwordBool.val() === "false"){
			alert("비밀번호를 확인해주세요");
			this.pw.focus();
			return false;
		}
		if(this.emailBool.val() === "false"){
			alert("이메일을 확인해주세요");
			this.email.focus();
			return false;
		}
		this.form.submit();
	},
	passwordCheckEvent : function(){
		if(this.pw.val().length < 6 && this.pwConfirm.val().length < 6){
			this.passwordBool.val("false");
			this.passwordSpan.html("<font style='color:red'>비밀번호는 6자 이상 입력해주세요.</font>");
		} else if(this.pw.val() !== this.pwConfirm.val()){
			this.passwordBool.val("false");
			this.passwordSpan.html("<font style='color:red'>비밀번호가 일치하지 않습니다.</font>");
		} else if(this.pw.val() === this.pwConfirm.val()){
			this.passwordBool.val("true");
			this.passwordSpan.html("<font style='color:blue'>비밀번호가 일치합니다.</font>");
		}
	},
	emailCheckEvent : function(){
		$.ajax({
			url : "/join/emailCheck",
			type : "POST",
			data : {"email" : this.email.val()},
			dataType : "JSON",
			success : function(data){
				if(data.bool === "true"){
					join.emailBool.val("true");
					join.emailSpan.html("<font style='color:blue'>"+data.message+"</font>");
				} else {
					join.emailBool.val("false");
					join.emailSpan.html("<font style='color:red'>"+data.message+"</font>");
				}
			},
			error : function(x, e){
				$(location).attr("href", "/join");
			}
		});
	},
	init : function(){
		var self = this;
		self.joinBtn.click(function(){self.joinEvent();});
		self.pw.keyup(function(){self.passwordCheckEvent();});
		self.pwConfirm.keyup(function(){self.passwordCheckEvent();});
		self.email.keyup(function(){self.emailCheckEvent();});
	}
}

join.init();