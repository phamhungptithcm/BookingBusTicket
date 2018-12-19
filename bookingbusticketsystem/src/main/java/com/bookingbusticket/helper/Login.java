package com.bookingbusticket.helper;

public class Login {
	private String userName;
	private String password;
	
	public Login() {
		super();
	}

	public Login(String userName, String password, Boolean checkLogin, String message) {
		super();
		this.userName = userName;
		this.password = password;
	}


	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
