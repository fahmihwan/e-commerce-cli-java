package com.lawencon.minimarket.service;

import java.util.List;

import com.lawencon.minimarket.model.Cart;
import com.lawencon.minimarket.model.History;
import com.lawencon.minimarket.model.Item;

public interface CartService {

	public Boolean addCart(int id, String name,int itemId, int qty, int price,List<Cart> arrCarts,List<Item> arrItems);

	public void deleteCart(List<Cart> arrCarts, List<Item> arrItems, int chooseItem);
		
	public void checkout(List<Cart> arrCarts,List<History> arrHistories);
	
	public void editQty(List<Cart> arrCarts, List<Item> arrItems, int chooseItem);
}
