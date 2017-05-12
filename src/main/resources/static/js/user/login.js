var login = {
    form : $("#form"),
    translateForm : $("#translateForm"),
    email : $("#form #email"),
    password : $("#form #password"),
    checkBox : $("#form #idSaveCheck"),
    loginBtn : $("#form #loginBtn"),
    translateEmail : $("#translateForm #translateEmail"),
    translatePasswordBtn : $("#translateForm #translatePasswordBtn"),
    enterEvent : function(){
        if(event.keyCode === 13){
            this.loginEvent();
        }
    },
    loginEvent : function(){
    	var passwordVal = this.password.val();
    	if(this.email.val() === ""){
    		alert("이메일을 입력해주세요.");
    		this.email.focus();
    		return false;
    	}
        if(!commonJs.isEmail(this.email.val())){
            alert("이메일을 확인해주세요.");
            this.email.focus();
            return false;
        }
        if(passwordVal === ""){
            alert("패스워드를 입력해주세요.");
            this.password.focus();
            return false;
        }
        if(passwordVal.length < 6 || passwordVal.length > 15){
            alert("비밀번호는 6자 이상 15자 이하로 입력하셔야 합니다.");
            this.password.focus();
            return false;
        }
        this.form.submit();
    },
    tramslatePasswordEvent : function(){
        if(this.translateEmail.val() === ""){
            alert("이메일을 입력해주세요");
            this.translateEmail.focus();
            return false;
        }
        if(!commonJs.isEmail(this.translateEmail.val())){
            alert("이메일을 확인해주세요.");
            this.translateEmail.focus();
            return false;
        }
        translateForm.submit();
    },
    init : function(){
        var self = this;
        self.loginBtn.click(function(){self.loginEvent();});
        self.translatePasswordBtn.click(function(){self.tramslatePasswordEvent();});
        self.email.keyup(function(){self.enterEvent();});
        self.password.keyup(function(){self.enterEvent();});
    }
};

login.init();