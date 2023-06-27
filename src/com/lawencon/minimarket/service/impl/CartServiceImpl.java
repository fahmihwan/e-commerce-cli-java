package com.lawencon.minimarket.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import com.lawencon.minimarket.model.Cart;
import com.lawencon.minimarket.model.History;
import com.lawencon.minimarket.model.Item;
import com.lawencon.minimarket.service.CartService;
import com.lawencon.minimarket.util.GenerateUtil;


public class CartServiceImpl implements CartService {

	@Override
	public Boolean addCart(int id, String name, int itemId, int qty, int price, List<Cart> arrCarts, List<Item> arrItems){
		
		//check is stock ready		
		for (int i = 0; i < arrItems.size(); i++) {
			if(arrItems.get(i).getId() == itemId) {
				if(arrItems.get(i).getStock() - qty >= 0) {
					arrItems.get(i).setStock(arrItems.get(i).getStock() - qty);
				}else {
					return false;
				}
			}
		}
		
		//check is duplicate		
		Boolean isNotFound = true;
		int getIndex = 0;
		for (int i = 0; i < arrCarts.size() ; i++) {
			if(arrCarts.get(i).getItemId() == itemId) {
				qty += arrCarts.get(i).getQty();
				isNotFound = false;
				getIndex = arrCarts.indexOf(arrCarts.get(i));
				break;
			}else {
				isNotFound = true;
			}
		}
		
		if(isNotFound) {
			final Cart createCart = new Cart();
			createCart.setId(id);
			createCart.setName(name);
			createCart.setItemId(itemId);
			createCart.setQty(qty);;
			createCart.setPrice(price);
			arrCarts.add(createCart);
		}else {
			arrCarts.get(getIndex).setQty(qty);;
		}
		return true;
	}
	
	@Override
	public void deleteCart(List<Cart> arrCarts, List<Item> arrItems, int chooseItem) {
		//		cancel order
		int ItemId = arrCarts.get(chooseItem - 1).getItemId();
		int currentQtyCart = arrCarts.get(chooseItem - 1).getQty();
		for (int i = 0; i < arrItems.size(); i++) {
			if(arrItems.get(i).getId() == ItemId) {
				arrItems.get(i).setStock(currentQtyCart + arrItems.get(i).getStock());
			}
		}
		arrCarts.remove(chooseItem - 1);
	}
	
	@Override
	public void editQty(List<Cart> arrCarts, List<Item> arrItems, int chooseItem) {
		
	}
	
	@Override
	public void checkout(List<Cart> arrCarts, List<History> arrHistories) {
		int grantTotal = 0;
		for (int i = 0; i < arrCarts.size(); i++) {
			grantTotal += arrCarts.get(i).getQty() * arrCarts.get(i).getPrice();
 		}
        LocalDateTime currentDateTime = LocalDateTime.now(); 
		History history = new History();
		history.setTransactionId(GenerateUtil.generateRandomCode());
		history.setTotal(grantTotal);
		history.setCreatedAt(currentDateTime);
		
		arrHistories.add(history);	
		arrCarts.clear();
	}
}
