package com.lawencon.minimarket.service.impl;

import com.lawencon.minimarket.model.Item;
import com.lawencon.minimarket.service.ItemService;

public class ItemServiceImpl implements ItemService {

	@Override
	public Item create(int id, String name,int price, int categoryId, int qty ) {
		Item createItem = new Item();
		createItem.setId(id);
		createItem.setName(name);
		createItem.setPrice(price);
		createItem.setCategoryId(categoryId);
		createItem.setStock(qty);
		return createItem;
	}
	
	
	
	
}
