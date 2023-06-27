package com.lawencon.minimarket.view.buyer;

import java.util.List;

import com.lawencon.minimarket.model.Cart;
import com.lawencon.minimarket.model.Category;
import com.lawencon.minimarket.model.History;
import com.lawencon.minimarket.model.Item;
import com.lawencon.minimarket.util.ScannerUtil;
import com.lawencon.minimarket.view.AuthView;

public class HomeBuyerView {
	
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
		System.out.println("== PEMBELI ==");
		System.out.println("--beranda--");
		System.out.println("1. history");
		System.out.println("2. jenis barang");
		System.out.println("3. keranjang");
		System.out.println("4. switch user");
		System.out.println("5. keluar aplikasi");
		byte chooseMenu = ScannerUtil.inputNumberRangeByte("pilih menu : ", 5);
		System.out.println("\n");
		if(chooseMenu == 1){
			HistoryView historyView = new HistoryView();
			historyView.setState(this.arrCategories, this.arrItems, this.arrCarts, this.arrHistories);
			historyView.show();
		}
		if(chooseMenu == 2) {
			OrderView shopView = new OrderView();
			shopView.setState(this.arrCategories, this.arrItems, this.arrCarts, this.arrHistories);
			shopView.show();
		}
		if(chooseMenu == 3) {
			CartView cartView = new CartView();
			cartView.setState(this.arrCategories, this.arrItems, this.arrCarts, this.arrHistories);
			cartView.show();
		}
		if(chooseMenu == 4) {
			AuthView authView = new AuthView();
			authView.setState(this.arrCategories, this.arrItems, this.arrCarts, this.arrHistories);
			authView.show();
		}
		if(chooseMenu == 5) {
			System.out.println("anda telah keluar");
		}
		
	}
	
}
