package com.person.shop.exception;

public class PasswordAndPasswordConfirmDoNotMatchException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public PasswordAndPasswordConfirmDoNotMatchException(){
		super("비밀번호와 비밀번호 확인이 일치하지 않습니다.");
	}
}
