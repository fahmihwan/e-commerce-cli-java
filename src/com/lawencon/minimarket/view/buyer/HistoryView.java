package com.lawencon.minimarket.view.buyer;

import java.util.List;

import com.lawencon.minimarket.model.Cart;
import com.lawencon.minimarket.model.Category;
import com.lawencon.minimarket.model.History;
import com.lawencon.minimarket.model.Item;
import com.lawencon.minimarket.util.ScannerUtil;

public class HistoryView {

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
	
	
	void show(){
		System.out.println("== PEMBELI ==");
		for (int i = 0; i < this.arrHistories.size(); i++) {
			System.out.println(i+ 1+". "+this.arrHistories.get(i).getTransactionId()  + " "+ this.arrHistories.get(i).getTotal() + " "+ " "+ this.arrHistories.get(i).getCreatedAt());
		}
		System.out.println("-- menu --");
		byte chooseMenu = ScannerUtil.inputNumberRangeByte("kembali kemenu beranda[1/0] : ", 1);
		if(chooseMenu == 0) {
			show();
		}
		if(chooseMenu == 1) {
			HomeBuyerView homeBuyerView = new HomeBuyerView();
			homeBuyerView.setState(arrCategories, arrItems, arrCarts, arrHistories);
			homeBuyerView.show();
		}
	}
}
