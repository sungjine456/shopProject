package com.person.shop.pojo;

public class CheckMessage {
	private boolean check;
	private String message;
	
	public CheckMessage(boolean check, String message){
		this.check = check;
		this.message = message;
	}

	public boolean isCheck() {
		return check;
	}

	public String getMessage() {
		return message;
	}
}
