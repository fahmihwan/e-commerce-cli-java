package com.lawencon.minimarket.view;

import java.util.List;

import com.lawencon.minimarket.constant.UserConstant;
import com.lawencon.minimarket.model.Cart;
import com.lawencon.minimarket.model.Category;
import com.lawencon.minimarket.model.History;
import com.lawencon.minimarket.model.Item;
import com.lawencon.minimarket.service.impl.AuthServiceImpl;
import com.lawencon.minimarket.util.ScannerUtil;

public class AuthView {

	private List<Category> arrCategories;
	private List<Item> arrItems;
	private List<Cart> arrCarts;
	private List<History> arrHistories;
	
	public void setState(List<Category> arrCategories,List<Item> arrItems, List<Cart> arrCarts, List<History> arrHistories) {
		this.arrCategories = arrCategories;
		this.arrItems = arrItems;
		this.arrCarts = arrCarts;
		this.arrHistories = arrHistories;
	}
	
	public void show() {
		
			Boolean	isAuthenticated = false;
			do {
				System.out.println("== LOGIN ==");
				final String username = ScannerUtil.inputText("username : ");
				final String password = ScannerUtil.inputText("password : ");
			
				if(username.equals(UserConstant.PEMBELI.username) && password.equals(UserConstant.PEMBELI.password) && arrItems.size() == 0) {
					System.out.println("login gagal, mohon penjual masuk terlebih dahulu untuk menambahkan item");
					isAuthenticated = false;
				}else {
					AuthServiceImpl auth = new AuthServiceImpl();
					isAuthenticated = auth.authenticated(username, password, this.arrCategories,this.arrItems, this.arrCarts, this.arrHistories); //authentication
					if(!isAuthenticated) {
						System.out.println("username atau password salah...");
					}
				}
			
			}while(!isAuthenticated);
	}
}
