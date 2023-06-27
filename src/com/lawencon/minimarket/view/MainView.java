package com.lawencon.minimarket.view;

import java.util.List;

import com.lawencon.minimarket.model.Cart;
import com.lawencon.minimarket.model.Category;
import com.lawencon.minimarket.model.History;
import com.lawencon.minimarket.model.Item;

import java.util.ArrayList;

public class MainView {

	final List<Category> arrCategories = new ArrayList<Category>();
	final List<Item> arrItems = new ArrayList<Item>();
	final List<Cart> arrCarts = new ArrayList<Cart>();
	final List<History> arrHistories  = new ArrayList<History>();
	 
	 
	public void show() {			
		AuthView authView = new AuthView();
		authView.setState(this.arrCategories, this.arrItems, this.arrCarts, this.arrHistories);
		authView.show();
	}	
}
