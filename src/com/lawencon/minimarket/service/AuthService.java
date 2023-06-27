package com.lawencon.minimarket.service;

import java.util.List;

import com.lawencon.minimarket.model.Cart;
import com.lawencon.minimarket.model.Category;
import com.lawencon.minimarket.model.History;
import com.lawencon.minimarket.model.Item;

public interface AuthService {
	Boolean authenticated(String username, String password, List<Category> arrCategory,List<Item> arrItems, List<Cart> arrCarts, List<History> arrHistories  );
}
