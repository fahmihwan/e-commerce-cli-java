package com.lawencon.minimarket.service;

import com.lawencon.minimarket.model.Item;

public interface ItemService {

	public Item create(int id, String name,int price, int categoryId, int qty );
}
