package com.lawencon.minimarket.constant;

public enum UserConstant {
	
	PENJUAL("penjual","penjual"), PEMBELI("pembeli","pembeli");
	
	public final String username;
	public final String password;
	
	UserConstant(String username, String password){
		this.username = username;
		this.password = password;
	}
}
