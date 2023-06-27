package com.lawencon.minimarket.service.impl;

import java.util.List;

import com.lawencon.minimarket.constant.UserConstant;
import com.lawencon.minimarket.model.Cart;
import com.lawencon.minimarket.model.Category;
import com.lawencon.minimarket.model.History;
import com.lawencon.minimarket.model.Item;
import com.lawencon.minimarket.service.AuthService;
import com.lawencon.minimarket.view.buyer.HomeBuyerView;
import com.lawencon.minimarket.view.seller.HomeSellerView;

public class AuthServiceImpl implements AuthService{

	@Override
	public Boolean authenticated(String username, String password, List<Category> arrCategory, List<Item> arrItems, List<Cart> arrCarts, List<History> arrHistories ){
		
		if(username.equals(UserConstant.PENJUAL.username) && password.equals(UserConstant.PENJUAL.password)) {
			HomeSellerView homeSellerView = new HomeSellerView();
			homeSellerView.setState(arrCategory,arrItems, arrCarts, arrHistories);
			homeSellerView.show();
			return true;
		}
		if(username.equals(UserConstant.PEMBELI.username) && password.equals(UserConstant.PEMBELI.password)) {
			HomeBuyerView homeBuyerView = new HomeBuyerView();
			homeBuyerView.setState(arrCategory,arrItems, arrCarts, arrHistories);
			homeBuyerView.show();
			return true;
		}

		return false;
	}
}
